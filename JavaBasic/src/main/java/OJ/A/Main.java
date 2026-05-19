package OJ.A;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        try {
            n = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input data error");
            return;
        }

        if (n < 1 || n > 50) {
            System.out.println("Input data error");
            return;
        }

        int[][] nums = new int[n][n];
        fillMatrix(n, nums);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(nums[i][j]);
                System.out.print(' ');
            }
            System.out.println(nums[i][n - 1]);
        }
    }

    public static void fillMatrix(int n, int[][] nums) {
        int top = 0;
        int bottom = n - 1;
        int right = n - 1;
        int left = 0;
        int num = 1;
        while (num <= n * n) {
            for (int i = top; i <= bottom && num <= n * n; i++) {
                nums[i][right] = num++;
            }
            right--;
            for (int i = right; i >= left && num <= n * n; i--) {
                nums[bottom][i] = num++;
            }
            bottom--;
            for (int i = bottom; i >= top && num <= n * n; i--) {
                nums[i][left] = num++;
            }
            left++;
            for (int i = left; i <= right && num <= n * n; i++) {
                nums[top][i] = num++;
            }
            top++;
        }
    }
}
