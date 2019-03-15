package omar.mebarki.matrix;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.function.ToDoubleBiFunction;

public class ArrayMatrix implements Matrix {
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.#");
    private final double arrayMatrix[][];

    public ArrayMatrix(final int rowsCount, final int columnsCount) {
        if ((rowsCount == 0) && (columnsCount == 0)) {
            throw new IllegalArgumentException();
        }
        this.arrayMatrix = new double[rowsCount][columnsCount];
    }

    public ArrayMatrix(double[][] arrayMatrix) {
        this.arrayMatrix = arrayMatrix;
    }

    @Override
    public Matrix add(Matrix matrix) {
        return addSub(matrix, (n1, n2) -> n1 + n2);
    }

    @Override
    public Matrix sub(Matrix matrix) {
        return addSub(matrix, (n1, n2) -> n1 - n2);
    }

    private Matrix addSub(Matrix matrix, ToDoubleBiFunction<Double, Double> addOrSub) {
        if (this.getNumRows() != matrix.getNumRows() ||
                this.getNumColumns() != matrix.getNumColumns()) {
            throw new IllegalArgumentException();
        }
        final double[][] newArray = new double[getNumRows()][getNumColumns()];
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumColumns(); j++) {
                newArray[i][j] = addOrSub.applyAsDouble(this.arrayMatrix[i][j], matrix.getValueAt(i, j));
            }
        }
        return new ArrayMatrix(newArray);
    }

    @Override
    public Matrix mult(Matrix matrix) {
        if (this.getNumColumns() != matrix.getNumRows()) {
            throw new IllegalArgumentException();
        }
        final double[][] newArray = new double[getNumRows()][matrix.getNumColumns()];
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < matrix.getNumColumns(); j++) {
                newArray[i][j] = multIJ(matrix, i, j);
            }
        }
        return new ArrayMatrix(newArray);
    }

    @Override
    public Matrix mult(double scalar) {
        final double[][] newArray = arrayMatrix.clone();
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumColumns(); j++) {
                newArray[i][j] = newArray[i][j] * scalar;
            }
        }
        return new ArrayMatrix(newArray);
    }

    private double multIJ(Matrix matrix, int i, int j) {
        double res = 0D;
        for (int k = 0; k < getNumColumns(); k++) {
            res += (arrayMatrix[i][k] * matrix.getValueAt(k, j));
        }
        return res;
    }


    @Override
    public Matrix transpose() {
        final double matrix[][] = new double[getNumColumns()][getNumRows()];
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumColumns(); j++) {
                matrix[j][i] = arrayMatrix[i][j];
            }
        }
        return new ArrayMatrix(matrix);
    }

    @Override
    public double getValueAt(int row, int col) {
        return arrayMatrix[row][col];
    }

    @Override
    public Matrix setValueAt(double value, int row, int col) {
        double[][] copy = Arrays.stream(arrayMatrix).map(r -> r.clone()).toArray(double[][]::new);
        copy[row][col] = value;
        return new ArrayMatrix(copy);
    }

    @Override
    public int getNumRows() {
        return arrayMatrix.length;
    }

    @Override
    public int getNumColumns() {
        return arrayMatrix[0].length;
    }

    @Override
    public String toString() {
        int cellMaxLength = 0;
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumColumns(); j++) {
                cellMaxLength = Math.max(DECIMAL_FORMAT.format(arrayMatrix[i][j]).length(), cellMaxLength);
            }
        }
        String result = "";
        cellMaxLength += 3;
        for (int i = 0; i < getNumRows(); i++) {
            for (int j = 0; j < getNumColumns(); j++) {
                result += rpad(DECIMAL_FORMAT.format(arrayMatrix[i][j]), cellMaxLength, Character.valueOf(' '));
            }
            if (i < getNumRows() - 1) {
                result += "\n";
            }
        }
        return result;
    }

    private String rpad(String str, int maxLength, Character pad) {
        String result = str;
        for (int i = 0; i < maxLength - str.length(); i++) {
            result += pad;
        }
        return result;
    }
}
