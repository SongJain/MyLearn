#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>
#include <ctype.h>
#include "MyQUEUE.h"

#define MAXQUEUE 10
#define queue_entry(ptr, type, member) \
        ((type *)((char *)(ptr)-(unsigned long)(&((type *)0)->member)))

int CycleQueue(size_t data_size)    //循环队列 
{
	int x;
	AQueue *Q;
	Q = malloc(sizeof(AQueue));    //分配内存 
	printf("初始化一个队列！\n");
	InitAQueue(Q,data_size);
	
	int length;    //得到队列长度 
	
	void *data;    //用户输入的入队的元素的指针 
	
	void (*foo)(void *q,int a);    //用于遍历时使用的函数指针 
	
	void *e;    //用于保存得到的头元素 
	
	printf("|***************Caozuo Menue**************|\n");
	printf("|1.销毁队列                               |\n");
	printf("|2.出队                                   |\n");
	printf("|3.入队                                   |\n");
	printf("|4.清空队列                               |\n");
	printf("|5.判断队列是否为空                       |\n");
	printf("|6.遍历输出                               |\n");
	printf("|7.得到头元素                             |\n");
	printf("|8.得到队列长度                           |\n");
	printf("|9.结束程序                               |\n");
	printf("|*****************************************|\n");
	printf("输入：");
	
	int k;    //由用户输入选择操作 
	while(1)
	{
    	fflush(stdin);
	    scanf("%d",&k);
	    switch(k)
	    {
	    	case 1:
	    		DestoryAQueue(Q);
	    		break;
	    	case 2:
	    		DeAQueue(Q);
	    		break;
	    	case 3:
	    		printf("输入入队的元素：");
	    		if(data_size == 1)
	    		{
	    			char ch;
	    			while(1 != scanf("%s",&ch))
	    			{
	    				printf("输入错误！请重新输入\n");
	    				fflush(stdin);
					}
	    			data = &ch;
				}
				else if(data_size == 4) 
				{
					int ih;
					while(1 != scanf("%d",&ih))
	    			{
	    				printf("输入错误！请重新输入\n");
	    				fflush(stdin);
					}
					data = &ih;
				}
				else if(data_size == 8)
				{
					double dh;
					while(1 != scanf("%lf",&dh))
	    			{
	    				printf("输入错误！请重新输入\n");
	    				fflush(stdin);
					}
					data = &dh;
				}
	    		EnAQueue(Q, data);
	    		break;
	    	case 4:
	    		ClearAQueue(Q);
	    		break;
	    	case 5:
	    		IsEmptyAQueue(Q);
	    		break;
	    	case 6:
	    		foo = APrint;
	    		TraverseAQueue(Q, foo);
	    		break;
	    	case 7:
	    		x = GetHeadAQueue(Q, e);
	    		foo = APrint;
	    		TraverseAQueue(Q, foo);
	    		break;
	    	case 8:
	    		length = LengthAQueue(Q);
	    		printf("队列长度为%d \n",length);
	    		break;
	    	case 9:
	    		return 0;
	    		break;
	    	default:
	    		printf("输入无效！重新输入\n");
	    		break;
		}
	    printf("继续输入要操作: ");
	}
	return 0;
}

int LinkQueue(size_t data_size)    //链式队列 
{
	int x;
	LQueue *Q;
	Q = malloc(sizeof(LQueue));    //分配内存 
	printf("好的，那首先初始化一个队列！\n");
	InitLQueue(Q,data_size);
	
	int length;    //得到队列长度 
	
	void *data;    //用户输入的入队的元素的指针 
	
	void (*foo)(void *q,int a);    //用于遍历时使用的函数指针 
	
	void *e;    //用于保存得到的头元素 
	
	printf("|***************Caozuo Menue**************|\n");
	printf("|1.销毁队列                               |\n");
	printf("|2.出队                                   |\n");
	printf("|3.入队                                   |\n");
	printf("|4.清空队列                               |\n");
	printf("|5.判断队列是否为空                       |\n");
	printf("|6.遍历输出                               |\n");
	printf("|7.得到头元素                             |\n");
	printf("|8.得到队列长度                           |\n");
	printf("|9.结束程序                               |\n");
	printf("|*****************************************|\n");
	printf("输入：");
	
	int k;    //由用户输入选择操作 
	while(1)
	{
    	fflush(stdin);
	    scanf("%d",&k);
	    switch(k)
	    {
	    	case 1:
	    		DestoryLQueue(Q);
	    		break;
	    	case 2:
	    		DeLQueue(Q);
	    		break;
	    	case 3:
	    		printf("输入你想要入队的元素：");
	    		if(data_size == 1)
	    		{
	    			char ch;
	    			scanf("%s",&ch);
	    			data = &ch;
				}
				else
				{
					int ih;
					scanf("%d",&ih);
					data = &ih;
				}
	    		EnLQueue(Q, data);
	    		break;
	    	case 4:
	    		ClearLQueue(Q);
	    		break;
	    	case 5:
	    		IsEmptyLQueue(Q);
	    		break;
	    	case 6:
	    		foo = LPrint;
	    		TraverseLQueue(Q, foo);
	    		break;
	    	case 7:
	    		x = GetHeadLQueue(Q, e);
	    		foo = LPrint;
	    		TraverseLQueue(Q, foo);
	    		break;
	    	case 8:
	    		length = LengthLQueue(Q);
	    		printf("队列长度为%d \n",length);
	    		break;
	    	case 9:
	    		return 0;
	    		break;
	    	default:
	    		printf("输入无效！重新输入\n");
	    		break;
		}
	    printf("可以继续输入要操作的数字: ");
	}
	return 0;
}

int main(int argc, char *argv[]) 
{
	//while(1)
	//{
	    printf("|***************Type Menue***************|\n");
	    printf("|1:char字符或字符串                      |\n");
	    printf("|4:int                                   |\n");
	    printf("|8:double                               |\n");
	    printf("|****************************************|\n\n");
	    size_t data_size;
	    while(scanf("%d",&data_size) != 1)
	    {
	    	printf("输入无效！请重新输入\n");
	    	fflush(stdin);
		}
		fflush(stdin);
		printf("|***************Queue Menue***************|\n");
		printf("|a.循环队列                               |\n");
		printf("|b.链式队列                               |\n");
		printf("|*****************************************|\n");
	    char ch;
	    ch=getchar();
	    if(ch == 'a')
	    {
	    	CycleQueue(data_size); 
		}
	    else if(ch == 'b')
	        LinkQueue(data_size);
	    else
	        printf("输入无效！");
	    getch();
	//}
	return 0;
}
