#include <stdio.h>
#include <string.h>
#include "sort.h"

int A;

int main()
{
    char name[40],name2[40];
    char houzui[]=".txt";

    printf("请输入你要保存数据测试用时的文件的文件名：");
    scanf("%s",name);
    fflush(stdin);

    strcat(name,houzui);
    printTest(name);

    printf("测试成功！\n\n");


    return 0;
}
