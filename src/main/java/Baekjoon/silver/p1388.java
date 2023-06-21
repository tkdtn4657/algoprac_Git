package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1388 {

    static boolean[][] checkIndex;
    static int count = 0;
    static int n;
    static int m;
    static char[][] cArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        checkIndex = new boolean[n][m];
        cArray = new char[n][m];

       // String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            cArray[i] = br.readLine().toCharArray();
        }

//        gyang(0, 0, cArray[0][0]);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!checkIndex[i][j]) {
                    if (cArray[i][j] == '-') {
                        checkIndex[i][j] = true;
                        depthCheck("rows", i, j+1);
                        count++;
                    }
                    if (cArray[i][j] == '|') {//그냥 가독성을 위해 이것도 추가
                        checkIndex[i][j] = true;
                        depthCheck("cols", i+1, j);
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }

    static void depthCheck(String s, int i, int j) {
        if (s.equals("rows") && i < n && j < m && !checkIndex[i][j] && cArray[i][j] == '-') {
            checkIndex[i][j] = true;
            depthCheck("rows", i, j+1);
        }
        else if (s.equals("cols") && i < n && j < m && !checkIndex[i][j] && cArray[i][j] == '|') {
            checkIndex[i][j] = true;
            depthCheck("cols", i+1, j);
        }
    }
}
