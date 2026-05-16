#include <stdio.h>
#include <stdlib.h>

struct  Node{
	int data;
	struct Node *next;
};

struct Node *front = NULL, *rear = NULL;

void enqueue() {
	int val;
	printf("Enter Value to insert: ");
	scanf("%d", &val);
	
	struct Node *newNode = (struct Node*)malloc(sizeof(struct Node));
	newNode ->data = val;
	newNode ->next = NULL;
	
	if(rear == NULL)
		front = rear = newNode;
	else {
		rear -> next = newNode;
		rear = newNode;
	}
	printf("Inserted %d\n", val);	
}

void dequeue() {
	if(front == NULL)
	printf("Queue is empty!\n");
	else {
		struct Node *temp = front;
		printf("Deleted %d\n", front -> data);
		front = front -> next;
		if(front == NULL)
			rear = NULL;
		free(temp);
	}
}

void display() {
	if(front == NULL)
	printf("Queue is empty!\n");
	else {
		struct Node *temp = front;
		printf("Queue elemnets: ");
		while(temp != NULL) {
		printf("%d ", temp -> data);
		temp = temp -> next;
	}
	printf("\n");
    }
}

int main() {
    int choice;
    printf("Queue using Linked list\n");

    while (1) {
        printf("\n1. Enqueue\n2. Dequeue\n3. Display\n4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1: enqueue(); break;
            case 2: dequeue(); break;
            case 3: display(); break;
            case 4: 
                printf("Exiting program.\n");
                return 0;
            default:
                printf("Invalid choice! Please try again.\n");
        }
    }
}

