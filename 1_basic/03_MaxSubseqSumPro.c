#include<stdio.h>

//----------------------------方法4 补充------------------------------//

int MaxStart = 0; //最大子列和的起点 
int MaxEnd = 0; //最大子列和的终点 
int flag = -1; //-1表示全是负数，0表示有正数，正数表示仅负数和0情况下第一次遇到0的位置 

int MaxSubseqSum4p( int A[], int N )
{
	int ThisSum = 0, MaxSum = 0;
	int ThisStart = 0; // 当前子列的起点 
	int i;
	for( i = 0; i < N; i++ ) {
		if(A[i] > 0)
			flag = 0; //正常情况，有正数 
		else if (A[i] == 0 && flag < 0)
		{
			ThisStart = i+1;
			flag = i; //仅负数、0的情况，记录第一次遇到0的位置
		} 
			
		ThisSum += A[i]; /* 向右累加 */

		if( ThisSum > MaxSum )
		{
			MaxSum = ThisSum; /* 发现更大和则更新当前结果 */
			MaxStart = ThisStart;
			MaxEnd = i;
		}
		else if( ThisSum < 0 ) /* 如果当前子列和为负数*/ 
		{
			ThisSum = 0; /* 则不可能使后面的部分和增大，抛弃之 */ 
			              //但是 ThisSum == 0 的情况不能直接抛弃。因为如 1 -1 2 -2，根据要求最大子列是1 -1 2
			ThisStart = i+1;
		}
	}
	return MaxSum;
}
//----------------------------main函数------------------------------// 

int main()
{
	int K = 0, i = 0;
	//printf("请输入正整数 K = ");
	scanf("%d", &K);
	
	//printf("请输入K个数，用空格分隔：");
	int a[K];
	for(i=0; i<K; i++){
		scanf("%d", &a[i]);
	}

	printf("%d ", MaxSubseqSum4p(a, K));
	if(flag == 0) //正常情况，有正数 
		printf("%d %d", a[MaxStart], a[MaxEnd]); // 注意是返回起点、终点对应的数字，而不是起点、终点 
	else if(flag == -1) //全是负数 
		printf("%d %d", a[0], a[K-1]);
	else //仅负数、0
		printf("%d %d", a[flag], a[flag]);
}
	
