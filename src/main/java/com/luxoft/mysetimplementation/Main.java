package com.luxoft.mysetimplementation;

import com.luxoft.mysetimplementation.MySet.MySet;
import com.luxoft.mysetimplementation.MySet.MySetImpl;

public class Main {

    public static void main(String[] args) {
        MySet<Integer> mySet = new MySetImpl<>();
        System.out.println("Try add 0. Result = " + mySet.add(0) + " " + mySet);
        System.out.println("Try add 1. Result = " + mySet.add(1) + " " + mySet);
        System.out.println("Try add 2. Result = " + mySet.add(2) + " " + mySet);
        System.out.println("Try add 3. Result = " + mySet.add(3) + " " + mySet);
        System.out.println("Try add 4. Result = " + mySet.add(4) + " " + mySet);
        printDelimiter();

        System.out.println("Try add again 0. Result = " + mySet.add(0) + " " + mySet);
        System.out.println("Try add again 1. Result = " + mySet.add(1) + " " + mySet);
        printDelimiter();

        System.out.println("Try to remove 999. Result = " + mySet.remove(999) + " " + mySet);
        System.out.println("Try to remove 0. Result = " + mySet.remove(0) + " " + mySet);
        System.out.println("Try to remove 2. Result = " + mySet.remove(2) + " " + mySet);
        System.out.println("Try to remove 4. Result = " + mySet.remove(4) + " " + mySet);
        printDelimiter();

        MySet<Integer> mySet2 = new MySetImpl<>();
        for (int i = 0; i < 20; i++) {
            mySet2.add(i);
        }
        mySet2.add(100);
        mySet.add(100);
        System.out.println("First set  : " + mySet);
        System.out.println("Second set : " + mySet2);
        System.out.println("Intersecting values : " + mySet.intersect(mySet, mySet2));
    }

    private static void printDelimiter() {
        System.out.println("---------------------------------------------------");
    }
}
