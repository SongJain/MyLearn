#include <stdio.h>
#include <stdlib.h>
#include "sort.h"

void insertion_sort(int array[], int length)
{
        int i, j, temp;

        for (i = 1; i < length; i++)
        {
                temp = array[i];
                j = i - 1;
                for ( ; j >= 0 && array[j] > temp; j--)
                {
                        array[j+1] = array[j];
                }
                array[j+1] = temp;
        }
}




void quick_sortRe(int array[], int left, int right)
{
        int i = left, j = right;
        int temp;
        int pivot;

        // 基准点设置为中间元素，当然也可以选择其它元素作为基准点
        pivot = array[(left + right) / 2];

        while (i <= j)
        {
                // 找到左边大于等于基准点的元素
                while (array[i] < pivot)
                {
                        i++;
                }
                // 找到右边小于等于基准点的元素
                while (array[j] > pivot)
                {
                        j--;
                }
                // 如果左边下标小于右边，则互换元素
                if (i <= j)
                {
                        temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                        i++;
                        j--;
                }
        }

        //递归
        if (left < j)
        {
                quick_sortRe(array, left, j);
        }

        if (i < right)
        {
                quick_sortRe(array, i, right);
        }
}

void quick_sort(int array[],int length)
{
    quick_sortRe(array, 0, length-1);
}



//快排非递归
int split(int array[],int low,int high)
{
    int i=low,j;
    int x=array[low];
    int tmp = 0;
    for(j = low+1;j <= high;j++)
    {
        if(array[j] > x)
        {
            i++;
            if(i!=j)
            {
                tmp = array[j];
                array[j]=array[i];
                array[i]=tmp;
            }
        }
    }
    tmp = array[low];
    array[low] = array[i];
    array[i] = tmp;
    return i;
}

void QuickSort_Nore(int array[],int aLow,int aHigh,int length)
{
    int i,w;
    stackNode *st = (stackNode*) malloc(sizeof(stackNode)*length);

    if( !st ){
        printf("内存分配故障！");
        exit(0);
    }

    int top= -1,low,high;
    top++;
    st[top].low=aLow;
    st[top].high=aHigh;
    while(top>-1)
    {
        low=st[top].low;high=st[top].high;
        top--;

        if(low<high)
        {
            w=split(array,low,high);

            st[++top].low=low;
            st[top].high=w-1;

            st[++top].low=w+1;
            st[top].high=high;
        }
    }

    free(st);
}

void QuickSort_NO(int array[],int length)
{
    QuickSort_Nore(array,0,length-1,length);
}


void merge_sort_recursive(int array[], int reg[], int start, int end)
{
        if (start >= end)
        {
                return;
        }

        int k = start;
        int length = end - start;
        int mid = (length / 2) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;

        merge_sort_recursive(array, reg, start1, end1);
        merge_sort_recursive(array, reg, start2, end2);

        while (start1 <= end1 && start2 <= end2)
        {
                reg[k++] = array[start1] < array[start2] ? array[start1++] : array[start2++];
        }

        while (start1 <= end1)
        {
                reg[k++] = array[start1++];
        }

        while (start2 <= end2)
        {
                reg[k++] = array[start2++];
        }

        for (k = start; k <= end; k++)
        {
                array[k] = reg[k];
        }
}

void merge_sort(int array[], int length)
{
        int reg[length];
        merge_sort_recursive(array, reg, 0, length-1);
}

//计数排序
void counting_sort(int array[], int length)
{
        int i, max;
        int *buffer = NULL;
        int *sorted = NULL;

        max = array[0];
        for (i = 1; i < length; i++)
        {
                if (array[i] > max)
                {
                        max = array[i];
                }
        }

        buffer = (int *)malloc((max + 1) * sizeof(int));
        for (i = 0; i < max + 1; i++)
        {
                buffer[i] = 0;
        }

        for (i = 0; i < length; i++)
        {
                buffer[array[i]]++;
        }

        for (i = 1; i < max+1; i++)
        {
                buffer[i] += buffer[i-1];
        }

        sorted = (int *)malloc(length * sizeof(int));
        for (i = length; i > 0; i--)
        {
                sorted[--buffer[array[i-1]]] = array[i-1];
        }

        for (i = 0; i < length; i++)
        {
                array[i] = sorted[i];
        }

        free(buffer);
        free(sorted);
}



//基数排序
int maxbit(int data[], int n) //辅助函数，求数据的最大位数
{
    int max = 1,i; //保存最大的位数
    int p = 10;
    for(i = 0; i < n; ++i)
    {
        while(data[i] >= p)
        {
            p *= 10;
            ++max;
        }
    }
    return max;
}
void radix_sort(int data[], int n)   //基数排序
{
    int max = maxbit(data, n);   //数组中的元素的最大位数
    int *tmp = (int *)malloc(n * sizeof(int));
    int *count = (int *)malloc(10 * sizeof(int));   //计数器
    int i, j, k;
    int radix = 1;

    for(i = 1; i <= max; i++)//进行d次排序
    {
        for(j = 0; j < 10; j++)
        {
            count[j] = 0;      //每次分配前清空计数器

        }

        for(j = 0; j < n; j++)
        {
            k = (data[j] / radix) % 10;   //计算每次循环某一位的数字
            count[k]++;    //统计每个桶中的记录数
        }

        for(j = 1; j < 10; j++)//第j个桶以及之前所有桶中元素的总数
        {
            count[j] = count[j - 1] + count[j];
        }

        for(j = n - 1; j >= 0; j--) //将所有桶中记录依次收集到tmp中
        {
            k = (data[j] / radix) % 10;
            tmp[count[k] - 1] = data[j];
            count[k]--;
        }

        for(j = 0; j < n; j++)   //将临时数组的内容复制到data中
        {
            data[j] = tmp[j];
        }
        radix = radix * 10;
    }
    free(tmp);
    free(count);
}
