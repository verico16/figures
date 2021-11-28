package com.epam.rd.autotasks.figures;

class Triangle extends Figure {
    private Point a, b, c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        return Math.abs( (b.getX() - a.getX()) * (c.getY() - a.getY()) - (c.getX() - a.getX()) * (b.getY() - a.getY()) ) / 2.0;
    }

    @Override
    public String pointsToString() {
        return a.toString() + b.toString() + c.toString();
    }

    @Override
    public Point leftmostPoint() {
        Point left = a;
        if (b.getX() < left.getX()) {
            left = b;
        }
        if (c.getX() < left.getX()) {
            left = c;
        }
        return left;
    }
}
