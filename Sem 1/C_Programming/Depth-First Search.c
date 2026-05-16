#include <stdio.h>
#include <stdlib.h>

int n, adj[10][10], vis[10], st, top = -1, stk[10], i, j, p;

void push(int item) {
    if (top == 9) {
        printf("\nStack is full");
    } else {
        top++;
        stk[top] = item;
    }
}

int pop() {
    if (top == -1) {
        return 0;
    } else {
        p = stk[top];
        top--;
        return p;
    }
}

void dfs(int s, int n) {
    push(s);
    vis[s] = 1;
    p = pop();
    if (p != 0)
        printf("%d ", p);

    while (p != 0) {
        for (i = 1; i <= n; i++) {
            if (adj[p][i] == 1 && vis[i] == 0) {
                push(i);
                vis[i] = 1;
            }
        }
        p = pop();
        if (p != 0)
            printf("%d ", p);
    }
}

int main() {
    printf("\nEnter the number of vertices: ");
    scanf("%d", &n);

    printf("\nEnter the adjacency matrix:\n");
    for (i = 1; i <= n; i++) {
        for (j = 1; j <= n; j++) {
            scanf("%d", &adj[i][j]);
        }
    }

    printf("\nEnter starting vertex: ");
    scanf("%d", &st);

    printf("\nDFS ORDER:\n");
    dfs(st, n);
    printf("\n");
    
    return 0;
}

