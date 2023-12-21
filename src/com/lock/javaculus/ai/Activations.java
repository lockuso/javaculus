package com.lock.javaculus.ai;

public class Activations {
    /*
    * Stores activation functions (such as tanh, sigmoid, etc)
    * */

    private static final double E = 2.71828182845904d;
    private static final double PI = 3.1415926535d;

    public static double sigmoid(double valueIn) {
        return 1 / (1 + Math.pow(E, -valueIn));
    }

    public static double tanhWithClamping(double valueIn, double minValue, double maxValue) {
        /*
        * This makes sure your value is within a -1 to 1 value
        * */

        double newValueIn = ((valueIn - maxValue) / ((maxValue - minValue) / 2)) + 1;

        return Math.tanh(newValueIn);
    }

    public static double rectifiedLinearUnit(double valueIn) {
        return Math.max(0, valueIn);
    }

    public static double geluWithClamping(double valueIn, double minValue, double maxValue) {
        double halfValue = valueIn / 2;
        double root1 = Math.sqrt(2 / PI);
        double cubicTerm = (valueIn + (0.044715f * Math.pow(valueIn, 3)));

        double tanhTerm = tanhWithClamping(cubicTerm * root1, minValue, maxValue);

        return halfValue * (1 + tanhTerm);
    }

    public static double rawGelu(double valueIn) {
        double halfValue = valueIn / 2;
        double root1 = Math.sqrt(2 / PI);
        double cubicTerm = (valueIn + (0.044715f * Math.pow(valueIn, 3)));

        double tanhTerm = Math.tanh(valueIn);

        return halfValue * (1 + tanhTerm);
    }

    public static double silu(double valueIn) {
        return valueIn * sigmoid(valueIn);
    }
}
