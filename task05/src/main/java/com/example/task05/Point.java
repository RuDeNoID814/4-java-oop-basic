package com.example.task05;

public class Point {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //region GET, SET
    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    //endregion

    public double getLength(Point point) {
        double distX = point.x - getX();
        double distY = point.y - getY();
        return Math.sqrt((distX * distX) + (distY * distY));
    }

}
