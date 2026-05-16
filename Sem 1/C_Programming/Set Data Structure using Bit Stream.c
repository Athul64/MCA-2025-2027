#include <stdio.h>

void main()
{
    int arr1[11] = {0}, arr2[11] = {0};
    int i, j, x, y, a1, a2;
    
    printf("Enter array 1 size: ");
    scanf("%d", &a1);
    
    printf("Enter elements : "); 
    for(i = 0; i < a1; i++) 
    { 
        scanf("%d", &x); 
        arr1[x] = 1; 
    }
    
    printf("Enter array 2 size: ");
    scanf("%d", &a2);
    
    printf("Enter elements : "); 
    for(j = 0; j < a2; j++) 
    { 
        scanf("%d", &y); 
        arr2[y] = 1; 
    }
    
    printf("\n");
    printf("\nBitstring of 1st array : ");
    for(i = 0; i < 11; i++)
        printf("%d ", arr1[i]);
    
    printf("\nBitstring of 2nd array : ");
    for(j = 0; j < 11; j++)
        printf("%d ", arr2[j]);
    
    printf("\n");    
    printf("\nUnion Operation : ");
    for(i = 0; i < 11; i++)
        printf("%d", arr1[i] | arr2[i]);
        
    printf("\nIntersection Operation : ");
    for(i = 0; i < 11; i++)
        printf("%d", arr1[i] & arr2[i]);
      
    printf("\nComplement of Array 1 : ");
    for(i = 0; i < 11; i++)
        printf("%d", !arr1[i]);
         
    printf("\nComplement of Array 2 : ");
    for(i = 0; i < 11; i++)
        printf("%d", !arr2[i]);

    printf("\n");
}
