package com.luxoft.mysetimplementation.MySet;

import java.util.Arrays;
import java.util.stream.Stream;

public class MySetImpl<E> implements MySet<E> {
    private E[] array = null;

    @Override
    public boolean add(Object o) {
        boolean isElementAdded = false;
        boolean isAlreadyContainValue = false;

        if (array == null) {
            array = (E[]) new Object[]{o};
            isElementAdded = true;
        } else {
            isAlreadyContainValue = contains(o);
            if (!isAlreadyContainValue) {
                E[] newArray = (E[]) new Object[array.length + 1];
                System.arraycopy(array, 0, newArray, 0, array.length);
                newArray[array.length] = (E) o;
                array = newArray;
                isElementAdded = true;
            }
        }
        return isElementAdded;
    }

    @Override
    public boolean remove(Object o) {
        boolean isRemoved = false;
        boolean isContainElement = contains(o);
        if (isContainElement) {
            int removeIndex = findIndexByValue(o);
            E[] newArray = (E[]) new Object[array.length - 1];
            if (removeIndex == array.length - 1) {
                System.arraycopy(array, 0, newArray, 0, newArray.length);
            } else if (removeIndex == 0) {
                System.arraycopy(array, 1, newArray, 0, array.length - 1);
            } else {
                arrayCopy(array, 0, removeIndex, newArray, 0);
                arrayCopy(array, removeIndex + 1, array.length, newArray, removeIndex);
            }
            isRemoved = true;
            array = newArray;
        }
        return isRemoved;
    }

    @Override
    public boolean contains(Object o) {
        return Stream.of(array).anyMatch(e -> e.equals(o));
    }

    @Override
    public int size() {
        if (array == null) return 0;
        return array.length;
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[array.length];
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }

    public MySet<E> intersect(MySet<E> set1, MySet<E> set2) {
        MySet<E> longSet;
        Object[] shortSetValues;

        if (set1.size() <= set2.size()) {
            shortSetValues = set1.toArray();
            longSet = set2;
        } else {
            shortSetValues = set2.toArray();
            longSet = set1;
        }

        MySet<E> intersectValues = new MySetImpl<>();
        for (Object o : shortSetValues) {
            if (longSet.contains(o)) {
                intersectValues.add((E) o);
            }
        }
        return intersectValues;
    }

    private int findIndexByValue(Object o) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(o)) {
                index = i;
                break;
            }
        }
        return index;
    }

    private void arrayCopy(E[] src, int srcFrom, int srcTo, E[] dest, int destFrom) {
        for (int i = srcFrom; i < srcTo; i++) {
            dest[destFrom++] = src[i];
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
