package org.joven.common.interviewprogram;

import java.util.Scanner;

/**
 * 你也许见过各种各样的三角形数阵。下面给出一种三角形数阵(你可能没见过),这种数阵是由一个有序三元组(S,T,N)决定的,
 * 其中S,T,N是三个正整数,观察下面几个样例: 三元组(S,T,N) (1 , 4 , 6) ( 3 , 5 , 8 ) ( 4 , 7 , 9 )
 * 三角形数阵 对于给定一个具体的三元组(S,T,N),能唯一确定一个相对应的三角形数阵,
 * 请自己寻找三元组与数阵的对应关系(提示:数阵的第一个数;按列读读看.....)。
 * 你的任务是:根据给定的三元组(S,T,N),输出相对应的三角形数阵。 【输入】 一行,三个正整数S,T,N,两个数字中
 */
public class Triangular {
    public static void printRes() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] nums = input.trim().split(" ");
        if (nums.length != 3) {
            System.out.println("input is wrong");
            System.exit(0);
        }
        try {
            int beginNum = Integer.parseInt(nums[0]);
            int maxNum = Integer.parseInt(nums[1]);
            int listSize = Integer.parseInt(nums[2]);
            int[][] res = new int[listSize][listSize];
            // 按照需要将二维数组填满 再按顺序输出
            for (int i = 0; i < listSize; i++) {
                for (int j = 0; j < listSize - i; j++) {
                    res[j][i] = beginNum;
                    beginNum++;
                    if (beginNum > maxNum) {
                        beginNum = 1;
                    }
                }
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length - i; j++) {
                    System.out.print(res[i][j] + "  ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}
