#include <stdio.h>
void main()
{
	int arr[100], n, i, smallest, largest;
	
	printf("Enter the size of the array: ");
	scanf("%d",&n);
	
	printf("Enter array elements: ");
	for (i=0; i<n; i++)
	{
		scanf("%d", &arr[i]);
	}
	
	smallest = largest = arr[0];
	
	for(i=1; i<n; i++)
	{
		if (arr[i] < smallest)
			smallest = arr[i];
		if (arr[i] > largest)
			largest = arr[i];
	}
	
	printf("The largest elment is : %d\n", largest);
	printf("The smallest elment is : %d\n", smallest);
}
