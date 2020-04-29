package RealInterviewQuestions.Meituan;

import java.util.Scanner;

//班级里每位同学都有学号，以1、2、3、4、5、6、7、8、9排列，按照以下方式进行分组，每组最多两名同学。
//        [1、2、3、4、5、6、7、8、9]
//        [1、3、5、7、9],[2、4、6、8]
//        [1、5、9],[3、7],[2、6],[4、8]
//        [1、9],[5],[3、7],[2、6],[4、8]
//
//        给出一个同学的学号，如果其所在分组有两位同学，则返回另一位的学号；如果只有一人，返回其自身学号即可。如：
//
//        输入1，返回9；
//        输入5，返回5；
//        输入2，返回6；
public class NumbersSplit {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Scanner in = new Scanner(System.in);
        int index = in.nextInt();
        int left = index - 1;
        int right = 9 - index;
        int leftNumber = 0;
        int rightNumber = 0;
        while (left + right >= 2) {
            if (left % 2 == 0) {
                if (right % 2 == 0) {
                    left /= 2;
                    right /= 2;
                } else {
                    left /= 2;
                    right = (right - 1) / 2;
                }
            } else {
                if (right % 2 == 0) {
                    left = (left - 1) / 2;
                    right /= 2;
                } else {
                    left = (left - 1) / 2;
                    right = (right - 1) / 2;
                }
            }
        }
        if (left+right==0){
            System.out.println(index);
        }else if (left==0){

        }else {

        }
    }
}
