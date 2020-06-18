package vsu.ru;

public class Point implements Comparable <Point> {
    int x;
    int y;
    int gip;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
        this.gip=gipot(x,y);
    }
    private Integer gipot(int x, int y) {
        return x * x + y * y;
    }

    public String toString(){
        return "[ X: " + x + " Y: " + y + " Гипотинуза: " + gip + "]";
    }


    @Override
    public int compareTo(Point o) {
        return gip-o.gip ;
    }
}
