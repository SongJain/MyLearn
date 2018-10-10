#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "sort.h"

extern int A;

int testSortTime(void (foo)(int array[],int length),int length)
{

    int  i;
    time_t t;
    srand((unsigned)time(&t));

    int *test = (int *)malloc(length * sizeof(int));

    clock_t start;
    clock_t diff=0;
    clock_t diff1;

    if(A<18)
    {
        //生成伪随机数
        for(i = 0;i < length; i++)
        {
            test[i] = rand()*1000 % 30000000;   //产生30000内的随机数
        }
        start = clock();
        foo(test, length);
        diff = clock() - start;
    }

    else
    {
        for(i=0;i<100000;i++)
        {
            for(i = 0;i < length; i++)
            {
                test[i] = rand()*1000 % 30000000;   //产生30000内的随机数值

            }
            start = clock();
            foo(test, length);
            diff1 = clock()-start;
            diff+=diff1;
        }

    }
    A++;

    free(test);
    return diff;
}


void printTest(char *name)
{
    FILE *fp;

    int time1, time2, time3, time4,time5,time6;  //10000
    int time7, time8,time9, time10,time11,time12;  //50000
    int time13, time14,time15,time16,time17,time18;  //200000

    int time19,time20,time21,time22,time23,time24; //小数组排序
    int num=100;


    if ((fp = fopen(name, "a")) == NULL)
    {
            printf("打开文件失败！\n");
            exit(EXIT_FAILURE);
    }

    printf("正在生成测试数据用时表格，请耐心等待…………\n\n");

    printf("------------------------------------------------------------------\n");
    printf("    |    算法    | 10000个数据 | 50000个数据  |  200000个数据 |\n");
    printf("------------------------------------------------------------------\n");

    time1=testSortTime(insertion_sort,DATAONE);
    time7=testSortTime(insertion_sort,DATATWO);
    time13=testSortTime(insertion_sort,DATATHREE);

    printf("    |    插入    |    %dms     |    %dms    |   %dms     |\n",time1,time7,time13);
    printf("------------------------------------------------------------------\n");

    time2=testSortTime(merge_sort,DATAONE);
    time8=testSortTime(merge_sort,DATATWO);
    time14=testSortTime(merge_sort,DATATHREE);

    printf("    |    归并    |     %dms     |     %dms      |     %dms      |\n",time2,time8,time14);
    printf("------------------------------------------------------------------\n");

    time3=testSortTime(counting_sort,DATAONE);
    time9=testSortTime(counting_sort,DATATWO);
    time15=testSortTime(counting_sort,DATATHREE);

    printf("    |    计数    |   %dms     |     %dms      |      %dms      |\n",time3,time9,time15);
    printf("------------------------------------------------------------------\n");

    time4=testSortTime(radix_sort,DATAONE);
    time10=testSortTime(radix_sort,DATATWO);
    time16=testSortTime(radix_sort,DATATHREE);

    printf("    |    基数    |     %dms     |     %dms      |      %dms     |\n",time4,time10,time16);
    printf("------------------------------------------------------------------\n");

    time5=testSortTime(quick_sort, DATAONE);
    time11=testSortTime(quick_sort, DATATWO);
    time17=testSortTime(quick_sort, DATATHREE);

    printf("    | 快排(递归) |    %dms      |     %dms      |     %dms      |\n",time5,time11,time17);
    printf("------------------------------------------------------------------\n");

    time6=testSortTime(QuickSort_NO, DATAONE);
    time12=testSortTime(QuickSort_NO, DATATWO);
    time18=testSortTime(QuickSort_NO, DATATHREE);


    printf("    | 快排(非递) |    %dms     |     %dms     |     %dms      |\n",time6,time12,time18);
    printf("------------------------------------------------------------------\n");

    printf("\n\n");
    printf("------------------------------------------------------------------\n");
    printf("----------------测试100*100k的小数组排序--------------------\n");
    printf("------------------------------------------------------------------\n");
    printf("    |    算法    |  插入排序  |  归并排序  |   计数排序  |   基数排序  |   快排递归  |   快排非递归  |\n");

    time19=testSortTime(insertion_sort,num);
    time20=testSortTime(merge_sort,num);
    time21=testSortTime(counting_sort,num);
    time22=testSortTime(radix_sort,num);
    time23=testSortTime(quick_sort, num);
    time24=testSortTime(QuickSort_NO, num);
    printf("    |            |  %dms  |  %dms  |  %dms  |  %dms  |  %dms  |  %dms  |\n",time19,time20,time21,time22,time23,time24);
    printf("------------------------------------------------------------------\n");


    fprintf(fp, "------------------------------------------------------------------\n");
    fprintf(fp, "    |    算法    | 10000个数据 | 50000个数据  |  200000个数据 |\n");
    fprintf(fp,"------------------------------------------------------------------\n");
    fprintf(fp, "    |    插入    |    %dms     |    %dms    |   %dms     |\n",time1,time7,time13);
    fprintf(fp,"------------------------------------------------------------------\n");
    fprintf(fp, "    |    归并    |     %dms     |     %dms      |     %dms      |\n",time2,time8,time14);
    fprintf(fp,"------------------------------------------------------------------\n");
    fprintf(fp, "    |    计数    |   %dms     |     %dms      |      %dms      |\n",time3,time9,time15);
    fprintf(fp,"------------------------------------------------------------------\n");
    fprintf(fp, "    |    基数    |     %dms     |     %dms      |      %dms     |\n",time4,time10,time16);
    fprintf(fp,"------------------------------------------------------------------\n");
    fprintf(fp, "    | 快排(递归) |    %dms      |     %dms      |     %dms      |\n",time5,time11,time17);
    fprintf(fp,"------------------------------------------------------------------\n");
    fprintf(fp, "    | 快排(非递) |    %dms     |     %dms     |     %dms      |\n",time6,time12,time18);
    fprintf(fp,"------------------------------------------------------------------\n");

    fprintf(fp,"\n\n");
    fprintf(fp,"------------------------------------------------------------------\n");
    fprintf(fp,"----------------测试100*100k的小数组排序--------------------\n");
    fprintf(fp,"------------------------------------------------------------------\n");
    fprintf(fp,"    |    算法    |  插入排序  |  归并排序  |   计数排序  |   基数排序  |   快排递归  |   快排非递归  |\n");
    fprintf(fp,"    |            |  %dms  |  %dms  |  %dms  |  %dms  |  %dms  |  %dms  |\n",time19,time20,time21,time22,time23,time24);
    fprintf(fp,"------------------------------------------------------------------\n");

    fclose(fp);

}
