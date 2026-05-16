#include <stdio.h>
#define size 5  

int cqueue[size];
int front = -1, rear = -1;

void enqueue() {
    int value;
    if((rear + 1) % size == front) {
        printf("Circular Queue is full!\n");
    }
    else {
    	printf("Enter value to insert: ");
    	scanf("%d", &value);
        if (front == -1) front = 0; 
        rear = (rear + 1) % size;
        cqueue[rear] = value;
        printf("Inserted %d\n", value);
    }
}


void dequeue() {
    if (front == -1) {
        printf("Circular Queue is Underflow!\n");
    } 
    else {
        printf("Deleted %d\n", cqueue[front]);
        if(front == rear)
        	front = rear = -1;
        else
        	front = (front + 1) % size;
        }
}


void display() {
    if (front == -1) {
        printf("Circular Queue is empty!\n");
    } 
    else {
    	int i = front; 
        printf("Circular Queue elements: ");
        while(1) {
            printf("%d ", cqueue[i]);
            if (i == rear)
            break;
            i = (i + 1) % size;
        }
        printf("\n");
    }
}


int main() {
    int choice;
    printf("Queue Operations using Array\n");

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



















