package com.luxoft.mysetimplementation.MySet;

public interface MySet<E> {

    boolean add(E e);
    boolean remove(Object o);
    boolean contains(Object o);
    int size();
    Object[] toArray();
    MySet<E> intersect(MySet<E> set1, MySet<E> set2);
}
