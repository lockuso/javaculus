package com.lock.javaculus.calculus;

public class Product {
    public static double productOfFunction(IFunction function, int startIndex, int finalIndex) {
        if (startIndex > finalIndex) {
            return 1;
        } else if (startIndex == finalIndex) {
            return function.fun(startIndex);
        }

        double total = function.fun(startIndex);

        for (int i = startIndex + 1; i < finalIndex + 1; i++) {
            total *= function.fun(i);
        }

        return total;
    }

    public static double productOfEquation(Equation equation, int startIndex, int finalIndex) {
        if (startIndex > finalIndex) {
            return 1;
        } else if (startIndex == finalIndex) {
            return equation.calculateEquation(startIndex);
        }

        double total = equation.calculateEquation(startIndex);

        for (int i = startIndex + 1; i < finalIndex + 1; i++) {
            total *= equation.calculateEquation(i);
        }

        return total;
    }
}
