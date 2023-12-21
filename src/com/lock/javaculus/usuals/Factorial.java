package com.lock.javaculus.usuals;

import com.lock.javaculus.calculus.Equation;
import com.lock.javaculus.calculus.IFunction;
import com.lock.javaculus.calculus.Product;
import com.lock.javaculus.calculus.Summation;

public class Factorial {
    /*
        Implementation of factorials using a lil' bit of math.

        imma use bare calculus in this

     */

    public static int N = 1000; // feel free to set this to whatever you want

    private static class BasicFactorialFunction implements IFunction {
        public static final BasicFactorialFunction THIS = new BasicFactorialFunction();

        @Override
        public double fun(double in) {
            return in;
        }
    }

    private static class RecursiveFactorialFunction implements IFunction {
        private int x;

        public void setX(int x) {
            this.x = x;
        }

        public int getX() {
            return x;
        }

        @Override
        public double fun(double in) {
            return x + in;
        }
    }

    private static class LnFunction implements IFunction {
        private double x;

        public void setX(double x) {
            this.x = x;
        }

        public double getX() {
            return x;
        }

        @Override
        public double fun(double in) {
            return Math.log(in / (x + in));
        }
    }

    public static int factoriali(int x) {
        // runs using the PI of 1 + (x - 1)

        return (int) Product.productOfFunction(BasicFactorialFunction.THIS, 1, x);
    }

    public static int recursiveFactoriali(int x, int n) {
        // runs using the formula x! * PI(1 -> n = k, (x + k))

        RecursiveFactorialFunction function = new RecursiveFactorialFunction();

        function.setX(x);

        return (int) Product.productOfFunction(function, 1, n);
    }

    private static double factorialInterpolation(int N, double x) {
        LnFunction function = new LnFunction();
        function.setX(x);

        return Summation.sumOfFunction(function, 1, N) + (x * Math.log(N));
    }

    public static double recursiveFactoriald(double x) {
        return Math.pow(Math.E, factorialInterpolation(Factorial.N, x));
    }
}
