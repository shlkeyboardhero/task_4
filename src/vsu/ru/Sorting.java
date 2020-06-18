package vsu.ru;

import java.util.ArrayList;

public class Sorting {
    private void treeSorting(ArrayList<Point> pointList, int unsortedSizePointList) {
        int lvlCounter = unsortedSizePointList;
        while (lvlCounter / 2 > 0) {
            int sizeFatherElement = lvlCounter / 2 - lvlCounter / 4;

            for (int rootIndex = lvlCounter / 2 - 1; rootIndex >= (lvlCounter / 2 - sizeFatherElement); rootIndex--)
                findBiggest(pointList, rootIndex, unsortedSizePointList);

            lvlCounter = lvlCounter / 2;
        }
    }

    private int swapFirstLast(ArrayList<Point> pointList, int unsortedSizePointList) {
        swap(pointList, 0, unsortedSizePointList - 1);
        return --unsortedSizePointList;
    }

    private void findBiggest(ArrayList<Point> pointList, int rootIndex, int unsortedSizePointList) {
        int child1 = rootIndex * 2 + 1;
        int child2 = rootIndex * 2 + 2;
        if (child2 < unsortedSizePointList) {
            if (pointList.get(child1).gip >= pointList.get(child2).gip && pointList.get(child1).gip > pointList.get(rootIndex).gip) {
                swap(pointList, rootIndex, child1);
                if (child1 * 2 + 1 < unsortedSizePointList) {
                    findBiggest(pointList, child1, unsortedSizePointList);
                }
            } else {
                if (pointList.get(child2).gip > pointList.get(child1).gip && pointList.get(child2).gip > pointList.get(rootIndex).gip) {
                    swap(pointList, rootIndex, child2);
                    if (child2 * 2 + 1 < unsortedSizePointList) {
                        findBiggest(pointList, child2, unsortedSizePointList);
                    }
                }
            }
        } else {
            if (pointList.get(child1).gip > pointList.get(rootIndex).gip) {
                swap(pointList, rootIndex, child1);
                if (child1 * 2 + 1 < unsortedSizePointList) {
                    findBiggest(pointList, child1, unsortedSizePointList);
                }
            }
        }
    }

    private void swap(ArrayList<Point> pointList, int index1, int index2) {
        Point rememberedPoint = pointList.get(index1);
        pointList.set(index1, pointList.get(index2));
        pointList.set(index2, rememberedPoint);
    }

    public void sort(ArrayList<Point> pointList) {
        int unsortedSizePointList = pointList.size();
        //System.out.println(pointList);
        while (unsortedSizePointList > 1) {
            treeSorting(pointList, unsortedSizePointList);
            //System.out.println(pointList + " После сортировки ");
            unsortedSizePointList = swapFirstLast(pointList, unsortedSizePointList);
            //System.out.println(pointList + " После обмена " + unsortedSizePointList);

        }
    }

    public void arraySorting(ArrayList<Point> pointList) {
        pointList.sort(Point::compareTo);
    }
}
