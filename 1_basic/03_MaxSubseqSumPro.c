#include<stdio.h>

//----------------------------����4 ����------------------------------//

int MaxStart = 0; //������к͵���� 
int MaxEnd = 0; //������к͵��յ� 
int flag = -1; //-1��ʾȫ�Ǹ�����0��ʾ��������������ʾ��������0����µ�һ������0��λ�� 

int MaxSubseqSum4p( int A[], int N )
{
	int ThisSum = 0, MaxSum = 0;
	int ThisStart = 0; // ��ǰ���е���� 
	int i;
	for( i = 0; i < N; i++ ) {
		if(A[i] > 0)
			flag = 0; //��������������� 
		else if (A[i] == 0 && flag < 0)
		{
			ThisStart = i+1;
			flag = i; //��������0���������¼��һ������0��λ��
		} 
			
		ThisSum += A[i]; /* �����ۼ� */

		if( ThisSum > MaxSum )
		{
			MaxSum = ThisSum; /* ���ָ��������µ�ǰ��� */
			MaxStart = ThisStart;
			MaxEnd = i;
		}
		else if( ThisSum < 0 ) /* �����ǰ���к�Ϊ����*/ 
		{
			ThisSum = 0; /* �򲻿���ʹ����Ĳ��ֺ���������֮ */ 
			              //���� ThisSum == 0 ���������ֱ����������Ϊ�� 1 -1 2 -2������Ҫ�����������1 -1 2
			ThisStart = i+1;
		}
	}
	return MaxSum;
}
//----------------------------main����------------------------------// 

int main()
{
	int K = 0, i = 0;
	//printf("������������ K = ");
	scanf("%d", &K);
	
	//printf("������K�������ÿո�ָ���");
	int a[K];
	for(i=0; i<K; i++){
		scanf("%d", &a[i]);
	}

	printf("%d ", MaxSubseqSum4p(a, K));
	if(flag == 0) //��������������� 
		printf("%d %d", a[MaxStart], a[MaxEnd]); // ע���Ƿ�����㡢�յ��Ӧ�����֣���������㡢�յ� 
	else if(flag == -1) //ȫ�Ǹ��� 
		printf("%d %d", a[0], a[K-1]);
	else //��������0
		printf("%d %d", a[flag], a[flag]);
}
	
