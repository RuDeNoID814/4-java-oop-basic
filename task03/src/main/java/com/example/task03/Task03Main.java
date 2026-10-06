package com.example.task03;

public class Task03Main {
    public static void main(String[] args) {
        ComplexNumbers a = new ComplexNumbers(3, 4);
        ComplexNumbers b = new ComplexNumbers(1, 2);

        ComplexNumbers sum = a.add(b);
        ComplexNumbers product = a.multiplication(b);

        System.out.println("Сумма: " + sum);
        System.out.println("Произведение: " + product);
    }
}
