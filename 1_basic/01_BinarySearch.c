#include <stdio.h>
#include <stdlib.h>

#define MAXSIZE 10
#define NotFound 0
typedef int ElementType;

typedef int Position;
typedef struct LNode *List;  //�����ָ�룬�����޸����� 
struct LNode
{
    ElementType Data[MAXSIZE];
    Position Last; /* �������Ա������һ��Ԫ�ص�λ�� */
};

List ReadInput(); /* ����ʵ�֣�ϸ�ڲ���Ԫ�ش��±�1��ʼ�洢 */
Position BinarySearch(List L, ElementType X);

int main()
{
    List L;
    ElementType X;
    Position P;

    L = ReadInput();  // һ��ʼ����д 
    scanf("%d", &X);
    P = BinarySearch(L, X);  // ��������Ҫд������� 
    printf("%d\n", P);

    return 0;
}

//��ȡ���룺���Ա�ĳ��ȡ�����
List ReadInput()
{
	List L;
	
	int n = 0, i = 0, num;
	printf("����n:");
	scanf("%d", &n);
	for (i = 0; i < n; i++)
	{
		 scanf("%d", &num);
		 L->Data[i] = num;
		 L->Last = i;
	}
	return L;
}

/* ��Ĵ��뽫��Ƕ������ */
Position BinarySearch(List L, ElementType X)
{
    int begin = 0;
    int end = L->Last;
    int mid = 0;
    while (begin <= end)
    {
        mid = (end + begin) / 2;
        printf("begin = %d, end = %d, mid = %d \n", begin, end, mid);  // ������� 
        
        if (L->Data[mid] == X)
        {
            return mid;
        }
        else if (L->Data[mid] < X)
        {
            begin = mid + 1;  // ��� + 1 �ͺ������ԡ���Ϊ�϶��ǲ������ˡ� 
        }
        else
        {
            end = mid - 1;
        }
    }
    return NotFound;
}

/*
�����������
�� 10 11 12 13 14
��15
���ȶ���, mid = 2, ֵ12��15С,�� begin = mid + 1 = 3,�õ�: 
13 14
�ٶ���, mid = 3, ��5С���� begin = mid + 1 = 4���õ���
14
�Ա�15С�� begin = mid + 1 =5 > end, �˳�ѭ�� 

//����Խ��һ�£� 
����n:5
10 11 12 13 14
15
begin = 0, end = 4, mid = 2
begin = 3, end = 4, mid = 3
begin = 4, end = 4, mid = 4
0
*/ 
