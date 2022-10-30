import java.io.PrintStream;

public class Matrix {
    private int[][] data = null;

    static Matrix create(int n) throws ArgumentTooLargeException {
        if (n > 1000000) {
            throw new ArgumentTooLargeException();
        }

        Matrix resultMatrix = new Matrix();
        resultMatrix.data = new int[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int value = (int)((Math.random() * (2 * n + 2)) - n - 1);
                resultMatrix.data[i][j] = value;
            }
        }

        return resultMatrix;
    }

    public Matrix rotate() {
        Matrix resultMatrix = new Matrix();
        resultMatrix.data = new int[data.length][data.length];

        for (int i = 0; i < data.length; ++i) {
            for (int j = 0; j < data.length; ++j) {
                resultMatrix.data[i][j] = data[j][data.length - 1 - i];
            }
        }

        return resultMatrix;
    }

    public double at(int row, int column) {
        return data[row][column];
    }

    public void print(PrintStream stream) {
        for (int i = 0; i < data.length; ++i)  {
            for (int j = 0; j < data.length; ++j) {
                stream.print(data[i][j] + " ");
            }

            stream.println();
        }
    }

    public int nearSum(int row, int column) {
        int result = 0;

        for (int i = row - 1; i < row + 2; ++i) {
            for (int j = column - 1; j < column + 2; ++j) {
                // Пропустить центр
                if (i == row && j == column) {
                    continue;
                }

                if (i < 0 || j < 0 || i >= data.length || j >= data.length) {
                    continue;
                }
                result += data[i][j];
            }
        }

        return result;
    }

    public Matrix divide() throws DivisionByZeroException {
        Matrix resultMatrix = new Matrix();
        resultMatrix.data = new int[data.length][data.length];

        for (int i = 0; i < data.length; ++i) {
            for (int j = 0; j < data.length; ++j) {
                int sum = nearSum(i, j);

                if (sum == 0) {
                    throw new DivisionByZeroException();
                }
                resultMatrix.data[i][j] = data[i][j] / nearSum(i, j);
            }
        }

        return resultMatrix;
    }
}
