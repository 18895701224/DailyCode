package com.szxy.code;

/**
 * @author YKC
 * @create 2019-12-16 20:51
 */
public class PathMethod {
    // 从(0,0)走到(m-1,n-1)有多少种走法，只能向右或者向下走

    public static void main(String[] args) {
        int i = PathMethod.pathMethod(8, 8);
        System.out.println(i);
    }

    public static int pathMethod(int m, int n) {
        int[][] pm = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || i == 0) {
                    pm[i][j] = 1;
                } else {
                    pm[i][j] = 0;
                    if (i - 1 >= 0) {
                        pm[i][j] += pm[i - 1][j];
                    }
                    if (j - 1 >= 0) {
                        pm[i][j] += pm[i][j - 1];
                    }
                }
            }

        }
        return pm[m - 1][n - 1];
    }
}
