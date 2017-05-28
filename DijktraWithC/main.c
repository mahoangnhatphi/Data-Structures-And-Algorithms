#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#define true 1
#define false 0
#define MAX 100
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int size;
int begin, end;
int g[MAX][MAX];

void read(char fileName[]) {
	FILE *f = fopen(fileName, "r");
	fscanf(f,"%d %d %d\n", &size, &begin, &end);
	int check = false;
	for (int i = 0; i < size; i++) {
		for  (int j = 0; j < size; j++)
		if (fscanf(f, "%d", &g[i][j]) == EOF) {
			check  = true;
			break;
		}
		if (check) break;
	}
	fclose(f);
}

int dijktra() {
	int isVisit[MAX], pre[MAX], len[MAX];
	for (int i = 0; i < size; i++) {
		isVisit[i] = false;
		pre[i] = -1;
		len[i] = INT_MAX;
	}
	
	int vBegin = begin - 1;
	int vEnd = end - 1;
	
	len[vBegin] = 0;
	
	while (isVisit[vEnd] == false) {
//		for (int j = 0; j < size; j++)
//			printf("%5d ", isVisit[j]);
//		printf("\n");
//		for (int j = 0; j < size; j++)
//			printf("%5d ", pre[j]);
//		printf("\n");
//		for (int j = 0; j < size; j++)
//			printf("%5d ", len[j]);
//		
		int i;
		for (i = 0; i < size; i++) 
			if (isVisit[i] == false && len[i] < INT_MAX) {
				break;
			}
		
		if (i >= size) {
			return -1;
		}
		for	(int j = 0; j < size; j++) 
			if (isVisit[j] == false && len[j] < len[i]) {
				i = j;
			}
//		printf("\n%d\n---------\n",i);
		isVisit[i] = true;
		for (int j = 0; j < size; j++)
			if (isVisit[j] == false && len[i] + g[i][j] < len[j] && g[i][j] != 0) {
				len[j] = len[i] + g[i][j];
				pre[j] = i;
			}
	}	
	
	int step[MAX], sizeStep = 0, i = vEnd;
	do {
		step[sizeStep++] = i + 1;
		i = pre[i];		
	} while (i != -1);
	printf("Path: ");
	for (int i = sizeStep - 1; i > 0; i--) printf("%d->",step[i]);
	printf("%d\n", step[0]);
	return len[vEnd];
}

int main(int argc, char *argv[]) {
	read("input.txt");
	printf("Minimum value must be paid to move from %d to %d is %d", begin, end, dijktra());
	return 0;
}
