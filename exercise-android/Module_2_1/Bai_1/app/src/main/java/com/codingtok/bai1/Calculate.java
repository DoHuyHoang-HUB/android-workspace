package com.codingtok.bai1;

public class Calculate {

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int diff(int a, int b) {
        return a - b;
    }

    public static int prod(int a, int b) {
        return a * b;
    }

    public static float fac(int a, int b) {
        return a * 1f / b;
    }

    public static int ucln(int a, int b) {
        while (a != b) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return b;
    }
}
