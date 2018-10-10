#include<stdio.h>
#include<stdlib.h>
#include"stack.h"
#include"stack.c"
#include"windows.h"//防程序闪退  

Status printStack()
{
	printf("*|*****************************|*\n");
	printf("*|------------menue------------|*\n");
	printf("*| 1.初始化顺序栈              |*\n");
	printf("*| 2.压栈                      |*\n");
	printf("*| 3.弹栈                      |*\n");
	printf("*| 4.清空栈                    |*\n");
	printf("*| 5.删除栈                    |*\n");
	printf("*| 6.查看栈长度                |*\n");
	printf("*| 7.查看栈顶元素              |*\n");
	printf("*| 8.是否为空栈                |*\n");
	printf("*| 9.退出                      |*\n");
	printf("*|*****************************|*\n");
	printf("请输入对应编号完成操作：");
	
	int sc;  
	
	SqStack *s = (SqStack *)malloc(sizeof(SqStack));
	s->size = -1;
	
	while(scanf("%d",&sc) != 9)
	{
		switch(sc)
		{
			case 1:
			{
				int sizes;
				printf("请输入栈的大小：");
				scanf("%d",&sizes);
				initStack(s,sizes);
				printf("成功初始化大小为%d的栈!\n",sizes);
				printf("\n请输入下一个操作：\n");
				break;
			}
			
			case 2:
			{
				if(isEmptyStack(s))
				{	ElemType datas;
					printf("请输入datas:");
					scanf("%d",&datas);
					pushStack(s,datas);
				}
				printf("\n请输入下一个操作：\n");
				break;
			}
			
			case 3:
			{
				if(isEmptyStack(s))
				{
					ElemType *datas;
					popStack(s,datas);
				}
				printf("\n请输入下一个操作：\n");
				break;
			}
			
			case 4:
			{
				if(isEmptyStack(s))
				{	
					clearStack(s);
				}
				printf("\n请输入下一个操作：\n");
				break;
			}
			
			case 5:
			{
				if(isEmptyStack(s))
				{
					destoryStack(s);
				}
				printf("\n请输入下一个操作：\n");
				break;
			}
			
			case 6:
			{
				if(isEmptyStack(s))
				{
					int length;
					stackLength(s,length);
				}
				printf("\n请输入下一个操作：\n");
				break;
			}
			
			case 7:
			{
				if(isEmptyStack(s))
				{
					ElemType e;
					getTopStack(s,&e);
				}
				printf("\n请输入下一个操作：\n");
				break;
			}
			
			case 8:
			{
				if(isEmptyStack(s))
				{
					isEmptyStack(s);
				}
				printf("\n请输入下一个操作：\n");
				break;
			}
			 
			case 9: printf("\n结束！\n");return 0; 
		}
	}
   return 0;
	
}

Status printLStack()
{
	printf("*|*****************************|*\n");
	printf("*|------------menue------------|*\n");
	printf("*| 1.初始化链栈                |*\n");
	printf("*| 2.压栈                      |*\n");
	printf("*| 3.弹栈                      |*\n");
	printf("*| 4.清空栈                    |*\n");
	printf("*| 5.删除栈                    |*\n");
	printf("*| 6.查看栈长度                |*\n");
	printf("*| 7.查看栈顶元素              |*\n");
	printf("*| 8.是否为空栈                |*\n");
	printf("*| 9.退出                      |*\n");
	printf("*|*****************************|*\n");

	 
	int sc; 
	LinkStack *s = (LinkStack*)malloc(sizeof(StackNode));
	s->count = 0;
	s->top = NULL;
	printf("初始化在选择前已完成！\n");
	printf("请输入对应编号完成操作：");
	while(scanf("%d",&sc))
	{
		switch(sc)
		{
			case 1:
			{
				initLStack(s);
				printf("\n请输入下一个操作：\n");
				break;
			}
			
			case 2:
			{
				
				ElemType datas;
				printf("请输入datas:");
				scanf("%d",&datas); 
				pushLStack(s,datas);
				printf("\n请输入下一个操作：\n");
				break;
			}
			
			case 3:
			{
				ElemType *datas;
				popLStack(s,datas);
				printf("\n请输入下一个操作：\n");
				break;
			}
			
			case 4:
			{
				clearLStack(s);
				printf("\n请输入下一个操作：\n");
				break;
			}
			
			case 5:
			{
				destoryLStack(s);
				printf("\n请输入下一个操作：\n");
				break;
			}
			
			case 6:
			{
				int length;
				LStackLength(s,length);
				printf("\n请输入下一个操作：\n");
				break;
			}
			
			case 7:
			{
				ElemType e;
				getTopLStack(s,&e);
				printf("\n请输入下一个操作：\n");
				break;
			}
		
			case 8:
			{
				isEmptyLStack(s);
				printf("\n请输入下一个操作：\n");
				break;
			}
			 
			case 9: printf("\n结束！\n");return 0;
		}
	}
}


int main()
{
	int num;
	printf("*|*****************************|*\n");
	printf("*|------------menue------------|*\n");
	printf("*| 1.顺序栈的操作              |*\n");
	printf("*| 2.链栈的操作                |*\n");
	printf("*|-----------------------------|*\n");
	printf("*|*****************************|*\n");
	printf("选择栈的类型，输入序号：");
	printf("\n");
	printf("\n");
	scanf("%d",&num);
	if(num == 1) {
		printf("*|********当前选择的是*********|*\n");
		printf("*|           顺序栈            |*\n");
		printStack();
		
	}
	else if(num == 2) 
	{
		printf("*|********当前选择的是*********|*\n");
		printf("*|            链栈             |*\n");
		printLStack();
	} 
	else printf("输入错误！");
    return 0;
    system("pause");//防止程序闪退 
}


 








