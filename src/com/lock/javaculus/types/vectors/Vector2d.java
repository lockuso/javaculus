package com.lock.javaculus.types.vectors;

public class Vector2d extends Vectord{
    public Vector2d(double x, double y) {
        super(new double[] {x, y});
    }

    public Vector2d() {
        super(2);
    }

    public double getX() {
        return getValue(0);
    }

    public double getY() {
        return getValue(1);
    }

    public void setX(double x) {
        setValue(0, x);
    }

    public void setY(double y) {
        setValue(1, y);
    }
}
