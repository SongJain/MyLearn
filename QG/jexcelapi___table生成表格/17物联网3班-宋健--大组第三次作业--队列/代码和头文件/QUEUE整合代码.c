#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>
#include <ctype.h>

#define MAXQUEUE 10
#define queue_entry(ptr, type, member) \
        ((type *)((char *)(ptr)-(unsigned long)(&((type *)0)->member)))

typedef struct Aqueue        	
{
    void *data[MAXQUEUE];  	//数据域
    int front;
    int rear;
	size_t data_size;		//数据域内存大小
	int len;
} AQueue;

//链式队列结构
typedef struct node     	  	
{
    void* data;       			//数据域指针
    struct node *next;			//指向当前结点的下一结点
} Node;

typedef struct Lqueue
{
    Node *front;       			//队头
    Node *rear;        			//队尾
	size_t data_size;			//数据域内存大小
} LQueue;

typedef enum
{
    FLASE=0, TRUE=1
} Status;

void InitAQueue(AQueue *Q,size_t data_size)    //初始化循环队列
{
	//Q = (AQueue *)malloc(sizeof(AQueue) * MAXQUEUE);
	//Q->data = malloc(data_size *MAXQUEUE);
	//Q->data_size = data_size;
	
	Q->data[MAXQUEUE];
	Q->front = 0;
	Q->rear = 0;
	Q->data_size = data_size;
	printf("队列创建成功！\n");
} 

void DestoryAQueue(AQueue *Q)    //销毁循环队列
{
	if(Q == NULL)
	{
		printf("队列销毁失败！\n");
	}
	else
	{
			Q->front = Q->rear = 0;
			Q = NULL;
			printf("队列销毁成功！\n");
	}
}

Status IsEmptyAQueue(AQueue *Q)    //判断循环队列是否为空 
{
	//if(Q == NULL)
	//{
		//printf("不能操作队列！\n");
		//return FLASE;
	//} 
	if(Q->front == Q->rear)    //(((Q->rear - Q->front + MAXQUEUE) % MAXQUEUE) == 0)   错误？ 
	{
		printf("队列为空！\n");
		return TRUE;
	}
	else 
	{
		printf("队列不为空！\n");
		return FLASE;
	}
}

Status EnAQueue(AQueue *Q, void *data)    //入循环队列
{
	fflush(stdin);
	if((Q->rear+1) % MAXQUEUE == Q->front)
	{
		printf("队列已经满了！\n");
		return FLASE;
	}
	void *addTarget = (Q->data) + (Q->rear)%MAXQUEUE * (Q->data_size);
	memcpy(addTarget,data,Q->data_size);
	++(Q->rear);
	++(Q->len);
	printf("(数字也是字符的一种)插入成功！\n");
	
	return TRUE;
}

Status DeAQueue(AQueue *Q)    //出循环队列
{
	if(Q->front == Q->rear)
	{
		printf("队列为空！\n");
		return FLASE;
	}
	else
	{
		Q->front = (Q->front + 1) % MAXQUEUE;
		printf("队列头元素出队列成功！\n");
		return TRUE; 
	}
}

Status GetHeadAQueue(AQueue *Q, void *e)    //得到循环队列头元素
{
	
	if(Q == NULL)
	{
		printf("不能操作队列！\n");
		return FLASE;
	} 
	if(Q->front == Q->rear)    //判断循环队列是否为空 )
	{
		printf("队列为空！无头元素！\n");
		return FLASE;
	}
	else
	{
		void *target = (Q->data) + Q->front * (Q->data_size);
		memcpy(e,target,Q->data_size);
		if(Q->data_size == 1)
		{
			printf("头元素为%s",*((char *)e));
			return TRUE;
		}
		else if(Q->data_size == 4)
		{
			printf("头元素为%d",*((int *)e));
			return TRUE;
		}
	}
} 

int LengthAQueue(AQueue *Q)    //确定循环队列长度
{
	return ((Q->rear - Q->front + MAXQUEUE) % MAXQUEUE);
} 

Status TraverseAQueue(AQueue *Q, void (*foo)(void *q,int a))    //遍历循环队列
{
	int alen = Q->len;
	int afront = Q->front;
	while(alen)
	{
		void *target = (Q->data) + afront * (Q->data_size);
		foo(target,Q->data_size);
	}
	printf("\n");
	return TRUE;
}

void ClearAQueue(AQueue *Q)    //清空循环队列 
{
	if(Q == NULL)
	{
		printf("清空失败！\n");
	}
	else
	{
		Q->front = 0;
		Q->rear = 0;
		printf("清空成功!\n");
	}
} 

void APrint(void *q,size_t data_size)    //打印循环队列
{
	if(data_size == 1)
	{
		printf(" %c ",*((char *)q));
	}
	else if(data_size == 4)
	{
		printf(" %d ",*((int *)q));
	}
} 

void InitLQueue(LQueue *Q,size_t data_size)    //初始化队列 
{
	Q = malloc(sizeof(LQueue));
	Q->front = (Node *)malloc(data_size * sizeof(Node));
	Q->rear = (Node *)malloc(data_size * sizeof(Node));
	Q->front->next = NULL;
	printf("队列创建成功！\n");
}

void DestoryLQueue(LQueue *Q)    //销毁队列 
{
	if(Q->front == NULL)
	{
		printf("销毁队列失败！\n");
		return ;
	}
	Node *temp = Q->front->next;
	while(temp)
	{
		Node *tmp = temp;
		temp = temp->next;
		free(tmp);
	}
	temp = Q->front;
	Q->front = Q->rear =NULL;
	free(temp);    //释放头节点 
}

Status IsEmptyLQueue(LQueue *Q)    //判断队列是否为空 
{
	if(Q->front == Q->rear)
	{
		return TRUE;
	}
	else
	{
		return FLASE;
	}
}

Status GetHeadLQueue(LQueue *Q, void *e)    //得到队列头节点 
{
	if(IsEmptyLQueue(Q))
	{
		return FLASE;
	}
	e = Q->front->data;
	printf("头元素为");
}

int LengthLQueue(LQueue *Q)    //得到长度 
{
	int count;
	while(Q->front->next)
	{
		Q->front = Q->front->next;
		count++; 
	}
	return count;
}

Status EnLQueue(LQueue *Q, void *data)    //入队 
{
	Node *s = (Node *)malloc(sizeof(Node));
	if(!s)
	    return FLASE;
	s->data = data;
	s->next = NULL;
	Q->rear->next = s;
	
	Q->rear = s;
	printf("(数字也是字符的一种)入队成功！\n");
	return TRUE;
}

Status DeLQueue(LQueue *Q)    //出队 
{
	Node *s;
	if(Q->rear == Q->front)
	{
		printf("队列为空！\n");
		return FLASE;
	}
	s = Q->front->next;
	Q->front->next = s->next;
	if(Q->rear == s)
	{
		Q->rear = Q->front;
	}
	free(s);
	printf("出队成功！\n");
	return TRUE; 
}

void ClearLQueue(LQueue *Q)    //清空 
{
	if(Q->front == NULL)
	{
		printf("清空队列失败！\n");
		return ;
	}
	Node *temp = Q->front->next;
	while(temp)
	{
		Node *tmp = temp;
		temp = temp->next;
		free(tmp);
	}
	Q->front = Q->rear =NULL;
	printf("清空成功！\n");
}

Status TraverseLQueue(LQueue *Q, void (*foo)(void *q,int a))    //遍历 
{
	if(Q->front == Q->rear)
	{
		return FLASE;
	}
	Node *tmp = Q->front->next;
	while(tmp)
	{
		foo(Q->front->next,Q->data_size);
		tmp = tmp->next;
	}
}

void LPrint(void *q,size_t data_size)    //打印队列
{
	if(data_size == 1)
	{
		printf(" %c ",*((char *)q));
	}
	else if(data_size == 4)
	{
		printf(" %d ",*((int *)q));
	}
}

int CycleQueue(size_t data_size)    //循环队列 
{
	int x;
	AQueue *Q;
	Q = malloc(sizeof(AQueue));    //分配内存 
	printf("好的，那首先初始化一个队列！\n");
	InitAQueue(Q,data_size);
	
	int length;    //得到队列长度 
	
	void *data;    //用户输入的入队的元素的指针 
	
	void (*foo)(void *q,int a);    //用于遍历时使用的函数指针 
	
	void *e;    //用于保存得到的头元素 
	
	printf("\n输入你想要的操作的代表的数字:\n");
	printf("    1.销毁队列\n");
	printf("    2.出队\n");
	printf("    3.入队\n");
	printf("    4.清空队列\n");
	printf("    5.判断队列是否为空\n");
	printf("    6.遍历输出\n");
	printf("    7.得到头元素(bug)\n");
	printf("    8.得到队列长度\n");
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
	    		printf("输入你想要入队的元素：");
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
	    	default:
	    		printf("输入无效！重新输入\n");
	    		break;
		}
	    printf("可以继续输入要操作的数字: ");
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
	
	printf("\n输入你想要的操作的代表的数字:\n");
	printf("    1.销毁队列\n");
	printf("    2.出队\n");
	printf("    3.入队\n");
	printf("    4.清空队列\n");
	printf("    5.判断队列是否为空\n");
	printf("    6.遍历输出\n");
	printf("    7.得到头元素\n");
	printf("    8.得到队列长度\n");
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
	    		//TraverseLQueue(AQueue *Q, void (*foo)(void *q));
	    		break;
	    	case 7:
	    		//GetHeadLQueue(AQueue *Q, void *e,size_t data_size);
	    		break;
	    	case 8:
	    		length = LengthLQueue(Q);
	    		printf("队列长度为%d \n",length);
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
	    printf("\t\t  希望入队列的类型是？输入各类型相对应字节的数字（1:char字符或字符串,4:int，8：double）");
	    size_t data_size;
	    while(scanf("%d",&data_size) != 1)
	    {
	    	printf("输入无效！请重新输入\n");
	    	fflush(stdin);
		}
		fflush(stdin);
		printf("\t\t   想要进行循环队列还是链式队列的操作呢？ a.循环队列(bug少一点)   b.链式队列(bug多)  ");
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
