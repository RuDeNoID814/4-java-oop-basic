package com.example.task03;

public class ComplexNumbers {
    private double real;
    private double imag;

    public ComplexNumbers (double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public ComplexNumbers add(ComplexNumbers comNum) {
        return new ComplexNumbers(this.real + comNum.real, this.imag + comNum.imag);
    }

    public ComplexNumbers multiplication(ComplexNumbers comNum) {
        double r = (this.real * comNum.real) - (this.imag * comNum.imag);
        double i = (this.real * comNum.imag) + (this.imag * comNum.real);
        return new ComplexNumbers(r, i);
    }
}
