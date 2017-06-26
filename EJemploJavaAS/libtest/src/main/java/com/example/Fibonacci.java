package com.example;

/**
 * Created by jorgecasariego on 24/6/17.
 *
 *  0 1 1 2 3 5 8 13 21 34
 */

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("Fibonacci");

        int resultado = fibonacci(1);
        System.out.println("Resultado: " + resultado);

        resultado = fibonacciLoop(1);
        System.out.println("Resultado con for es: " + resultado);
    }

    private static int fibonacciLoop(int n) {
        int n1 = 0;
        int n2 = 1;
        int n3 = 0;

        if(n == 0)
            return 0;

        for (int j = 1; j <= n; j++) {
            n3 = n1 + n2;

            System.out.println(" " + n3);

            n1 = n2;
            n2 = n3;
        }

        return n3;
    }

    /*
         n = 5
            |(n = 4) + (n = 3)|
                |(n = 3) + (n = 2)| + |(n = 2) + (n = 1)|
                    |(n = 2) + (n = 1)| + |(n = 1) + (n = 0)| + |(n = 1) + (n = 0) + (1)|
                        |(n = 1) + (n = 0)| + |(1)| + |(1) + (0)| + (1) + (0) + (1)         = 4
                            (1) + (0)                                                       = 1
                                                                                 Resultado  = 5
     */
    private static int fibonacci(int n) {
        if(n > 1){
            return fibonacci(n-1) + fibonacci(n-2);
        } else if(n == 1){
            return 1;
        } else if(n == 0){
            return 0;
        } else {
            System.out.println("Error");
            return -1;
        }
    }


}
