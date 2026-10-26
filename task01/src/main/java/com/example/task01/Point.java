package com.example.task01;
public class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void flip() {
        int temp;

        temp = -y;
        y = -x;
        x = temp;
    }

    public double distance(Point point) {
        double deltaX = (double)point.x - this.x;
        double deltaY = (double)point.y - this.y;

        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
