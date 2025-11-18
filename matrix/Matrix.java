
public class Matrix {

  private int[][] matrix;
  private int size1;
  private int size2;

  public Matrix(int size1, int size2) {
    this.size1 = size1;
    this.size2 = size2;
    matrix = new int[size1][size2];
    matrix[0][0] = 1;
  }
