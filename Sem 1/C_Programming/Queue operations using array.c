#include <stdio.h>
#define SIZE 5  

int queue[SIZE];
int front = -1, rear = -1;

void enqueue() {
    int value;
    if (rear == SIZE - 1) {
        printf("Queue is full!\n");
    }
    else {
    	printf("Enter value to insert: ");
    	scanf("%d", &value);
        if (front == -1) front = 0; 
        rear++;
        queue[rear] = value;
        printf("Inserted %d\n", value);
    }
}


void dequeue() {
    if (front == -1 || front > rear) {
        printf("Queue is Underflow!\n");
    } 
    else {
        printf("Deleted %d\n", queue[front]);
        front++;
        }
}


void display() {
    if (front == -1 || front > rear) {
        printf("Queue is empty!\n");
    } 
    else {
        printf("Queue elements: ");
        for (int i = front; i <= rear; i++) {
            printf("%d ", queue[i]);
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



















