package inz.opr.zadanie4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class RownanieTest {

    private Rownanie rownanie;

    @BeforeEach
    void setUp() {
        rownanie = new Rownanie();
    }

    @ParameterizedTest
    @CsvSource({"1, 4, 3, -3, -1",
                "1, 3, -4, -4, 1",
                "1, 6, 8, -4, -2"})
    @DisplayName("Powinno zwrócić dwa pierwiastki równania")
    void shouldReturnTwoRoots(double a, double b, double c, double x1, double x2) {
        var result = rownanie.oblicz(a, b, c);
        assertArrayEquals(new double[] {x1, x2}, result);
    }

    @ParameterizedTest
    @CsvSource({"-2, 4, -2, 1"})
    @DisplayName("Powinno zwrócić jeden pierwiastek równania")
    void shouldReturnOneRoot(double a, double b, double c, double x0) {
        var result = rownanie.oblicz(a, b, c);
        assertArrayEquals(new double[] {x0}, result);
    }

    @ParameterizedTest
    @CsvSource({"1, 1, 1",
                "2, 2, 2"})
    @DisplayName("Nie powinno zwrócić pierwiastków")
    void shouldReturnNoRoots(double a, double b, double c) {
        var result = rownanie.oblicz(a, b, c);
        assertEquals(0, result.length);
    }

    @Test
    @DisplayName("Powinno rzucić IllegalArgumentException gdy a == 0")
    void shouldThrowExceptionOnZeroedFirstArgument() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> rownanie.oblicz(0, 1, 2));
    }


}
