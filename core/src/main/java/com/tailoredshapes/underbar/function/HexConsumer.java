package com.tailoredshapes.underbar.function;

@FunctionalInterface
public interface HexConsumer<T, U, V, X, Y, Z> {
    void accept(T t, U u, V v, X x, Y y, Z z);
}
