package inz.opr.zadanie4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RownanieTest {
    @ParameterizedTest
    @CsvSource({"1, 4, 3, -3, -1"})
    void shouldReturnTwo(double a, double b, double c, double x1, double x2) {
        var rownanie = new Rownanie();
        var result = rownanie.oblicz(a, b, c);
        assertArrayEquals(new double[] {x1, x2}, result);
    }
}
