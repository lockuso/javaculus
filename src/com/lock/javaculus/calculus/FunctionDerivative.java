package com.lock.javaculus.calculus;

import java.util.HashMap;

public class FunctionDerivative {
    private final IFunction function;
    private double h = 0.00001;

    private HashMap<Double, Double> cache = new HashMap<>(); // stores previously used values

    public FunctionDerivative(IFunction function) {
        this.function = function;
    }

    public void setDerivativeTestGap(double h) {
        this.h = h;
    }

    public double rawDerivativeCalculation(double valueIn) {
        if (!(cache.containsKey(valueIn) | cache.containsKey(valueIn + h))) {
            double newValue = valueIn + h;

            cache.put(valueIn, this.function.fun(valueIn));
            cache.put(newValue, this.function.fun(newValue));
        }

        return (cache.get(valueIn + h) - cache.get(valueIn)) / this.h;
    }

    public double gradientDescent(double currentPosition, double waitingFactor) {
        // waiting factor should be between 0 and 1.

        return currentPosition - (waitingFactor * rawDerivativeCalculation(currentPosition));
    }

    public void addCacheValue(double valueIn) {
        cache.put(valueIn, this.function.fun(valueIn));
    }

    public void clearCache() {
        // use when resetting the derivative in case of bugs or new h values

        cache.clear();
    }
}
