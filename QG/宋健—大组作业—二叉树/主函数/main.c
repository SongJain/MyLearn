#include<stdio.h>
#include"BinaryTree.h"
#include"BiTree.c"
char fuction[1000];
char op[1000];
int lch[1000], rch[1000];
int main() 
{
	char src[100];
	BiTree L;
    InitBiTree(L); //初始化     
	int i;
    printf("请输入运算表达式："); 
    while(scanf("%[^\n]", fuction) != EOF )//读到空格结束 
	{
        getchar();
        memset(op, 0, sizeof(op));
        no = 0;
        build_tree(fuction, 0, strlen(fuction));
        printf("%.2f\n", calculate(op, 1));
        memset(fuction, 0, sizeof(fuction));
    }
	return 0;
}
