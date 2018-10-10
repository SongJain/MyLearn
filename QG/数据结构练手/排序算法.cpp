
#include<iostream>
using namespace std;
/*
void BubbleSorting(int a[] , int n)冒泡 
{
	for(int i = 0; i < n-1; i++)
	{
		for(int j = 0; j < n-1-i; j++)
		{
			if(a[j] > a[j+1])
			{
				int tmp = a[j];
				a[j] = a[j+1];
				a[j+1] = tmp;
			}
		}
	}	
}*/


/*
void QuickSort(int a[] , int left ,int right)
{
	if(left > right)
	{
		return;
	}
	int i , j ,tmp;
	i = left;
	j = right;	
	tmp = a[left]; //哨兵
	6
	while(i != j) //哨兵不能碰面 
	{
		while(a[j] <= tmp && i < j) //先移动右边的哨兵 
		{
			j--;
		}
		while(a[i] >= tmp && i < j)
		{
			i++;
		}
		if(i < j)
		{
			int k = a[i];
			a[i] = a[j];
			a[j] = k;
		}
	}
	
	a[left] = a[j];
	a[j] = tmp;
	
	QuickSort(a ,left,i-1);
	QuickSort(a ,i+1,right);
} 
 */
/*void quickSort(int array[], int left, int right){
	if (left > right){
		return;
	}
	int i, j, temp;
	i = left;
	j = right;
	//以最左边的数作为基准数
	temp = array[left];
	while (i != j){
		//先从右边开始找小于temp的元素  注意等号
		while (array[j] >= temp && i < j) {
			j--;
		}
		//再从左边开始找大于temp的元素
		while (array[i] <= temp && i < j){
			i++;
		}
		//左右哨兵均找到满足要求的数后，交换这两个数
		if (i < j){
			int change = array[i];
			array[i] = array[j];
			array[j] = change;
		}
	}
	//i==j  将基准数归位，此时基准数左边的数均小于基准数，右边的数均大于基准数
	array[left] = array[j];
	array[j] = temp;
	
	//然后递归处理基准左边未排序的数，和基准右边的数
	quickSort(array, left, i-1);
	quickSort(array, i + 1, right);
 
}
*/

/*void ChoiceSort(int a[] , int N)
{
	for (int i = 0; i < N; i++)
	{
		int k = i;
		for (int j = k + 1; j < N; j++)
		{
			if (a[j] < a[k])
			{
				k = j;
			}
		}
		//找到了最小的值再交换
		int temp = a[i];
		a[i] = a[k];
		a[k] = temp;
	}
}
*/
/*
void InsertSort(int a[] ,int N)
{
	//从第二个元素开始，加入第一个元素是已排序数组
	for (int i = 1; i < N; i++){
		//待插入元素 array[i]
		if (a[i] < a[i - 1]){
			int wait = a[i];
			int j = i;
			while (j > 0 && a[j - 1] > wait){
				//从后往前遍历已排序数组，若待插入元素小于遍历的元素，则遍历元素向后挪位置
				a[j] = a[j - 1];
				j--;
			}
			a[j] = wait;
		}
	}
}*/

void Merge(int *arr, int n)
{
    int temp[n];    // 辅助数组
    int b = 0;  // 辅助数组的起始位置
    int mid = n / 2;    // mid将数组从中间划分，前一半有序，后一半有序
    int first = 0, second = mid;    // 两个有序序列的起始位置
 
    while (first < mid && second < n)
    {
        if (arr[first] <= arr[second])   // 比较两个序列
            temp[b++] = arr[first++];
        else
            temp[b++] = arr[second++];
    }
 
    while(first < mid)               // 将剩余子序列复制到辅助序列中
            temp[b++] = arr[first++];
    while(second < n)
            temp[b++] = arr[second++];
    for (int i = 0; i < n; ++i)    // 辅助序列复制到原序列
        arr[i] = temp[i];
}

void MergeSort(int* s, int Num) 
{
	if(n <= 1) //递归法的出口 
		return;
	if(n > 1)
	{
		MergeSort(a ,n/2);
		MergeSort(a + n/2 ,n - n/2);
		Merge(a , n);  //归并两部分 
	}
}


int main()
{
	int a[10] = {3,32,2,5,5,6,46,6,2,1};
	//BubbleSorting(a,10);
	//QuickSort(a,0,9);
	//ChoiceSort(a,10); 
	//InsertSort(a ,10);
	for(int i = 0;i < 10;i++)
	{
		cout<<a[i]<<" ";
	}
	return 0;
}
