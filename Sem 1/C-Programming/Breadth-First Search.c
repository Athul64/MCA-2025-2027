#include <stdio.h>
#define MAX 100

int queue[MAX];
int front = 0, rear = 0;
int visited[MAX] = {0};

void enqueue(int x) {
    queue[rear++] = x;
}

int dequeue() {
    return queue[front++];
}

void bfs(int graph[MAX][MAX], int start, int n) {
    front = rear = 0;           
    for (int i = 0; i < n; i++) visited[i] = 0;  

    enqueue(start);
    visited[start] = 1;

    while (front < rear) {
        int node = dequeue();
        printf("%d ", node + 1);  

        for (int i = 0; i < n; i++) {
            if (graph[node][i] == 1 && visited[i] == 0) {
                enqueue(i);
                visited[i] = 1;
            }
        }
    }
}

int main() {
    int n, start;
    int graph[MAX][MAX];

    printf("Enter number of vertices: ");
    scanf("%d", &n);

    if (n > MAX) {
        printf("Error: maximum number of vertices is %d\n", MAX);
        return 1;
    }

    printf("Enter adjacency matrix:\n");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            scanf("%d", &graph[i][j]);
        }
    }

    printf("Enter starting node (1 to %d): ", n);
    scanf("%d", &start);

    if (start < 1 || start > n) {
        printf("Invalid starting node!\n");
        return 1;
    }

    printf("BFS Traversal: ");
    bfs(graph, start - 1, n); 
    printf("\n");

    return 0;
}
