package Deep_Thought_Into_Java;

import java.util.Scanner;

public class PolySolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        int[] a = new int[20];

        int bo = 0;
        for (int i = 2; i <= 16; i++)
            if (judge(num, i) > 0) {
                a[i] = 1;
                bo = 1;
            }
        if (bo > 0) {
            for (int i = 2; i <= 16; i++)
                if (a[i] > 0)
                    System.out.println(i);
        } else
            System.out.println(-1);
    }

    private static int judge(int n, int i) {
        int[] b = new int[50];
        int num = 0;
        while (n > 0) {
            b[num] = n % i;
            num++;
            n /= i;
        }
        int bo = 1;
        for (int j = 0; j < num / 2; j++)
            if (b[j] != b[num - 1 - j]) {
                bo = 0;
                break;
            }
        return bo;
    }
}
