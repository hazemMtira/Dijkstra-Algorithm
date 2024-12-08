import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    protected Matrix M;

    public Graph(Matrix M) {
        this.M = M;
    }

    /* find the point with the minium distance */
    private int Min(int[] distances, boolean[] visited, int NB) {
        int min = 100000000;
        int minIndex = -1;

        for (int i = 0; i < NB; i++) {
            if (!visited[i] && distances[i] < min) {
                min = distances[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public void dijkstra(int NB) {
        /*  Initialize distances and visited nodes  */
        int[] distances = new int[NB];
        /*  creating the matrice that we work on and Set all distances to the max value  */
        Arrays.fill(distances, 100000000); 
        /*  initialise point (A) always distance 0  */
        distances[0] = 0; 
        /*  Track visited nodes  */
        boolean[] visited = new boolean[NB]; 

        // Initialize the previous point array for path storage
        int[] prev = new int[NB];
        Arrays.fill(prev, -1);

        // Dijkstra's algorithm
        /*  Find the unvisited node with the smallest distance  */
        for (int i = 0; i < NB - 1; i++) {
            int u=Min(distances, visited, NB); 
            if (u == -1) {
                System.out.println("No valid minimum found. Dijkstra's algorithm cannot proceed further.");
                return; /*  If no valid node was found, stop the algorithm  */
            }
            /*Mark point as visited*/
            visited[u] = true; 

            /*  Update distances for the neighbors of u  */
            for (int v = 0; v < NB; v++) {
                if (visited[v]==false && M.matrix[u][v] != -1 && distances[u] != 1000000000) {
                    int newD = distances[u] + M.matrix[u][v];
                    if (newD < distances[v]) {
                        distances[v] = newD;
                        prev[v] = u;
                    }
                }
            }
        }

        /* Reconstruct the path from 'A' (0 index) to the last node */
        StringBuilder path = new StringBuilder();
        int lastP = NB - 1;

        if (distances[lastP] == 1000000000) {
            System.out.println("No valid path found.");
            System.out.println("TOTAL STEPS = 0");
            return;
        }

        /*  Construct the path */
        ArrayList<Character> pathList = new ArrayList<>();
        while (lastP != -1) {
            pathList.add((char) (lastP + 65)); 
            lastP = prev[lastP];
        }

        /*  Reverse the path  */
        for (int i = pathList.size() - 1; i >= 0; i--) {
            path.append(pathList.get(i));
            if (i != 0) {
                path.append("-");
            }
        }

        // Output
        System.out.println("Path: " + path);
        System.out.println("TOTAL STEPS = " + distances[NB - 1]);
    }
}
