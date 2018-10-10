#include<stdio.h>
#include<stdlib.h>
#include"operation.h"
#include"operation.c"
#include"windows.h"//防程序闪退 


int main()
{
	char m;
	printf("四则运算，任意键开启！"); 
	scanf("%d",&m);
	do{
		intSelection();
	}while(m != 'q'); 
	return 0;
	system("pause");//防止程序闪退 
}
