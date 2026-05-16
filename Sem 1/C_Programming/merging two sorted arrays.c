#include <stdio.h>

int main()
{
    int A[20], B[20], C[50];
    int N, M, X, i, j, temp;


    printf("Enter number of elements in first array (N): ");
    scanf("%d", &N);
    printf("Enter %d elements for first array:\n", N);
    for (i = 0; i < N; i++) {
        scanf("%d", &A[i]);
    }


    printf("Enter number of elements in second array (M): ");
    scanf("%d", &M);
    printf("Enter %d elements for second array:\n", M);
    for (i = 0; i < M; i++) {
        scanf("%d", &B[i]);
    }

    for (i = 0; i < N; i++) {
        C[i] = A[i];
    }
    for (j = 0; j < M; j++) {
        C[N + j] = B[j];
    }

    X = N + M;

    printf("\nMerged array before sorting:\n");
    for (i = 0; i < X; i++) {
        printf("%d ", C[i]);
    }
    printf("\n");


    for (i = 0; i < X - 1; i++) {
        for (j = i + 1; j < X; j++) {
            if (C[i] > C[j]) {
                temp = C[i];
                C[i] = C[j];
                C[j] = temp;
            }
        }
    }


    printf("\nSorted merged array:\n");
    for (i = 0; i < X; i++) {
        printf("%d ", C[i]);
    }
    printf("\n");
    return 0;
}

