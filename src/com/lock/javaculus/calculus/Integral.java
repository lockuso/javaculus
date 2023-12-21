package com.lock.javaculus.calculus;

import com.lock.javaculus.Constants;

public class Integral {
    private int stepsPerUnit;
    private Object currentFunction;

    public Integral(int stepsPerUnit) {
        this.stepsPerUnit = stepsPerUnit;
    }

    public Integral setCurrentFunction(IFunction function) {
        this.currentFunction = function;

        return this;
    }

    public Integral setCurrentFunction(Equation equation) {
        this.currentFunction = equation;

        return this;
    }

    public int getStepsPerUnit() {
        return stepsPerUnit;
    }

    public Integral setStepsPerUnit(int stepsPerUnit) {
        this.stepsPerUnit = stepsPerUnit;

        return this;
    }

    private double step(int atX, int atSteps) throws Exception {
        if (currentFunction instanceof IFunction) {
            return ((IFunction) currentFunction).fun(atX + ((float) atSteps / stepsPerUnit));
        } else if (currentFunction instanceof Equation) {
            return ((Equation) currentFunction).calculateEquation(atX + ((float) atSteps / stepsPerUnit));
        } else {
            throw new Exception("the type of the current function is somehow not correct");
        }
    }

    public double calculateDefiniteIntegral(int start, int end) throws Exception {
        double total = 0d;
        double oldValue = step(start, 0);

        for (int i = start; i < end; i++) {
            for (int d = 1; d < stepsPerUnit; d++) {
                double newValue = step(i, d);

                total += newValue - oldValue;

                oldValue = newValue;
            }
        }

        return total;
    }
}
