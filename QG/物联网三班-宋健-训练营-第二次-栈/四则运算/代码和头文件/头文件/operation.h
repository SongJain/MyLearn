#ifndef OPERATION_H
#define OPERATION_H
#define MAXNUM 200

typedef char ElemType;            //指定字符类型 

typedef enum Status              //枚举 
{
    ERROR = 0,OK = 1
}Status;

typedef  struct StackNode       //链栈完成 
{
	ElemType data;
	struct StackNode *next;
}StackNode, *LinkStackPtr;

typedef  struct  LinkStack{
	LinkStackPtr top;	 
	int	count;
}LinkStack;

int getTopLStack(LinkStack *s);                    	//获取栈顶元素 
int isEmptyStack(LinkStack *s);                     //判断是否为空栈 
int popFuctionStack(LinkStack *s);                  //出栈 
int pushFuctionStack(LinkStack *s,int datas);            //压栈 
int Priority(char s);                                //判断优先级 
#endif
