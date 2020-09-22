#include <stdio.h> 

typedef struct PolyNode *Polynomial;
struct PolyNode {
	int coef;
	int expon;
	Polynomial link;
}

int main()
{
	Polynomial P;
	
	return 0;
}
