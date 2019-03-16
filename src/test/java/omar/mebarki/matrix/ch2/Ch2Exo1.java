package omar.mebarki.matrix.ch2;

import omar.mebarki.matrix.ArrayMatrix;
import omar.mebarki.matrix.Matrix;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Ch2Exo1 {

    private static final Matrix A = new ArrayMatrix(
            new double[][]{
                    {2, 4, 3},
                    {0, 1, 3}
            });
    private static final Matrix B = new ArrayMatrix(
            new double[][]{
                    {-2, -1, 3},
                    {6, -7, 7}
            });
    private static final Matrix C = new ArrayMatrix(
            new double[][]{
                    {0, -6},
                    {-3, -2},
                    {-2, 7}
            });
    private static final Matrix D = new ArrayMatrix(
            new double[][]{
                    {1, 2},
                    {3, 4},
                    {2, 4}
            });

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void exo_1_a() {
        Matrix result = A.add(B.mult(3D));
        System.out.println(result);
    }


    @Test
    void exo_1_d() {
        Matrix result = D.add(C);
        System.out.println(result);
    }

    @Test
    void exo_1_e() {
        Matrix result = A.transpose().add(D);
        System.out.println(result);
    }

    @Test
    void exo_1_f() {
        Matrix result = A.add(B).transpose().add(C.mult(2D));
        System.out.println(result);
    }

    @Test
    void exo_1_g() {
        Matrix result = A.mult(3).add(B.transpose().add(C).transpose());
        System.out.println(result);
    }

}