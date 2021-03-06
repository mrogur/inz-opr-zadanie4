/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package inz.opr.zadanie4;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.String.format;

public class App {

    private String[] promptValues() {
        System.out.print("Podaj wartości a b c: ");
        var scanner = new Scanner(System.in);
        return scanner.nextLine().split(" ");
    }


    public static void main(String[] args) {
        var app = new App();
        app.run(args);
    }

    public void run(String[] args) {
        var arg = args.length == 0 ? promptValues() : args;
        if (arg.length != 3) {
            throw new IllegalArgumentException(
                    format("Nieprawidłowa ilość parametrów: %d %s",
                            arg.length,
                            Arrays.toString(arg)));
        }
        var rownanie = new Rownanie();
        var input = convertToDoubleArray(arg);
        double[] wynik = rownanie.oblicz(input[0], input[1], input[2]);
        wyswietlWynik(arg, wynik);
    }

    private void wyswietlWynik(String[] arg, double[] wynik) {
        switch (wynik.length) {
            case 2 -> System.out.printf("Dla argumentów: %s równanie ma dwa pierwiastki rzeczywiste:" +
                    " x1: %.2f x2: %.2f ", Arrays.toString(arg), wynik[0], wynik[1]);
            case 1 -> System.out.printf("Dla argumentów: %s równanie ma jeden pierwiastek rzeczywisty:" +
                    " x0: %.2f ", Arrays.toString(arg), wynik[0]);
            case 0 -> System.out.println("Równanie nie ma pierwiastków rzeczywistych");
        }
    }

    public double[] convertToDoubleArray(String[] arg) {
        return Arrays.stream(arg).mapToDouble(Double::parseDouble).toArray();
    }
}
