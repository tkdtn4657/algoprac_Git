package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p1477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        list.add(0);
        list.add(l);

        Collections.sort(list);

        int left = 1;
        int right = l;
        int result = 0;

        while(left <= right){
            int mid = left + (right - left) / 2;

            int need = 0;
            for(int i = 0; i < list.size() - 1; i++){
                int dist = list.get(i + 1) - list.get(i);
                need += (dist - 1) / mid;
            }

            if(need <= m){
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }


        }

        System.out.println(result);

    }
}
