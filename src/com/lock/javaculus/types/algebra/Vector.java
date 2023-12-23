package com.lock.javaculus.types.algebra;

public class Vector {
    private double[] vector;

    public Vector(int size) {
        this.vector = new double[size];

        for(int i = 0; i < size; i++) {
            this.vector[i] = 0d;
        }
    }

    public void add(Vector vector) throws Exception {
        if (vector.vector.length != this.vector.length) {
            throw new Exception("Can't add vectors of different length");
        }

        for (int i = 0; i < this.vector.length; i++) {
            this.vector[i] += vector.vector[i];
        }
    }

    public void scale(int scalar) {
        for (int i = 0; i < this.vector.length; i++) {
            this.vector[i] *= scalar;
        }
    }

    public double magnitude() {
        double sum = 0d;

        for (double d : this.vector) {
            sum += Math.pow(d, 2);
        }

        return Math.sqrt(sum);
    }

    public void normalize() {
        double m = magnitude();

        for (int i = 0; i < this.vector.length; i++) {
            vector[i] /= m;
        }
    }

    public double dot(Vector vector) throws Exception {
        if (vector.vector.length != this.vector.length) {
            throw new Exception("Can't find the dot product of differently sized vectors.");
        }

        double dotProduct = 0d;

        for (int i = 0; i < this.vector.length; i++) {
            dotProduct += vector.vector[i] * this.vector[i];
        }

        return dotProduct;
    }

    public void multiply(Vector vector) throws Exception {
        if (vector.vector.length != this.vector.length) {
            throw new Exception("Can't multiply two differently sized vectors.");
        }

        for (int i = 0; i < this.vector.length; i++) {
            this.vector[i] *= vector.vector[i];
        }
    }
}
