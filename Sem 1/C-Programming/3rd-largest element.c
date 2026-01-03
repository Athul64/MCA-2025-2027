#include <stdio.h>
void main()
{
	int n, i, j, temp;
	int arr[100];
	
	printf("Enter the size of the array: ");
	scanf("%d",&n);
	
	printf("Enter array elements: ");
	for (i=0; i<n; i++)
		scanf("%d", &arr[i]);
		
	for(i=0;i<n-1;i++)
	{
		for(j=0;j<n-i-1;j++)
		{
			if(arr[j]>arr[j+1])
			{
				temp=arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=temp;
			}
		}
	}
	
	printf("3rd largest element = %d\n", arr[n-3]);
}
