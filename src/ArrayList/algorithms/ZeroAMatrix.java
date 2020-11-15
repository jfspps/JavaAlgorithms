package ArrayList.algorithms;

public class ZeroAMatrix {

    // set all elements in any row or column which contains at least one zero element, to zero

    private final int[][] matrix;

    public ZeroAMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public void setToZero(){
        initialiseZeroElements();
        for (int i = 0; i < this.matrix.length; i++){
            for (int j = 0; j < this.matrix[0].length; j++){
                if (this.matrix[i][j] <= 0){
                    this.matrix[i][j] = 0;
                }
            }
        }
    }

    public void initialiseZeroElements(){
        for (int i = 0; i < this.matrix.length; i++){
            for (int j = 0; j < this.matrix[0].length; j++){
                if (this.matrix[i][j] == 0){
                    flagZeroElements(i, j);
                }
            }
        }
    }

    private void flagZeroElements(int i_index, int j_index) {
        // zero all element in the j-th column
        int i = 0, j = 0;
        while (i < this.matrix.length){
            if (this.matrix[i][j_index] > 0){
                this.matrix[i][j_index] = -this.matrix[i][j_index];
            }
            i++;
        }

        //zero all elements in the i-th row
        while (j < this.matrix[0].length){
            if (this.matrix[i_index][j] > 0){
                this.matrix[i_index][j] = -this.matrix[i_index][j];
            }
            j++;
        }
    }

    public void printMatrix(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.matrix.length; i++){
            for (int j = 0; j < this.matrix[i].length; j++){
                stringBuilder.append(this.matrix[i][j]);
                stringBuilder.append('\t');
            }
            stringBuilder.append('\n');
        }
        System.out.println(stringBuilder);
    }
}
