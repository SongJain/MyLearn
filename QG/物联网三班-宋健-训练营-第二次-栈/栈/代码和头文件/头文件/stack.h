#ifndef STACK_H_INCLUDED
#define STACK_H_INCLUDED


typedef enum Status
{
    ERROR = 0,OK = 1
}Status;

typedef int ElemType;

typedef struct SqStack{
       ElemType	*elem;
       int top;      //用于栈顶指针
       int size;
}SqStack;

typedef  struct StackNode
{
	ElemType data;
	struct StackNode *next;
}StackNode, *LinkStackPtr;

typedef  struct  LinkStack{
	LinkStackPtr top;	  //栈顶指针
	int	count;  //栈中元素个数
}LinkStack;


Status initStack(SqStack *s,int sizes);
Status isEmptyStack(SqStack *s);
Status getTopStack(SqStack *s,ElemType *e);
Status clearStack(SqStack *s);
Status destoryStack(SqStack *s);
Status stackLength(SqStack *s,int length);
Status pushStack(SqStack *s,ElemType datas);
Status popStack(SqStack *s,ElemType *datas);


Status initLStack(LinkStack *s);
Status isEmptyLStack(LinkStack *s);
Status getTopLStack(LinkStack *s,ElemType *e);
Status clearLStack(LinkStack *s);
Status destoryLStack(LinkStack *s);
Status LStackLength(LinkStack *s,int length);
Status pushLStack(LinkStack *s,ElemType datas);
Status popLStack(LinkStack *s,ElemType *datas);


#endif // STACK_H_INCLUDED
