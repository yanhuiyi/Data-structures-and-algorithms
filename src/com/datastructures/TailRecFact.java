package com.datastructures;

import java.util.ArrayList;

public class TailRecFact {

    static int A() {
        int a = 10;
       return a;
    }

    static int B() {
        int b = 20;
        return A();
    }

    static int C() {
        int c = 30;
        return B();
    }

    static int A1() {
        int a = 10;
        return a;
    }

    static int B1() {
        int b = 20;
        return A1() + b;
    }

    static int C1() {
        int c = 30;
        return B1() + c;
    }


    static int fact(int N) {
        if(N == 1) return 1;
        return N * fact(N - 1);
    }

    static int tailRecFact(int N, int result) {
        if(N == 1) {
            return result;
        }
        return tailRecFact(N - 1, N * result);
    }

    static int tailfact(int N) {
        return tailRecFact(N, 1);
    }

    public static void main(String[] args) {
//        int result = tailfact(50000);
        int result2 = fact(50000);
//        System.out.printf("result = %s \n", result);
        System.out.printf("result = %s \n", result2);
//        System.out.printf("C() %s ", C());
//        C();
//        C1();

        int[] array = new int[10];
        ArrayList<Integer> array1 = new ArrayList<Integer>();
    }
}
