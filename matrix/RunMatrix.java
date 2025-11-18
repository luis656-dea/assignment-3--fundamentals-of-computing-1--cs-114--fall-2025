
public class RunMatrix {
  public static void main(String[] args) {
    Matrix mymatrix = new Matrix(5);
  }
}

class Matrix {
  private final int[][] matrix;
  private final int size;
  private static final String YELLOW = "\u001B[33m";
  private static final String RESET = "\u001B[0m";

  public Matrix(int size) {
    this.size = size;
    this.matrix = new int[size][size];
    System.out.println("Created matrix of dimensions " + size + " x " + size);
  }

  private void swap(int x1, int y1, int x2, int y2) {
    int tmp = matrix[y1][x1];
    matrix[y1][x1] = matrix[y2][x2];
    matrix[y2][x2] = tmp;
  }

  public void printMatrix() {
    int max = size * size;
    int width = Integer.toString(max).length() + 1; // +1 for spacing
    for (int r = 0; r < size; r++) {
      StringBuilder sb = new StringBuilder();
      for (int c = 0; c < size; c++) {
        String formatted = String.format("%" + width + "d", matrix[r][c]);
        // highlight anti-diagonal (top-right to bottom-left): c == size-1-r
        if (c == size - 1 - r) {
          sb.append(YELLOW).append(formatted).append(RESET);
        } else {
          sb.append(formatted);
        }
      }
      System.out.println(sb.toString());
    }
    System.out.println();
  }

  public void populateMatrix() {
    int val = 1;
    for (int r = 0; r < size; r++) {
      for (int c = 0; c < size; c++) {
        matrix[r][c] = val++;
      }
    }
  }

  public void flipMatrix() {
    // Reflection across the anti-diagonal (top-right to bottom-left)
    // pair for (r,c) is (size-1-c, size-1-r). Swap only when r + c < size - 1.
    for (int r = 0; r < size; r++) {
      for (int c = 0; c < size; c++) {
        if (r + c < size - 1) {
          int r2 = size - 1 - c;
          int c2 = size - 1 - r;
          swap(c, r, c2, r2);
        }
      }
    }
  }
}
