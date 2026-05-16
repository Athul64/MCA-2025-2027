#include <stdio.h>
#define INF 999

void main() {
    int v, i, j, adj[10][10], tot = 0, no_edge = 0;
    int visited[10] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    printf("Enter the no of vertices: ");
    scanf("%d", &v);

    printf("Enter the Adjacency Matrix\n");
    for (i = 1; i <= v; i++) {
        for (j = 1; j <= v; j++) {
            scanf("%d", &adj[i][j]);
            if (adj[i][j] == 0)
                adj[i][j] = INF;
        }
    }

    printf("Edges are \n");
    while (no_edge < v - 1) {
        int min = INF, a = 0, b = 0;

        for (i = 1; i <= v; i++) {
            for (j = 1; j <= v; j++) {
                if (adj[i][j] < min) {
                    min = adj[i][j];
                    a = i;
                    b = j;
                }
            }
        }

        printf("Edge %d -> %d cost = %d\n", a, b, min);
        no_edge++;
        visited[a] = visited[b] = 1;
        tot = tot + min;

        adj[a][b] = adj[b][a] = INF;
    }

    printf("Total Cost using Kruskal's algorithm = %d\n", tot);
}

