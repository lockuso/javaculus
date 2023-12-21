package com.lock.javaculus.types.vectors;

public class Vector2i extends Vectori{
    public Vector2i(int x, int y) {
        super(new int[] {x, y});
    }

    public Vector2i() {
        super(2);
    }

    public int getX() {
        return getValue(0);
    }

    public int getY() {
        return getValue(1);
    }

    public void setX(int x) {
        setValue(0, x);
    }

    public void setY(int y) {
        setValue(1, y);
    }
}
