#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *next;
};

struct Node *head = NULL;

void push() {
    struct Node *newNode = (struct Node*)malloc(sizeof(struct Node));
    if (newNode == NULL) {
        printf("Memory Allocation failed. Stack overflow.\n");
        return;
    }

    int val;
    printf("Enter value to push: ");
    scanf("%d", &val);

    newNode->data = val;
    newNode->next = head;
    head = newNode;

    printf("Pushed %d\n", val);
}

void pop() {
    if (head == NULL) {
        printf("Stack is empty!\n");
    } else {
        struct Node *temp = head;
        printf("Popped %d\n", head->data);
        head = head->next;
        free(temp);
    }
}


void display() {
    if (head == NULL) {
        printf("Stack is empty!\n");
    } else {
        struct Node *temp = head;
        printf("Stack elements: ");
        while (temp != NULL) {
            printf("%d", temp->data);
            temp = temp->next;
            if (temp != NULL)
                printf("->");
        }
        printf("\n");
    }
}


int main() {
    int choice;

    while (1) {
        printf("\n1. Push\n2. Pop\n3. Display\n4. Exit\n");
        printf("Enter choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1: push(); break;
            case 2: pop(); break;
            case 3: display(); break;
            case 4:
                printf("Exiting program.\n");
                return 0;
            default:
                printf("Invalid choice! Please try again.\n");
        }
    }
}




