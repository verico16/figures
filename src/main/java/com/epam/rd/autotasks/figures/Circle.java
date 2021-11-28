package com.epam.rd.autotasks.figures;

import java.security.InvalidParameterException;

class Circle extends Figure {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) throws IllegalArgumentException {
        if (radius <= 0) throw new InvalidParameterException();
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public String pointsToString() {
        return center.toString();
    }

    @Override
    public Point leftmostPoint() {
        return new Point(center.getX() - radius, center.getY());
    }

    @Override
    public String toString() {
        return "Circle[" + center + radius +"]";
    }
}
