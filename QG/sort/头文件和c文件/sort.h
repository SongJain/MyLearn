#ifndef SORT_H_INCLUDED
#define SORT_H_INCLUDED


#define DATAONE  10000
#define DATATWO  50000
#define DATATHREE  200000


typedef struct stackNode{  //快排非递归算法需要使用的栈节点
    int low;
    int high;
}stackNode;

//插入
void insertion_sort(int array[], int length);

//快排
void quick_sort(int array[], int length);
void quick_sortRe(int array[], int left, int right);

//快排非递归
void QuickSort_NO(int array[],int length);
void QuickSort_Nore(int array[],int aLow,int aHigh,int length);
int split(int array[],int low,int high);


//归并
void merge_sort(int array[], int length);//辅助
void merge_sort_recursive(int array[], int reg[], int start, int end);

//计数排序
void counting_sort(int array[], int length);

int maxbit(int data[], int n);//求数组最大数据的位数
void radix_sort(int data[], int n);   //基数排序

int testSortTime(void (foo)(int array[],int length),int length);
void printTest(char *name);


#endif // SORT_H_INCLUDED
