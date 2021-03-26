package com.company;

public class Main {

    public static long factorial(int number) {
        if (number == 1) {
            return 1;
        } else {
            return (factorial(number - 1) * number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.nanoTime();
        Runnable task = () -> {
            System.out.println(factorial(10));
        };
        Thread[] arr = new Thread[50];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Thread(task);
            arr[i].start();
            Thread.sleep(100);
        }
        long stop = System.nanoTime();
        System.out.println("Время выполнения работы программы: " + (stop - start) / 1_000_000_000);
    }
}