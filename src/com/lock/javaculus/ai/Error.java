package com.lock.javaculus.ai;

public class Error {
    public static double error(double output, double expectedOutput) {
        return Math.pow(output - expectedOutput, 2);
    }
}
