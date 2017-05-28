#include <stdio.h>
#include <stdlib.h>
#define MAXDIGIT 3
#define MAXSIZE 100
void radixSort(int a[], int size) {
	int i, j, d;
	int h = 1;
	int b[10][MAXSIZE], len[10];
	for (d = 0; d < MAXDIGIT; d++) {
		for (i = 0; i < 10; i++) 
			len[i] = 0;
		for (i = 0; i < size; i++) {
			int digit = (a[i] / h % 10);
			b[digit][len[digit]++] = a[i];
		}
		int num = 0;
		for (i = 0; i < 10; i++) {
			for (j = 0; j < len[i]; j++)
				a[num++] = b[i][j];
		}
		h *= 10;
	}
}

int main(){
	int arr[] = {965, 354, 368, 128, 495, 121};
	int size = 6;
	radixSort(arr, size);
	for (int i = 0 ; i < size; i++) printf("%d ", arr[i]);
	return 0;
}
