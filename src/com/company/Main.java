package com.company;

import com.company.forball.Ball;
import com.company.forball.Container;
import com.company.forbooks.Author;
import com.company.forbooks.Book;
import com.company.figures.Circle;
import com.company.figures.MyPoint;
import com.company.figures.MyTriangle;
import com.company.figures.Rectangle;
import com.company.other.Employee;
import com.company.other.MyComplex;
import com.company.other.MyPolynomial;

public class Main {

    public static void main(String[] args) {
        //###########Cirlce#################
        Circle circle = new Circle();
        circle.setColor("green");
        circle.setRadius(7);
        Circle circle1 = new Circle(10);
        circle1.setColor("red");
        Circle circle2 = new Circle(3, "yellow");
        System.out.println(circle + "\n" + circle.getArea());
        System.out.println(circle1 + "\n" + circle1.getArea());
        System.out.println(circle2 + "\n" + circle2.getArea());
        System.out.println();

        //###########Rectangle##############
        Rectangle rectangle = new Rectangle();
        rectangle.setLength(2);
        rectangle.setWidth(5);
        Rectangle rectangle1 = new Rectangle(3, 7);
        System.out.println(rectangle + "\n" + "Area: " + rectangle.getArea() + "; Perimeter: " + rectangle.getPerimeter());
        System.out.println(rectangle1 + "\n" + "Area: " + rectangle1.getArea() + "; Perimeter: " + rectangle1.getPerimeter());
        System.out.println();

        //###########Employee###############
        Employee employee = new Employee(5, "Василий", "Иванов", 3456);
        System.out.println(employee + "\nAnnual salary: " + employee.getAnnualSalary() +
                "; Raise salary: " + employee.raiseSalary(15));
        employee.setSalary(12000);
        System.out.println("Employee after set salary");
        System.out.println(employee + "\nAnnual salary: " + employee.getAnnualSalary() +
                "; Raise salary: " + employee.raiseSalary(5));
        System.out.println();

        //###########Books###################
        Author[] authors = {new Author("Василий Петров", "dsg@mail.ru", 'm'),
                new Author("Екатерина Иванова", "ivanova@gmai.com", 'f'),
                new Author("Шамиль Василевский", "shamil212@mail.ru", 'm')};
        Book book = new Book("Книга", authors, 450);
        System.out.println(book);
        System.out.println(book.getAuthorNames());
        System.out.println();

        //###########MyPoint#################
        MyPoint point = new MyPoint(4, 3);
        System.out.println("Point: " + point + " distance to 0,0: " + point.distance());
        System.out.println();

        //###########MyTriangle##############
        MyTriangle triangle = new MyTriangle(new MyPoint(1, 3), new MyPoint(2, 5), new MyPoint(4, 5));
        System.out.println(triangle + "\nPerimeter: " + triangle.getPerimeter() + "; Type: " + triangle.getType());
        try {
            MyTriangle triangle1 = new MyTriangle(1, 1, 1, 2, 1, 3);
        } catch (IllegalArgumentException e) {
            System.out.println("Не удалось создать треугольник");
            //e.printStackTrace();
        }
        MyTriangle triangle1 = new MyTriangle(1, 1, 2, 3, 3, 1);
        System.out.println(triangle1 + "\nPerimeter: " + triangle1.getPerimeter() + "; Type: " + triangle1.getType());
        System.out.println();
        //Создать треугольник равносторонний не выходит, не могу координаты подобрать

        //############MyComplex###############
        MyComplex complex = new MyComplex(1, 3);
        System.out.println("Умножение: " + complex.multiply(new MyComplex(4, -2)));
        MyComplex complex1 = new MyComplex(8, 3);
        System.out.println("Сложение: " + complex1.addNew(new MyComplex(5, -1)));
        MyComplex complex2 = new MyComplex(12, -7);
        System.out.println("Вычитание: " + complex2.subtract(new MyComplex(-8, 4)));
        System.out.println("Аргумент: " + new MyComplex(1, Math.sqrt(3)).argument());

        //############MyPolynomial############
        MyPolynomial polynomial = new MyPolynomial(-1, 1, 3, 4);
        System.out.println(polynomial);
        System.out.println("Умножение: "+polynomial.multiply(new MyPolynomial(8,7,6,5,4,1)));
        System.out.println(polynomial.evaluate(1));
        MyPolynomial polynomial1 = new MyPolynomial(1, -1, 3, 4, 9);
        System.out.println("Сложение: "+polynomial.add(polynomial1));

        //############Ball####################
        Container container = new Container(0, 0, 300, 400);
        Ball ball = new Ball(10, 15, 15, 5, 30);
        for (int i = 0; i < 1000; i++) {
            if(!container.collidesH(ball)) ball.reflectVertical();
            if(!container.collidesW(ball)) ball.refletHorizontal();
            ball.move();
        }
        //Не уверен в правильности проверки
    }
}
