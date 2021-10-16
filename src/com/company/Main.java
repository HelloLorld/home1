package com.company;

import com.company.books.Author;
import com.company.books.Book;
import com.company.figures.Circle;
import com.company.figures.MyPoint;
import com.company.figures.MyTriangle;
import com.company.figures.Rectangle;
import com.company.other.Employee;

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
            e.printStackTrace();
        }
        MyTriangle triangle1 = new MyTriangle(1,1,2,3,3,1);
        System.out.println(triangle1 + "\nPerimeter: " + triangle1.getPerimeter() + "; Type: " + triangle1.getType());
        //Создать треугольник равносторонний не выходит, не могу координаты подобрать
    }
}
