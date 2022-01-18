package inz.opr.zadanie4;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Rownanie {
    public double[] oblicz(double a, double b, double c) {
        double delta = pow(b,2) - 4 * a * c;

        if (delta > 0)
        {
            double pierwiastek = sqrt(delta);
            double x1 = (-b - pierwiastek) / (2 * a);
            double x2 = (-b + pierwiastek) / (2 * a);
            return new double[] {x1, x2};
        }

        if (delta == 0) {
            double x0 = -b / (2 * a);
            return new double[] {x0};
        }

        return new double[] {};
    }

}
