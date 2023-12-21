package com.lock.javaculus.types.vectors;

public class Vectord {
    private double[] values;

    public Vectord(double[] values) {
        this.values = values;
    }

    public Vectord(int size) {
        this.values = new double[size];
    }

    public double getValue(int index) {
        return values[index];
    }

    public void setValue(int index, double value) {
        values[index] = value;
    }

    public int getVectorLength() {
        return values.length;
    }

    public void add(Vectord vector) throws Exception {
        if (vector.getVectorLength() != this.values.length) {
            throw new Exception("Different sized vectors can't be added together");
        }

        for (int i = 0; i < this.getVectorLength(); i++) {
            this.values[i] += vector.getValue(i);
        }
    }

    public void negate() {
        for (int i = 0; i < this.getVectorLength(); i++) {
            this.values[i] = -this.values[i];
        }
    }

    public void sub(Vectord vector) throws Exception {
        vector.negate();

        this.add(vector);
    }

    public void muld(double scalar) {
        for (int i = 0; i < this.getVectorLength(); i++) {
            this.values[i] *= scalar;
        }
    }
}
