public class Matrix {
    protected int[][] matrix;
    protected int size;

    /* build the matrice and initialise with 0*/
    public Matrix(int size) {
        this.size = size;
        matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = 0;
            }
        }
    }
    /* Input of the value into the matrice */
    public void setValue(int row, int col, int value) {
        if (row >= 0 && row < size && col >= 0 && col < size) {
            matrix[row][col] = value;
        } else {
            System.out.println("Invalid index");
        }
    }

    /* show the matrice */
    public void displayMatrix() {
        System.out.print("   ");
        for (char col = 'A'; col < 'A' + size; col++) {
            System.out.print(col + " ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void clean(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j]==matrix[j][i] && matrix[i][j]!=0) {
                    matrix[j][i]=-1;
                }
            }
        }
        System.out.println("Table cleaned successfully");
    }
}