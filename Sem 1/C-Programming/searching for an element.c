#include <stdio.h>
int main()
{	
	
	int size;
	int target;
	int found;
	
	printf("Enter the size of an array: ");
	scanf("%d", &size);
	
	int arr[size];
	
	printf("Enter %d Elements to the array: \n",size);
	for(int i = 0; i < size; i++)
	{
		scanf("%d", &arr[i]);
	}  
	
	printf("Enter the Element to Search: ");
	scanf("%d", &target);
	
	for(int i=0; i<size; i++)
	{
		if(arr[i] == target)
		{
			found = target;
		  	printf("Enter %d Found at index %d\n.",target, i);
		}

	}
		
	if(!found)
	{	
		printf("Enter %d not found in the array\n.",target);
	}
}


