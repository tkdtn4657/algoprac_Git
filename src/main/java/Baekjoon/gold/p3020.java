package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p3020 {

    static int[] up;
    static int[] down;
    static int n;
    static int h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        up = new int[n/2];
        down = new int[n/2];
        boolean flagUpDown = false;
        for (int i = 0; i < n/2;) {
            if(!flagUpDown) {
                up[i] = Integer.parseInt(br.readLine());
            }else{
                down[i] = Integer.parseInt(br.readLine());
                i++;
            }
            flagUpDown = !flagUpDown;
        }
        Arrays.sort(up);
        Arrays.sort(down);

        int min = n;
        int count = 0;
        for(int height = 1; height <= h; height++){
            int countWall = binarySearch(0,n/2,height,down)+binarySearch(0,n/2,h-height+1, up);

            if(min==countWall){
                count++;
                continue;
            }
            if(min>countWall){
                min=countWall;
                count=1;
            }


        }

        System.out.printf("%d %d", min, count);

    }

    private static int binarySearch(int left, int right, int height,int[] a){
        while(left<right) {
            int mid = (left+right)/2;

            if(a[mid] >= height) {
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return a.length-right;
    }
}
