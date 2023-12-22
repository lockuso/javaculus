package com.lock.javaculus.types.vectors;

public class Vectori {
    private int[] values;

    public Vectori(int[] values) {
        this.values = values;
    }

    public Vectori(int size) {
        this.values = new int[size];
    }

    public int getValue(int index) {
        return values[index];
    }

    public void setValue(int index, int value) {
        values[index] = value;
    }

    public int getVectorLength() {
        return values.length;
    }

    public void add(Vectori vector) throws Exception {
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

    public void sub(Vectori vector) throws Exception {
        vector.negate();

        this.add(vector);
    }

    public void muli(int scalar) {
        for (int i = 0; i < this.getVectorLength(); i++) {
            this.values[i] *= scalar;
        }
    }

    public int dot(Vectori other) throws Exception {
        if (other.getVectorLength() != getVectorLength()) {
            throw new Exception("Vectors need to be the same length");
        }

        int product = 0;

        for (int i = 0; i < getVectorLength(); i++) {
            product += other.getValue(i) * getValue(i);
        }

        return product;
    }
}
