#include <stdio.h>
#include"stack.h"
#include<stdlib.h>
//顺序栈(基于数组的)

Status initStack(SqStack *s,int sizes)  //初始化栈
{
	s->elem = (ElemType *)malloc(sizes * sizeof(ElemType));
	if(s->elem == NULL) return 0;		
	s->top = -1;
	s->size = sizes;
	printf("初始化完成！\n");

}


Status isEmptyStack(SqStack *s)   //判断栈是否为空
{
	if(s->size == -1) {printf("请先初始化！\n"); return ERROR;}
	else if(s->top == -1) {printf("此时为空栈！\n"); return OK;}
	else {printf("此时为非空栈！\n"); return OK;}
	return OK; 
}



Status destoryStack(SqStack *s)  //销毁栈
{
	if(s == NULL || s->top == -1) return ERROR;
	free(s->elem);
	s->size = 0;
	s->top = -1;
	printf("删除成功！\n");
	return OK;
}


Status pushStack(SqStack *s,ElemType datas)  //入栈
{
	if(s->top == s->size-1) {printf("栈已满！无法入栈！\n"); return ERROR;}
	else 
	{	s->top++;
		s->elem[s->top] = datas;
		printf("输入成功！\n");
	}
	return OK;
	
}

Status popStack(SqStack *s,ElemType *datas)   //出栈
{	
	if(s->top == -1) { return 0;}
	*datas = s->elem[s->top];
	s->top--;
	printf("出栈元素为：%d\n",*datas);
	return OK;

}

Status stackLength(SqStack *s,int length)   //检测栈长度
{
	length = s->top + 1;
	printf("栈的长度为：%d\n",length);	
}

Status getTopStack(SqStack *s,ElemType *e)   //得到栈头元素
{
	if(s == NULL || s->top == -1) return ERROR;
	*e = s->elem[s->top];
	printf("栈的头元素为:%d\n",*e);
	return OK;
}

Status clearStack(SqStack *s)   //清空栈
{
	s->top = -1;
	printf("清空成功！\n");	
}



//链栈(基于链表的)
Status initLStack(LinkStack *s)   //初始化
{
	s = (LinkStack*)malloc(sizeof(LinkStack));
    s->top = NULL;
    s->count = 0;
    printf("成功初始化链栈!\n");
    return OK;
}

Status pushLStack(LinkStack *s,ElemType datas)   //入栈
{
	if(s == NULL) {printf("请初始化链栈!\n"); return ERROR;}
	LinkStackPtr current = (LinkStackPtr)malloc(sizeof(StackNode));
	current->data = datas;
	current->next = s->top;
	s->top = current;
	s->count++;
	return OK;
}

Status popLStack(LinkStack *s,ElemType *datas)   //出栈
{
	if(s->top == NULL) {printf("空链栈不执行！\n"); return ERROR;}
	
	LinkStackPtr current;
	*datas = s->top->data;
	current = s->top;
	s->top = s->top->next;
	free(current);
	s->count--;
	printf("出栈元素为：%d\n",*datas);
	return OK;
}


Status destoryLStack(LinkStack *s)   //销毁链zhan 
{
	clearLStack(s);
	free(s);
	printf("删除完成！\n");
	printf("注意！此时s指向未知区域，若想继续操作，请先初始化，否则会有异常！");
	return OK;
}


Status isEmptyLStack(LinkStack *s)  //判断链表是否为空
{
	if(NULL == s->top) {printf("此时为空链栈！\n"); return OK;} 
	else {printf("此时为非空链栈！\n"); return OK;} 
}

Status getTopLStack(LinkStack *s,ElemType *e)  //得到链表头元素
{
	if(s->top == NULL) {printf("空链栈不执行！\n"); return ERROR;}
	*e = s->top->data;
	printf("链栈的头元素为：%d\n",*e);
	return OK;
}


Status clearLStack(LinkStack *s)   //清空链表
{
	if(s->top == NULL) {printf("空链栈不执行！\n"); return ERROR;}
	LinkStackPtr current;
	while(s->count)
	{
		s->count--;
		current = s->top->next;
		free(s->top);
		s->top = current;
	}
	printf("清空成功！\n");
	return OK;
}


Status LStackLength(LinkStack *s,int length)    //检测链zhan长度
{
	length = s->count;
	printf("链栈长度为：%d\n",length);
	return OK;
}
