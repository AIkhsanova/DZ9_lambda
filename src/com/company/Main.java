package com.company;

import java.util.Scanner;

public class Main {


    public static void main(final String... args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        int size = 10;
        int[] arr1 = getFilledArray(size, input, Integer::sum);
        printArr(arr1);

        int[] arr2 = getFilledArray(size, input, (ind, inp) -> ind * inp);
        printArr(arr2);

        int[] arr3 = getFilledArray(size, input, (ind, inp) -> {
            if (ind % 2 == 0) {
                return ind / 2 + inp;
            } else {
                return ind * ind - inp;
            }
        });
        printArr(arr3);


        // Если модификатор больше либо равен 100 - берем целую часть от деления на 100 и прибавляем индекс
        //Иначе - берем остаток от деления на 100 и прибавляем индекс
        int[] arr4 = getFilledArray(size, input, (ind, inp) -> {
            if (inp >= 100) {
                return inp / 100 + ind;
            } else {
                return inp % 100 + ind;
            }
        });
        printArr(arr4);

        //возвращает квадрат разности межжу модификатором и индексом
        int[] arr5 = getFilledArray(size, input, (ind, inp) -> (ind - inp) * (ind - inp));
        printArr(arr5);

        scanner.close();
    }


    public static int[] getFilledArray(final int size, final int input, final Process p) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = p.process(i, input);
        }

        return arr;
    }

    public static void printArr(final int[] arr) {

        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }

}


