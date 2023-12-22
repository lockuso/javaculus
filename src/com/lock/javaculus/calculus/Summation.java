package com.lock.javaculus.calculus;

public class Summation {
    public static double sumOfFunction(IFunction function, int startIndex, int finalIndex) {
        if (startIndex > finalIndex) {
            double total = 0d;

            for (int i = startIndex; i > finalIndex - 1; i--) {
                total += function.fun(i);
            }

            return total;
        }

        double total = 0d;

        for (int i = startIndex; i < finalIndex + 1; i++) {
            total += function.fun(i);
        }

        return total;
    }

    public static double sumOfEquation(Equation equation, int startIndex, int finalIndex) {
        if (startIndex > finalIndex) {
            double total = 0d;

            for (int i = startIndex; i > finalIndex - 1; i--) {
                total += equation.calculateEquation(i);
            }

            return total;
        }

        double total = 0d;

        for (int i = startIndex; i < finalIndex + 1; i++) {
            total += equation.calculateEquation(i);
        }

        return total;
    }
}
