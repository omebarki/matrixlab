package omar.mebarki.matrix.ch2;

import omar.mebarki.matrix.ArrayMatrix;
import omar.mebarki.matrix.Matrix;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Ch2Exo2 {

    private static final Matrix A = new ArrayMatrix(
            new double[][]{
                    {2, 4,},
                    {0, 3}
            });
    private static final Matrix B = new ArrayMatrix(
            new double[][]{
                    {-2, -1},
                    {6, 7}
            });

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void exo_2_a() {
        double result = A.trace();
        System.out.println(result);
    }

    @Test
    void exo_2_b() {
        double result = A.mult(-3D).trace();
        System.out.println(result);
    }

    @Test
    void exo_2_c() {
        double result = A.add(B).trace();
        System.out.println(result);
    }

    @Test
    void exo_2_d() {
        double result = A.add(B).transpose().trace();
        System.out.println(result);
    }

    @Test
    void exo_2_e() {
        double result = B.transpose().add(A).trace();
        System.out.println(result);
    }
    @Test
    void exo_2_f() {
        double result = B.add(A.transpose()).trace();
        System.out.println(result);
    }
}