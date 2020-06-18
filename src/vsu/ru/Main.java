package vsu.ru;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Point> pointList = new ArrayList();

        pointList.add(new Point(1, 4));
        pointList.add(new Point(1, 3));
        pointList.add(new Point(1, 4));
        pointList.add(new Point(3, 7));
        pointList.add(new Point(3, 4));
        pointList.add(new Point(6, 1));
        pointList.add(new Point(5, 3));
        pointList.add(new Point(3, 4));
        pointList.add(new Point(1, 4));
        pointList.add(new Point(5, 3));

        Sorting outSorting= new Sorting();
        outSorting.arraySorting(pointList);
        System.out.println(pointList);

    }



}
