#include <stdio.h>
#include <stdlib.h>

#define MAXSIZE 10
#define NotFound 0
typedef int ElementType;

typedef int Position;
typedef struct LNode *List;  //定义成指针，便于修改内容 
struct LNode
{
    ElementType Data[MAXSIZE];
    Position Last; /* 保存线性表中最后一个元素的位置 */
};

List ReadInput(); /* 裁判实现，细节不表。元素从下标1开始存储 */
Position BinarySearch(List L, ElementType X);

int main()
{
    List L;
    ElementType X;
    Position P;

    L = ReadInput();  // 一开始不会写 
    scanf("%d", &X);
    P = BinarySearch(L, X);  // 这道题仅需要写这个函数 
    printf("%d\n", P);

    return 0;
}

//读取输入：线性表的长度、数据
List ReadInput()
{
	List L;
	
	int n = 0, i = 0, num;
	printf("输入n:");
	scanf("%d", &n);
	for (i = 0; i < n; i++)
	{
		 scanf("%d", &num);
		 L->Data[i] = num;
		 L->Last = i;
	}
	return L;
}

/* 你的代码将被嵌在这里 */
Position BinarySearch(List L, ElementType X)
{
    int begin = 0;
    int end = L->Last;
    int mid = 0;
    while (begin <= end)
    {
        mid = (end + begin) / 2;
        printf("begin = %d, end = %d, mid = %d \n", begin, end, mid);  // 方便调试 
        
        if (L->Data[mid] == X)
        {
            return mid;
        }
        else if (L->Data[mid] < X)
        {
            begin = mid + 1;  // 这个 + 1 就很有灵性。因为肯定是不等于了。 
        }
        else
        {
            end = mid - 1;
        }
    }
    return NotFound;
}

/*
特殊情况分析
如 10 11 12 13 14
找15
首先二分, mid = 2, 值12比15小,则 begin = mid + 1 = 3,得到: 
13 14
再二分, mid = 3, 比5小，则 begin = mid + 1 = 4，得到：
14
仍比15小， begin = mid + 1 =5 > end, 退出循环 

//与测试结果一致： 
输入n:5
10 11 12 13 14
15
begin = 0, end = 4, mid = 2
begin = 3, end = 4, mid = 3
begin = 4, end = 4, mid = 4
0
*/ 
