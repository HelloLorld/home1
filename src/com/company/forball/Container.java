package com.company.forball;

public class Container {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Container(int x, int y, int width, int height) {
        x1 = x;
        y1 = y;
        x2 = x + width;
        y2 = y + height;
    }

    public boolean collides(Ball ball) {
        return true;
    }

    public int getX() {
        return x1;
    }

    public int getY() {
        return y1;
    }

    public int getWidth() {
        return x2 - x1;
    }

    public int getHeight() {
        return y2 - y1;
    }

    public boolean collidesH(Ball ball) {
        if ((ball.getY() + ball.getRadius() <= y2) && (ball.getY() - ball.getRadius() >= y1)) return true;
        else return false;
    }

    public boolean collidesW(Ball ball) {
        if ((ball.getX() + ball.getRadius() <= x2) && (ball.getX() - ball.getRadius() >= x1)) return true;
        else return false;
    }

    @Override
    public String toString() {
        return "Container{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Container container = (Container) o;

        if (x1 != container.x1) return false;
        if (y1 != container.y1) return false;
        if (x2 != container.x2) return false;
        return y2 == container.y2;
    }

    @Override
    public int hashCode() {
        int result = x1;
        result = 31 * result + y1;
        result = 31 * result + x2;
        result = 31 * result + y2;
        return result;
    }
}
