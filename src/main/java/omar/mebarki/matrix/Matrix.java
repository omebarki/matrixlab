package omar.mebarki.matrix;

public interface Matrix {
    Matrix add(Matrix matrix);

    Matrix sub(Matrix matrix);

    Matrix mult(Matrix matrix);

    Matrix mult(double scalar);

    Matrix transpose();

    double getValueAt(int row, int col);

    Matrix setValueAt(double value, int row, int col);

    int getNumRows();

    int getNumColumns();

    double trace();
}
