package HuaweiMachineExamPrepare.Easy.HJ101;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Integer[] nums = new Integer[count];
        for (int i=0;i<count;i++){
            nums[i] = scanner.nextInt();
        }
        int mode = scanner.nextInt();
        if (mode == 0 ){
            Arrays.sort(nums, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }

                @Override
                public boolean equals(Object obj) {
                    return false;
                }
            });
        } else {
            Arrays.sort(nums, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }

                @Override
                public boolean equals(Object obj) {
                    return false;
                }
            });
        }
        for (int i=0;i<nums.length;i++) {
            System.out.print(nums[i]);
            if (i!=nums.length-1){
                System.out.print(" ");
            }
        }
        System.out.print("\n");
    }
}
