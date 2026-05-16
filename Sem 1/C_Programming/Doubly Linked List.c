#include <stdio.h>
#include <stdlib.h>

// Define structure for a node in doubly linked list
struct Node {
    int data;
    struct Node* prev;
    struct Node* next;
};

// Global head pointer (points to first node)
struct Node* head = NULL;

// Function to create a new node
struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    if (newNode == NULL) {
        printf("Memory not allocated.\n");
        exit(1);
    }
    newNode->data = data;
    newNode->prev = NULL;
    newNode->next = NULL;
    return newNode;
}

// Function to insert a node at the start
void insertAtStart(int data) {
    struct Node* newNode = createNode(data);

    if (head == NULL) { // if list is empty
        head = newNode;
    } else {
        newNode->next = head;
        head->prev = newNode;
        head = newNode;
    }

    printf("Inserted %d at the start.\n", data);
}

// Function to insert a node at the end
void insertAtEnd(int data) {
    struct Node* newNode = createNode(data);

    if (head == NULL) { // if list is empty
        head = newNode;
        printf("Inserted %d at the end.\n", data);
        return;
    }

    struct Node* temp = head;
    while (temp->next != NULL) {
        temp = temp->next;
    }

    temp->next = newNode;
    newNode->prev = temp;

    printf("Inserted %d at the end.\n", data);
}

// Function to insert a node at a specific position
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

    for (int i = 1; temp != NULL && i < position - 1; i++) {
        temp = temp->next;
    }

    if (temp == NULL) {
        printf("Position greater than number of nodes.\n");
        free(newNode);
        return;
    }

    newNode->next = temp->next;
    newNode->prev = temp;

    if (temp->next != NULL)
        temp->next->prev = newNode;

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

    if (head != NULL)
        head->prev = NULL;

    printf("Deleted %d from start.\n", temp->data);
    free(temp);
}

// Function to delete from the end
void deleteAtEnd() {
    if (head == NULL) {
        printf("List is empty.\n");
        return;
    }

    struct Node* temp = head;

    if (temp->next == NULL) { // only one node
        printf("Deleted %d from end.\n", temp->data);
        free(temp);
        head = NULL;
        return;
    }

    while (temp->next != NULL)
        temp = temp->next;

    printf("Deleted %d from end.\n", temp->data);
    temp->prev->next = NULL;
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

    for (int i = 1; temp != NULL && i < position; i++) {
        temp = temp->next;
    }

    if (temp == NULL) {
        printf("Position greater than number of nodes.\n");
        return;
    }

    printf("Deleted %d from position %d.\n", temp->data, position);

    if (temp->prev != NULL)
        temp->prev->next = temp->next;

    if (temp->next != NULL)
        temp->next->prev = temp->prev;

    free(temp);
}

// Function to display the list forward and reverse
void display() {
    if (head == NULL) {
        printf("List is empty.\n");
        return;
    }

    struct Node* temp = head;
    struct Node* last = NULL;

    printf("Forward: NULL <-> ");
    while (temp != NULL) {
        printf("%d <-> ", temp->data);
        last = temp;
        temp = temp->next;
    }
    printf("NULL\n");

    printf("Reverse: NULL <-> ");
    temp = last; // start from the last node
    while (temp != NULL) {
        printf("%d <-> ", temp->data);
        temp = temp->prev;
    }
    printf("NULL\n");
}

// Main menu-driven function
int main() {
    int choice, data, position;

    while (1) {
        printf("\n--- Doubly Linked List Operations ---\n");
        printf("1. Insert at Start\n");
        printf("2. Insert at Position\n");
        printf("3. Insert at End\n");
        printf("4. Delete from Start\n");
        printf("5. Delete from Position\n");
        printf("6. Delete from End\n");
        printf("7. Display List (Forward & Reverse)\n");
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

