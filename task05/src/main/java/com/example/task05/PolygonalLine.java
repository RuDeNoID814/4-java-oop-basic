package com.example.task05;

import java.util.Arrays;

public class PolygonalLine {

    private Point[] points;

    public void setPoints(Point[] points) {
        Point[] newPoints = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            newPoints[i] = new Point(points[i].getX(), points[i].getY());
        }

        this.points = newPoints;
    }

    public void addPoint(Point point) {
        if (this.points == null) {
            this.points = new Point[]{new Point(point.getX(), point.getY())};
            return;
        }
        this.points = Arrays.copyOf(this.points, this.points.length + 1);
        this.points[this.points.length - 1] = new Point(point.getX(), point.getY());
    }

    public void addPoint(double x, double y) {
        Point point = new Point(x, y);
        addPoint(point);
    }

    public double getLength() {
        double totalLength = 0;

        for (int i = 0; i < this.points.length - 1; i++) {
            totalLength += this.points[i].getLength(this.points[i + 1]);
        }
        return totalLength;
    }

}
