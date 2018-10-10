/***************************************************************************************
 *	File Name				:	queue.h
 *	CopyRight				:
 *
 *	SYSTEM					:   win10
 *	Create Data				:	2018.4.21
 *	Author/Corportation		:
 *
 *
 *--------------------------------Revision History--------------------------------------
 *	No	version		Data			Revised By			Item			Description
 *
 *
 ***************************************************************************************/

 /**************************************************************
*	Multi-Include-Prevent Section
**************************************************************/
#ifndef QUEUE_H_INCLUDED
#define QUEUE_H_INCLUDED

/**************************************************************
*	Macro Define Section
**************************************************************/
#define MAXQUEUE 10
#define queue_entry(ptr, type, member) \
        ((type *)((char *)(ptr)-(unsigned long)(&((type *)0)->member)))

/**************************************************************
*	Struct Define Section
**************************************************************/
//循环队列结构
typedef struct Aqueue        	
{
    void *data[MAXQUEUE];  	//数据域
    int front;
    int rear;
	size_t data_size;		//数据域内存大小
	int len;
} AQueue;

//链式队列结构
typedef struct node     	  	
{
    void* data;       			//数据域指针
    struct node *next;			//指向当前结点的下一结点
} Node;

typedef struct Lqueue
{
    Node *front;       			//队头
    Node *rear;        			//队尾
	size_t data_size;			//数据域内存大小
} LQueue;

typedef enum
{
    FLASE=0, TRUE=1
} Status;

/**************************************************************
*	Prototype Declare Section
**************************************************************/

/**
 *  @name        : void InitAQueue(AQueue *Q,size_t data_size)
 *	@description : 初始化队列
 *	@param		 : 队列指针Q
 *	@return		 : None
 *  @notice      : None
 */
void InitAQueue(AQueue *Q,size_t data_size);

/**
 *  @name        : void InitLQueue(LQueue *Q)
 *	@description : 初始化队列
 *	@param		 : 队列指针Q
 *	@return		 : None
 *  @notice      : None
 */
void InitLQueue(LQueue *Q,size_t data_size);

/**
 *  @name        : void DestoryAQueue(AQueue *Q)
 *	@description : 销毁队列
 *	@param		 : 队列指针Q
 *	@return		 : None
 *  @notice      : None
 */
void DestoryAQueue(AQueue *Q);

/**
 *  @name        : void DestoryLQueue(LQueue *Q)
 *	@description : 销毁队列
 *	@param		 : 队列指针Q
 *	@return		 : None
 *  @notice      : None
 */
void DestoryLQueue(LQueue *Q);

/**
 *  @name        : Status IsFullAQueue(const AQueue *Q)
 *	@description : 检查队列是否已满
 *	@param		 : 队列指针Q
 *	@return		 : 满-TRUE; 未满-FLASE
 *  @notice      : None
 */
Status IsFullAQueue(const AQueue *Q);

/**
 *  @name        : Status IsEmptyAQueue(const AQueue *Q)
 *	@description : 检查队列是否为空
 *	@param		 : 队列指针Q
 *	@return		 : 空-TRUE; 未空-FLASE
 *  @notice      : None
 */
Status IsEmptyAQueue(AQueue *Q);

/**
 *  @name        : Status IsEmptyLQueue(const LQueue *Q)
 *	@description : 检查队列是否为空
 *	@param		 : 队列指针Q
 *	@return		 : 空-TRUE; 未空-FLASE
 *  @notice      : None
 */
Status IsEmptyLQueue(LQueue *Q);

/**
 *  @name        : Status GetHeadAQueue(AQueue *Q, void *e)
 *	@description : 查看队头元素
 *	@param		 : 队列指针Q，存放元素e
 *	@return		 : 成功-TRUE; 失败-FLASE
 *  @notice      : 队列是否空
 */
Status GetHeadAQueue(AQueue *Q, void *e);

/**
 *  @name        : Status GetHeadLQueue(LQueue *Q, void *e)
 *	@description : 查看队头元素
 *	@param		 : 队列指针Q，存放元素e
 *	@return		 : 成功-TRUE; 失败-FLASE
 *  @notice      : 队列是否空
 */
Status GetHeadLQueue(LQueue *Q, void *e);

/**
 *  @name        : int LengthAQueue(AQueue *Q)
 *	@description : 确定队列长度
 *	@param		 : 队列指针Q
 *	@return		 : 队列长度count
 *  @notice      : None
 */
int LengthAQueue(AQueue *Q);

/**
 *  @name        : int LengthLQueue(LQueue *Q)
 *	@description : 确定队列长度
 *	@param		 : 队列指针Q
 *	@return		 : 队列长度count
 *  @notice      : None
 */
int LengthLQueue(LQueue *Q);

/**
 *  @name        : Status EnAQueue(AQueue *Q, void *data)
 *	@description : 入队操作
 *	@param		 : 队列指针Q,入队数据指针data
 *	@return		 : 成功-TRUE; 失败-FLASE
 *  @notice      : 队列是否满了或为空
 */
Status EnAQueue(AQueue *Q, void *data);

/**
 *  @name        : Status EnLQueue(LQueue *Q, void *data)
 *	@description : 入队操作
 *	@param		 : 队列指针Q,入队数据指针data
 *	@return		 : 成功-TRUE; 失败-FLASE
 *  @notice      : 队列是否为空
 */
Status EnLQueue(LQueue *Q, void *data);

/**
 *  @name        : Status DeAQueue(AQueue *Q)
 *	@description : 出队操作
 *	@param		 : 队列指针Q
 *	@return		 : 成功-TRUE; 失败-FLASE
 *  @notice      : None
 */
Status DeAQueue(AQueue *Q);

/**
 *  @name        : Status DeLQueue(LQueue *Q)
 *	@description : 出队操作
 *	@param		 : 队列指针Q
 *	@return		 : 成功-TRUE; 失败-FLASE
 *  @notice      : None
 */
Status DeLQueue(LQueue *Q);

/**
 *  @name        : void ClearAQueue(Queue *Q)
 *	@description : 清空队列
 *	@param		 : 队列指针Q
 *	@return		 : None
 *  @notice      : None
 */
void ClearAQueue(AQueue *Q);

/**
 *  @name        : void ClearLQueue(AQueue *Q)
 *	@description : 清空队列
 *	@param		 : 队列指针Q
 *	@return		 : None
 *  @notice      : None
 */
void ClearLQueue(LQueue *Q);

/**
 *  @name        : Status TraverseAQueue(const AQueue *Q, void (*foo)(void *q))
 *	@description : 遍历函数操作
 *	@param		 : 队列指针Q，操作函数指针foo
 *	@return		 : None
 *  @notice      : None
 */
Status TraverseAQueue(AQueue *Q, void (*foo)(void *q,int a ));

/**
 *  @name        : Status TraverseLQueue(const LQueue *Q, void (*foo)(void *q))
 *	@description : 遍历函数操作
 *	@param		 : 队列指针Q，操作函数指针foo
 *	@return		 : None
 *  @notice      : None
 */
Status TraverseLQueue(LQueue *Q, void (*foo)(void *q,int a));

/**
 *  @name        : void APrint(void *q)
 *	@description : 操作函数
 *	@param		 : 指针q
 *	@return		 : None
 *  @notice      : None
 */
 void APrint(void *q,size_t data_size);
 
/**
 *  @name        : void LPrint(void *q)
 *	@description : 操作函数
 *	@param		 : 指针q
 *	@return		 : None
 *  @notice      : None
 */
 void LPrint(void *q,size_t data_size);
 
 /**************************************************************
*	End-Multi-Include-Prevent Section
**************************************************************/
#endif // QUEUE_H_INCLUDED
