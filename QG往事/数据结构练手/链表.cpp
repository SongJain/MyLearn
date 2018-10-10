#include <stdio.h>
#include <stdlib.h>
 
typedef int ElemType;            //指定元素类型为整型 
 
//定义结点类型 
typedef struct Node {
    ElemType data;              //单链表中的数据域 
    struct Node *next;          //单链表的指针域 
}Node,*LinkedList;


LinkedList LinkedListInit() 
{
    Node *L;
    L = (Node *)malloc(sizeof(Node));   //申请结点空间 
    if(L == NULL)                       //判断是否有足够的内存空间 
	{                    
        printf("申请内存空间失败\n");
    }
    L->next = NULL;                    //将next设置为NULL,初始长度为0的单链表 
 	return L;                          //返回头指针以便我们使用 
}

//单链表的建立2，尾插法建立单链表
 
void InsertList(PNode List, int pos, int val) {
    int position = 0;
    PNode P = List;    		//    定义节点p指向头节点
                    		//    寻找pos节点的前驱结点
    while (P != NULL && position<pos - 1)
    {
        P = P->Next;
        ++position;
    }
    PNode Tmp = (PNode)malloc(sizeof(Node));     // 分配一个临时节点用来存储要插入的数据
    if (Tmp == NULL)
    {
        printf("内存分配失败！");
        exit(-1);
    }
    //    插入节点
    Tmp->Element = val;
    Tmp->Next = P->Next;
    P->Next = Tmp;
}


void DeleteTheList(PNode List) {
    PNode P, Tmp;
    P = List->Next;    //定义指针P指向链表要删除的链表List的第一个点节点
    List->Next = NULL;
    while (P != NULL) {
        Tmp = P->Next;        //临时Tmp指向要删除的节点的下个节点
        free(P);    //释放指针P指向的节点
        P = Tmp;    //重新赋值
    }
    printf("删除链表成功！\n");
}


PNode FindList(PNode List) {
    PNode P = List->Next;    //    定义临时指针P指向首节点的地址
    int num = 0;    //    用于记录链表节点位置
    int val = 0;    //    用于存放要查询的值
    printf("请输入要查询的数：");
    scanf_s("%d", &val);    //    输入要查询的数值
    while (P != NULL&&P->Element != val) {
        P = P->Next;
        ++num;
    }
    if (P != NULL)
        printf("找到的节点为：%d", num + 1);
    else
        printf("找不到该节点");
    printf("\n");
    return P;
}


void DeleteTheList(PNode List) {
    PNode P, Tmp;
    P = List->Next;    //定义指针P指向链表要删除的链表List的第一个点节点
    List->Next = NULL;
    while (P != NULL) {
        Tmp = P->Next;        //临时Tmp指向要删除的节点的下个节点
        free(P);    //释放指针P指向的节点
        P = Tmp;    //重新赋值
    }
    printf("删除链表成功！\n");
}


