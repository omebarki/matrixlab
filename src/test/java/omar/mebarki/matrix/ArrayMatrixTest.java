package omar.mebarki.matrix;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayMatrixTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void add() {
        double a1[][] = {{1D, 2D}};
        Matrix m1 = new ArrayMatrix(a1);
        double a2[][] = {{2D, 3D}};
        Matrix m2 = new ArrayMatrix(a2);

        Matrix result = m1.add(m2);
        assertEquals(3, result.getValueAt(0, 0));
        assertEquals(5, result.getValueAt(0, 1));
    }

    @Test
    void sub() {
        double a1[][] = {{1D, 2D},
                {3D, 4D}};
        Matrix m1 = new ArrayMatrix(a1);
        double a2[][] = {{2D, 3D},
                {7D, 4D}};
        Matrix m2 = new ArrayMatrix(a2);

        Matrix result = m1.sub(m2);
        assertEquals(-1D, result.getValueAt(0, 0));
        assertEquals(-1D, result.getValueAt(0, 1));
        assertEquals(-4D, result.getValueAt(1, 0));
        assertEquals(0D, result.getValueAt(1, 1));
    }

    @Test
    void mult() {
        double a1[][] = {{1D, 2D},
                {3D, 4D}};
        Matrix m1 = new ArrayMatrix(a1);
        double a2[][] = {{2D, 3D, 5D},
                {7D, 4D, 6D}};
        Matrix m2 = new ArrayMatrix(a2);

        Matrix result = m1.mult(m2);
        assertEquals(16D, result.getValueAt(0, 0));
        assertEquals(11D, result.getValueAt(0, 1));
        assertEquals(17D, result.getValueAt(0, 2));
        assertEquals(34D, result.getValueAt(1, 0));
        assertEquals(25D, result.getValueAt(1, 1));
        assertEquals(39D, result.getValueAt(1, 2));
    }

    @Test
    void transpose() {
        double a1[][] = {{2D, 3D, 5D},
                {7D, 4D, 6D}};
        Matrix m1 = new ArrayMatrix(a1);

        double a2[][] = {{2D, 7D}, {3D, 4D}, {5D, 6D}};

        Matrix m2 = m1.transpose();
        assertEquals(3, m2.getNumRows());
        assertEquals(2, m2.getNumColumns());
        for (int i = 0; i < a2.length; i++) {
            for (int j = 0; j < a2[0].length; j++) {
                assertEquals(a2[i][j], m2.getValueAt(i, j));
            }
        }

    }

    @Test
    void getNumRows() {
        Matrix matrix = new ArrayMatrix(20, 25);
        assertEquals(20, matrix.getNumRows());
    }

    @Test
    void getNumColumns() {
        Matrix matrix = new ArrayMatrix(20, 25);
        assertEquals(25, matrix.getNumColumns());
    }


    @Test
    void testToString() {
        double a1[][] = {{-23D, 3D, 5D},
                {7D, 4545D, 6D},
                {23D, 3D, 5D},
                {123D,7D, 4D}};
        Matrix m1 = new ArrayMatrix(a1);
        System.out.println(m1);
    }
}