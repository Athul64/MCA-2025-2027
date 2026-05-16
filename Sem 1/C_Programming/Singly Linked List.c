#include <stdio.h>
#include <stdlib.h>

// Define a structure for a node
struct Node {
    int data;
    struct Node* next;
};

// Global head pointer (start of the list)
struct Node* head = NULL;

// Function to create a new node
struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    if (newNode == NULL) {
        printf("Memory not allocated.\n");
        exit(1);
    }
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}

// Function to insert at the beginning
void insertAtStart(int data) {
    struct Node* newNode = createNode(data);
    newNode->next = head;
    head = newNode;
    printf("Inserted %d at the start.\n", data);
}

// Function to insert at the end
void insertAtEnd(int data) {
    struct Node* newNode = createNode(data);
    if (head == NULL) {
        head = newNode;
        printf("Inserted %d at the end.\n", data);
        return;
    }
    struct Node* temp = head;
    while (temp->next != NULL)
        temp = temp->next;
    temp->next = newNode;
    printf("Inserted %d at the end.\n", data);
}

// Function to insert at a specific position
void insertAtPosition(int data, int position) {
    if (position < 1) {
        printf("Position should be >= 1.\n");
        return;
    }

    if (position == 1) {
        insertAtStart(data);
        return;
    }

    struct Node* newNode = createNode(data);
    struct Node* temp = head;

    for (int i = 1; i < position - 1 && temp != NULL; i++)
        temp = temp->next;

    if (temp == NULL) {
        printf("Position is greater than the number of nodes.\n");
        free(newNode);
        return;
    }

    newNode->next = temp->next;
    temp->next = newNode;
    printf("Inserted %d at position %d.\n", data, position);
}

// Function to delete from the start
void deleteAtStart() {
    if (head == NULL) {
        printf("List is empty.\n");
        return;
    }
    struct Node* temp = head;
    head = head->next;
    printf("Deleted %d from start.\n", temp->data);
    free(temp);
}

// Function to delete from the end
void deleteAtEnd() {
    if (head == NULL) {
        printf("List is empty.\n");
        return;
    }

    if (head->next == NULL) {
        printf("Deleted %d from end.\n", head->data);
        free(head);
        head = NULL;
        return;
    }

    struct Node* temp = head;
    struct Node* prev = NULL;
    while (temp->next != NULL) {
        prev = temp;
        temp = temp->next;
    }
    printf("Deleted %d from end.\n", temp->data);
    prev->next = NULL;
    free(temp);
}

// Function to delete from a specific position
void deleteAtPosition(int position) {
    if (head == NULL) {
        printf("List is empty.\n");
        return;
    }

    if (position < 1) {
        printf("Position should be >= 1.\n");
        return;
    }

    if (position == 1) {
        deleteAtStart();
        return;
    }

    struct Node* temp = head;
    struct Node* prev = NULL;

    for (int i = 1; temp != NULL && i < position; i++) {
        prev = temp;
        temp = temp->next;
    }

    if (temp == NULL) {
        printf("Position greater than number of nodes.\n");
        return;
    }

    prev->next = temp->next;
    printf("Deleted %d from position %d.\n", temp->data, position);
    free(temp);
}

// Function to display the list
void display() {
    if (head == NULL) {
        printf("List is empty.\n");
        return;
    }

    struct Node* temp = head;
    printf("Linked List: ");
    while (temp != NULL) {
        printf("%d -> ", temp->data);
        temp = temp->next;
    }
    printf("NULL\n");
}

// Main menu-driven program
int main() {
    int choice, data, position;

    while (1) {
        printf("\n--- Singly Linked List Operations ---\n");
        printf("1. Insert at Start\n");
        printf("2. Insert at Position\n");
        printf("3. Insert at End\n");
        printf("4. Delete from Start\n");
        printf("5. Delete from Position\n");
        printf("6. Delete from End\n");
        printf("7. Display List\n");
        printf("8. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
        case 1:
            printf("Enter data: ");
            scanf("%d", &data);
            insertAtStart(data);
            break;
        case 2:
            printf("Enter data: ");
            scanf("%d", &data);
            printf("Enter position: ");
            scanf("%d", &position);
            insertAtPosition(data, position);
            break;
        case 3:
            printf("Enter data: ");
            scanf("%d", &data);
            insertAtEnd(data);
            break;
        case 4:
            deleteAtStart();
            break;
        case 5:
            printf("Enter position: ");
            scanf("%d", &position);
            deleteAtPosition(position);
            break;
        case 6:
            deleteAtEnd();
            break;
        case 7:
            display();
            break;
        case 8:
            printf("Exiting program...\n");
            exit(0);
        default:
            printf("Invalid choice! Please try again.\n");
        }
    }

    return 0;
}

