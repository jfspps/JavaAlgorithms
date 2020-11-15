package ArrayList.algorithms;

public class RotateMatrix {

    // this class rotates an NxN matrix 90 degrees to the right
    // the matrix is flipped along the diagonal (transposed) and then flipped vertically

    private final int[][] matrix;

    public RotateMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    // in place changes, time complexity is O(N*N/2 + N*N/2) or just O(n^2)
    public void rotateNinetyDegrees(){
        transposeMatrix();
        flipVertical();
    }

    // in place changes, time complexity is O(N*N/2) or just O(n^2)
    public void transposeMatrix(){
        for (int i = 1; i < this.matrix.length; i++){
            for (int j = 0; j < i; j++){
                int temp = this.matrix[i][j];
                this.matrix[i][j] = this.matrix[j][i];
                this.matrix[j][i] = temp;
            }
        }
    }

    // in place changes, time complexity is O(N*N/2) or just O(n^2)
    public void flipVertical(){
        for (int i = 0; i < this.matrix.length; i++){
            for (int j = 0; j < this.matrix.length/2; j++){
                int temp = this.matrix[i][j];
                this.matrix[i][j] = this.matrix[i][this.matrix.length - j - 1];
                this.matrix[i][this.matrix.length - j - 1] = temp;
            }
        }
    }

    public void printMatrix(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.matrix.length; i++){
            for (int j = 0; j < this.matrix[i].length; j++){
                stringBuilder.append(this.matrix[i][j]);
                stringBuilder.append(' ');
            }
            stringBuilder.append('\n');
        }
        System.out.println(stringBuilder);
    }
}
