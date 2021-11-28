package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {
    private Point a, b, c, d;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        // need to check if all points are different or not null

        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double area() {
        if (isIntersect(a, b, c, d)) {
            return new Triangle(a, c, d).area() + new Triangle(c, d, b).area();
        }
        if (isIntersect(a, c, b, d)) {
            return new Triangle(a, b, d).area() + new Triangle(b, d, c).area();
        }
        return new Triangle(a, b, c).area() + new Triangle(b, c, d).area();
    }

    @Override
    public String pointsToString() {
        return a.toString() + b.toString() + c.toString() + d.toString();
    }

    @Override
    public Point leftmostPoint() {
        Point left = a;
        if (b.getX() < left.getX())
            left = b;
        if (c.getX() < left.getX())
            left = c;
        if (d.getX() < left.getX())
            left = d;
        return left;
    }

    // check for intersection between two lines
    static private boolean isIntersect(Point first_start, Point firs_end, Point second_start, Point second_end) {
        double x1 = first_start.getX(),  y1 = first_start.getY();
        double x2 = firs_end.getX(),     y2 = firs_end.getY();
        double x3 = second_start.getX(), y3 = second_start.getY();
        double x4 = second_end.getX(),   y4 = second_end.getY();

        double p = x1*y2 - y1*x2; // p and q are created to reduce repeated math expression
        double q = x3*y4 - y3*x4;

        double D = (x1-x2) * (y3-y4) - (y1-y2) * (x3-x4);
        double x = (p * (x3-x4) - (x1-x2) * q) / D;
        double y = (p * (y3-y4) - (y1-y2) * q) / D;

        return x <= Math.max(x1, x2) && x >= Math.min(x1, x2)
                && y <= Math.max(y1, y2) && y >= Math.min(y1, y2)
                && x <= Math.max(x3, x4) && x >= Math.min(x3, x4)
                && y <= Math.max(y3, y4) && y >= Math.min(y3, y4);
    }
}

