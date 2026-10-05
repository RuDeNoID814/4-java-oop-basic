package com.example.task01;

/**
 * Класс точки на плоскости
 */
public class Point {
    int x;
    int y;
    /**
    *   Класс конструктор
    */
    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * "Вращает" точку относительно начала координат на 180 градусов
     */
    public void flip() {
        int temp = y;
        y = -x;
        x = -temp;
    }

    /**
     * Считает расстояние от текущей точки до переданной
     * @param point вторая точка
     * @return расстояние между точками
     */
    public double distance(Point point) {
        return Math.hypot(point.x - x, point.y - y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
