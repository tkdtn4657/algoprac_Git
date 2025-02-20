package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p2961_2 {

    static int min = Integer.MAX_VALUE;
    static int n;
    static ArrayList<Ingredient> al = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int acidity = Integer.parseInt(st.nextToken()); // 신맛
            int acerbity = Integer.parseInt(st.nextToken()); // 쓴맛
            al.add(new Ingredient(acidity, acerbity));
        }

        recur(0, 1, 0, 0);

        System.out.println(min);
    }

    private static void recur(int index, int acidity, int acerbity, int count){
        if(index >= n){
            if( count == 0 ){
                return;
            }
            min = Integer.min(min, Math.abs(acidity - acerbity));
            return;
        }

        recur(index + 1, acidity, acerbity, count);
        recur(index + 1, acidity * al.get(index).acidity, acerbity + al.get(index).acerbity, count + 1);


    }

    private static class Ingredient{

        Integer acidity;
        Integer acerbity;

        protected Ingredient(int acidity, int acerbity) {
            this.acidity = acidity;
            this.acerbity = acerbity;
        }
    }
}
