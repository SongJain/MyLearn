#include <stdio.h>
#include <windows.h>

void swap1(int *a, int *b)    
{  
    int temp;  
  
    temp = *a;  
    *a = *b;  
    *b = temp;  
  
    return ;  
}
int helper(int *num,int left,int right,int k)
{
	if(left == right)
	{
		return num[left];
	}
	
	int i = left,j = right;
	int pivot = num[(i + j) / 2];    //中间值 
	while(i < j)    //使小于pivot的数放左边，大于的放右边 
	{
		while(i <= j && num[i] < pivot)    //从左边找到第一个比中间值大的数 
		{
			i++;
		}
		while(i <= j && num[j] > pivot)    //从右边找到第一个比中间值小的数 
		{
			j--;
		} 
		if(i <= j)
		{
			swap1(&num[i],&num[j]);
			i++;
			j--;
		}
	}
	if(left + k - 1 <= j)
	{
		return helper(num,left,j,k);
	}
	if(left + k - 1 <  i)
	{
		return num[left + k - 1]; 
	}
	return helper(num,i,right,k - (i - left));
}

int kthLargestElement(int k,int *num,int n)
{
	return helper(num,0,n - 1,n-k+1);
}



void colorSelect(int num[],int length)
{
    int begin = 0;
    int end = length-1;
    int cur;
    int temp,i;

    for(cur=0;cur<end;)
    {
        if(1==num[cur])
        {
            cur++;
            continue;
        }

        else if(0==num[cur])
        {
            temp=num[cur];
            num[cur]=num[begin];
            num[begin]=temp;
            begin++;
            cur++;
        }
        else
        {
            temp=num[cur];
            num[cur]=num[end];
            num[end]=temp;
            end--;
        }
    }

}
int main()
{
    int i,k,l,num,tp;
    int num1,num2;
	printf("|************menu************|\n");
	printf("|1、颜色排序                 |\n");	
	printf("|2、第k大排序                |\n");	
	printf("|****************************|\n");
	
	while(num != 8)
	{	
		printf("请输入选择：（输入8结束）");
		scanf("%d",&num);
		if(num == 1)
		{
			printf("请输入数组个数：");
	    	scanf("%d",&k);
	    	int num[k];
	    	printf("请输入数组(若为颜色排序则0 1 2)：");
	    	for(i = 0; i < k;i ++)
	    	{
	    		scanf("%d",&tp);
	    		num[i] = tp;
	    		
			}
			int length1 = sizeof(num)/sizeof(num[0]);
			colorSelect(num,length1);
			for(i=0;i<length1;i++)
	    	{
	    		printf("%d ",num[i]);
	    	}
	   		printf("\n");
	   		continue;
	   	}
	   	if(num == 2)
	   	{
	   		printf("请输入数组个数：");
	    	scanf("%d",&k);
	    	int num[k];
	    	printf("请输入数组(若为颜色排序则0 1 2)：");
	    	for(i = 0; i < k;i ++)
	    	{
	    		scanf("%d",&tp);
	    		num[i] = tp;	    		
			}
			printf("你想得到第几大元素?:\n");
			int k;
			scanf("%d",&k); 
			int x= kthLargestElement(k,num,tp);
			printf("第%d大为%d\n",k,x);
			continue;
		}
	}
	return 0; 
	system("pause");	
}

