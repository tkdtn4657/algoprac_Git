package Baekjoon.silver;

import java.util.*;
import java.io.*;

public class p1269 {
    public static void main() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> a = new HashMap<Integer,Integer>();
        HashMap<Integer, Integer> b = new HashMap<Integer, Integer>();


        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a.put(Integer.parseInt(st.nextToken()), 1);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            b.put(Integer.parseInt(st.nextToken()), 1);
        }
        //와 이거 당연한건데... 주소를 주고받으니까 그냥참조인거임....
        HashMap <Integer, Integer> atemp = (HashMap<Integer, Integer>) a.clone();
        //HashMap <Integer, Integer> btemp = (HashMap<Integer, Integer>) b.clone();

        for(int key : b.keySet()){
            a.remove(key);
        }
        for(int key : atemp.keySet()){//배열로 들어옴
            b.remove(key);
        }
        System.out.println(a.size()+b.size());
    }
}
