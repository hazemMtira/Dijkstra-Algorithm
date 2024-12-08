import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner clav=new Scanner(System.in);
        System.out.print("hello to dijkastra calculator please enter the number of point you will use  :");
        int NB=clav.nextInt(); /* number of points */
        Matrix M=new Matrix(NB); /* creating the matrice of points */
        M.displayMatrix(); /* show it  */
        /* start to get values */
        for (int i = 0; i < NB; i++) {
            for (int j = 0; j < NB; j++) {
                System.out.print("Enter value at (" + (char) ('A' + i) + "," + (char) ('A' + j) + "): "); /* show wish "arrete" you are in */
                int x=clav.nextInt();
                M.setValue(i, j, x);
                M.displayMatrix();
            }
        }
        M.clean(); /* remove the doubled values like (A,B) (B,A) */
        M.displayMatrix();
        Graph G=new Graph(M); /* call for Graph where the work gonna be  */
        G.dijkstra(NB);/* call for the method to do the calculations */
    }
}