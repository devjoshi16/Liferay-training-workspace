package com.aixtor.commerce.highcharts.portlet;

import java.util.Scanner;

public class trail {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int A[]=new int[4];
        for (int i=0;i<4;i++)
                A[i]= scanner.nextInt();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max)
                max = A[i];
        }

        int B[] = new int[max + 1];
        for (int i = 0; i < A.length; i++) {

            // increment in array B for every integer
            // in A.
            B[A[i]]++;
        }
        for (int i = 0; i <= max; i++) {
            // output only if element is more than
            // 1 time in array A.
            if (B[i] > 1)
                System.out.println(i + "-" + B[i]);
        }
    }
}
