package com.lock.javaculus.types;

import java.util.ArrayList;
import java.util.List;

public class ManyValues<T> {
    private final List<T> values;

    public ManyValues(List<T> values) { this.values = values; }
    public ManyValues() { this.values = new ArrayList<T>(); }

    public T getValue(int index) {
        return values.get(index);
    }

    public ManyValues<T> setValue(int index, T value) {
        values.set(index, value);

        return this;
    }

    public ManyValues<T> addValue(T value) {
        values.add(value);

        return this;
    }

    public T[] asArray() {
        return (T[]) this.values.toArray();
    }

    public int getLength() {
        return this.values.size();
    }
}
