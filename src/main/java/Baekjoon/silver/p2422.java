package Baekjoon.silver;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p2422 {

    static ArrayList[] al;

    public static void main() throws IOException {
        //5 3
        //1 2
        //3 4
        //1 3
        //배열만들어서 카운트해도될듯?
        //1 2 3 4 5
        //2 1 1 3
        //3   4

        //1 2 3 4 5
        //
        //
        //contains
        //12 34 13
        //
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        al = new ArrayList[m];
        String[] noIce = new String[m];
        //0 1 2 3 4 5 index
        //0 1 1 0 0 0
        //0 0 0 1 1 0
        //0 1 0 1 0 0 // 기각

        //0 1 2 3 4 5 index
        //1 2
        //3 4
        //1 3
        int one = 0;
        int two = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            al[i] = new ArrayList();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            one = Integer.parseInt(st.nextToken());
            two = Integer.parseInt(st.nextToken());
            al[one].add(two);
            al[two].add(one);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int g = 0; g < n; g++){
                    int length = al[i].size();
                    for (int z = i; i < length; i++) {
                        
                    }

                }
            }
        }

//        for(int i = 0; i < 3; i++){//양방향트리
//            //1, 2
//            a[1].add(2);
//            a[2].add(1);
//        }
    }

}
