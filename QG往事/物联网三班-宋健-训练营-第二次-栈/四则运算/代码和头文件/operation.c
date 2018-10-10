#include<stdio.h>
#include<string.h>
#include<stdlib.h>

int pushFuctionStack(LinkStack *s,int datas)  //入栈
{
	LinkStackPtr current = (LinkStackPtr)malloc(sizeof(StackNode));
	current->data = datas;
	current->next = s->top;
	s->top = current;
	s->count++;
	return OK;
}

int popFuctionStack(LinkStack *s)   //出栈
{	
	int num;
	LinkStackPtr current;
	current = s->top;
	num = current->data;
	s->top = current->next;
	free(current);
	s->count--;
	return num;
}

int isEmptyStack(LinkStack *s)             //判断栈是否为空
{
    return (s->count == 0) ? OK : ERROR;  
}

int getTopLStack(LinkStack *s)               //得到链栈头元素
{
	if(NULL == s->top)  return ERROR;  
    return (s->top->data); 
}

int Priority(char s)                         /*判断优先级   这个函数参考了网上的代码  0.0*/ 
{                                            /*实在想不出怎么完成优先级的判断*/ 
    switch(s)  
    {  
        case '(':  
            return 3;  
        case '*':  
        case '/':  
            return 2;  
        case '+':  
        case '-':  
            return 1;  
        default:  
            return 0;  
    }  
}  

int intSelection()
{
	int tmp = 0; int j; int i = 0; int temp;
	
	
	char fuction[100]={0};
	LinkStack *num ,*fuhao;
	num = (LinkStack *)malloc(sizeof(StackNode));
	num->top = NULL;
    num->count = 0;
   
    fuhao = (LinkStack *)malloc(sizeof(StackNode));
	fuhao->top = NULL;
    fuhao->count = 0;
	
	printf("若需要在方程中输入括号，请勿使用中文的括号，如'（）'！\n");
	printf("请输入函数：");
	scanf("%s",fuction);
	
	while(fuction[i] != '\0' || isEmptyStack(fuhao) != OK)
	{
		if(fuction[0] == '+' || fuction[0] == '-' || fuction[0] == '*' ||fuction[0] == '/' )
		{
			printf("请以数字作为方程的开头。");
			return 0;
		}
		if(getTopLStack(fuhao) == '(' && fuction[i] != ')')
		{
			if(fuction[++i] == '+' || fuction[++i] =='-' || fuction[++i] == '*' ||fuction[++i] == '/')
			{
			 	printf("格式错误！");
				return 0;
			} 
		}
		
		if(fuction[i] >= '1' && fuction[i] <= '9')          //数字压入数字栈 
		{
			tmp = tmp * 10 + fuction[i] - '0';
			i++;
			if(fuction[i] < '1' || fuction[i] > '9')
			{
				pushFuctionStack(num,tmp);
				tmp = 0;
			}
		}
		else 
		{
			if((isEmptyStack(fuhao) == OK) || (getTopLStack(fuhao) == '(' && fuction[i] != ')') || Priority(fuction[i]) > Priority(getTopLStack(fuhao)))
			{
				pushFuctionStack(fuhao,fuction[i]);
				i++;
				continue;
			}
			if(getTopLStack(fuhao) == '(' && fuction[i] == ')')
			{
				popFuctionStack(fuhao);
				i++;
				continue;
			}
			if((fuction[i] == '\0' && isEmptyStack(fuhao) != OK) || (fuction[i] == ')' && getTopLStack(fuhao) != '(') || Priority(fuction[i]) <= Priority(getTopLStack(fuhao)))
			{
				switch(popFuctionStack(fuhao))
				{
					case '+':
						pushFuctionStack(num, popFuctionStack(num) + popFuctionStack(num));
						break;
					case '-':
						j = popFuctionStack(num);
						pushFuctionStack(num, popFuctionStack(num) - j);
						break;
					case '*':
						pushFuctionStack(num, popFuctionStack(num) * popFuctionStack(num));
						break;
					case '/':
						j = popFuctionStack(num);
						if(j == 0) {printf("除数不能为0！"); return 0;}
						pushFuctionStack(num, popFuctionStack(num) / j);
						break; 
				}
				continue;
			}				
		}
	}
	printf("方程结果为：%d",popFuctionStack(num));
        printf("\n"); 
	return 0; 
} 

