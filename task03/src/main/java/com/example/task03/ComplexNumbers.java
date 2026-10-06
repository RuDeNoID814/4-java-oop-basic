package com.example.task03;

public class ComplexNumbers {
    private double real; // действительаня часть
    private double imag; // мнимая часть


    /**
     * ComplexNumbers Конструктор
     * @param real действительная
     * @param imag мнимая
     */
    public ComplexNumbers (double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    /**
     *
     * @param comnum для суммы и произведения
     * @return
     */
    public ComplexNumbers add (ComplexNumbers comnum) {
        return new ComplexNumbers(this.real + comnum.real, this.imag + comnum.imag);
    }

    public ComplexNumbers multiplication (ComplexNumbers comnum) {
        double r = (this.real * comnum.real) - (this.imag * comnum.imag);
        double i = (this.real * comnum.imag) + (this.imag * comnum.real);
        return new ComplexNumbers(r, i);
    }

    @Override
    public String toString() {
        return this.real + " + " + this.imag + "i";
    }
}
