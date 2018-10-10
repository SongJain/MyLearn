#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>
#include <ctype.h>
#include "MyQUEUE.h"

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
