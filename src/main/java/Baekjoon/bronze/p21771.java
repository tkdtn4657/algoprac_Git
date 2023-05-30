package Baekjoon.bronze;

import java.util.*;
import java.io.*;

public class p21771{
    public static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        //int[][] map= new int[r][c];

        st = new StringTokenizer(br.readLine());
        int gr = Integer.parseInt(st.nextToken());
        int gc = Integer.parseInt(st.nextToken());

        int pr = Integer.parseInt(st.nextToken());
        int pc = Integer.parseInt(st.nextToken());

        char[][] map = new char[r][c];

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int n = pr * pc;

        int count = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(map[i][j] == 'P'){
                    count++;
                }
            }
        }
        if(count == n){
            System.out.println(0);
        }else{
            System.out.println(1);
        }
    }
}

//public class p21771{
//    public static void main() throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int r = Integer.parseInt(st.nextToken());
//        int c = Integer.parseInt(st.nextToken());
//
//        //int[][] map= new int[r][c];
//
//        st = new StringTokenizer(br.readLine());
//        int gr = Integer.parseInt(st.nextToken());
//        int gc = Integer.parseInt(st.nextToken());
//
//        int pr = Integer.parseInt(st.nextToken());
//        int pc = Integer.parseInt(st.nextToken());
//
//        char[][] map = new char[r][c];
//
//        for(int i = 0; i < r; i++){
//            map[i] = br.readLine().toCharArray();
//        }
//
//        for(int i = 0; i < r; i++){
//            String s = new String(map[i]);
//            if(s.contains("P")){
//                if(s.contains("G")){
//                    System.out.println(1);
//                    return;
//                }
//            }
//
//        }
//        System.out.println(0);
//
//    }
//
//}

//public class p21771 {
//    public static void main()throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int r = Integer.parseInt(st.nextToken());
//        int c = Integer.parseInt(st.nextToken());
//
//        //int[][] map= new int[r][c];
//
//        st = new StringTokenizer(br.readLine());
//        int gr = Integer.parseInt(st.nextToken());
//        int gc = Integer.parseInt(st.nextToken());
//
//        int pr = Integer.parseInt(st.nextToken());
//        int pc = Integer.parseInt(st.nextToken());
//
//        char[][] map = new char[r][c];
//        String s = new String();
//
//        for(int i = 0; i < r; i++){
//            map[i] = br.readLine().toCharArray();
//        }
//        int[] one = new int[2];
//        int[] two = new int[2];
//        int[] three = new int[2];
//        int[] four = new int[2];
//        for(int i = 0; i < r; i++){
//            for(int j = 0; j < c; j++){
//                while(map[i][j] == 'G'){
//                    if(onfillow(map, i, j, gr, gc)){
//                        System.out.println(1);
//                        return;
//                    }
//                    System.out.println(0);
//                    return;
//                }
//
//            }
//        }
//
//
//        for(int i = 0; i < r; i++){
//            for(int j = 0; j < c; j++){
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }
//
//        System.out.println();
//    }
//
//    static boolean onfillow(char[][] map, int i, int j, int gr, int gc){
//        if(j > 0){//g의 좌측상단 점에서 좌측체크 j가 0이 아니면 좌측 확인
//
//            if(map[i][j-1] == 'P') return true;
//            if(map[i + gr - 1][j-1] == 'P' ) return true;
//
//        }
//        if(map[0].length - 1 < j + gc - 1){
//            if(map[i][j+1] == 'P' ) return true;
//            if(map[i + gr - 1][j+1] == 'P' ) return true;
//        }
//        return false;
//    }
//
//}
