package Baekjoon.Compatition;

import java.io.*;
import java.util.*;

public class p1093_3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
//        int[] weight = new int[1000000];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < m; i++){
            StringTokenizer st =new StringTokenizer(br.readLine());

            int mode = Integer.parseInt(st.nextToken());
            if(mode == 1){
                int index = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                map.put(weight, index);
//                a[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken()));
            }else{//2 mode
                int weight = Integer.parseInt(st.nextToken());
                sb.append(map.get(weight)).append("\n");
            }
        }
        System.out.println(sb);

    }
}
