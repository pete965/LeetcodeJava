package RealInterviewQuestions.Meituan;

//幸运星
//        时间限制：C/C++语言 1000MS；其他语言 3000MS
//        内存限制：C/C++语言 65536KB；其他语言 589824KB
//        题目描述：
//        在观星的时候，一种常用的方式是划出类似于正方形的区域内，确定其中所有星星的坐标。
//
//        现在我们在星空（一个无限大的二维平面）上建立坐标系。由于星星很小，我们忽略它的面积，认为每一个星星是一个点，且所有星星的坐标都是整数。
//
//        幸运星的定义是这一颗星星在这个平面内，正上，正下，正左，正右都有其他的星星(不一定相邻)。
//
//        现在，我们已经将这个正方形的区域取出，并且将他们所在的坐标给你。现在希望你能计算，这个平面内有多少颗幸运星？
//
//        输入
//        输入第一行包含一个数n，代表正方形区域内星星的总数。
//
//        接下来n行，每行两个整数xi,yi,代表这颗星星的坐标。
//
//        (n<=2000,-1000<=xi,yi<=1000,没有两颗星星的坐标是相同的。)
//
//        输出
//        输出包含一个数，即有多少颗星星是幸运星。
//
//
//        样例输入
//        8
//        0 0
//        0 1
//        0 2
//        0 3
//        1 1
//        1 2
//        -1 1
//        -1 2
//        样例输出
//        2
//
//        提示
//        样例解释：
//        有两颗幸运星，分别是(0,1)(0,2)
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Meituan1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int output = 0;
        int number = scanner.nextInt();
        ArrayList<Point> arrayList = new ArrayList<>();
        for (int i=0;i<number;i++){
            int x=scanner.nextInt();
            int y=scanner.nextInt();
            arrayList.add(new Point(x,y));
        }
        for (Point point:arrayList){
            int x = point.getX();
            int y = point.getY();
            if (check(x,y,arrayList)){
                output++;
            }
        }
        System.out.println(output);
    }

    private static boolean check(int x, int y, ArrayList<Point> arrayList) {
        boolean left = false;
        boolean right = false;
        boolean up = false;
        boolean down = false;
        for (Point point:arrayList){
            if (point.getX()==x){
                if (point.getY()>y){
                    up = true;
                }else if (point.getY()<y){
                    down = true;
                }
            }
            if (point.getY()==y){
                if (point.getX()>x){
                    right = true;
                }else if (point.getX()<x){
                    left = true;
                }
            }
        }
        return up&&left&&right&&down;
    }

    static class Point{
        private int x;
        private int y;
        public Point(int a,int b){
            x=a;
            y=b;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
