package com.lock.javaculus.types.vectors;

public class Vectorf {
    private float[] values;

    public Vectorf(float[] values) {
        this.values = values;
    }

    public Vectorf(int size) {
        this.values = new float[size];
    }

    public float getValue(int index) {
        return values[index];
    }

    public void setValue(int index, float value) {
        values[index] = value;
    }

    public int getVectorLength() {
        return values.length;
    }

    public void add(Vectorf vector) throws Exception {
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

    public void sub(Vectorf vector) throws Exception {
        vector.negate();

        this.add(vector);
    }

    public void mulf(float scalar) {
        for (int i = 0; i < this.getVectorLength(); i++) {
            this.values[i] *= scalar;
        }
    }
}
