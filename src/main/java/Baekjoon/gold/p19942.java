package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p19942 {

    static int n;
    static int danMini;
    static int jiMini;
    static int tanMini;
    static int viMini;
    static int min = Integer.MAX_VALUE;
    static ArrayList<Ingredient> al = new ArrayList<>();
    static Set<Integer> indexList = new HashSet<>();
    static String answerString = "";
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        danMini = Integer.parseInt(st.nextToken());
        jiMini = Integer.parseInt(st.nextToken());
        tanMini = Integer.parseInt(st.nextToken());
        viMini = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int dan = Integer.parseInt(st.nextToken());
            int ji = Integer.parseInt(st.nextToken());
            int tan = Integer.parseInt(st.nextToken());
            int vi = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            al.add(new Ingredient(dan, ji, tan, vi, price));
        }

        recur(0, 0, 0, 0, 0, 0, 0);


        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(min);
        System.out.println(answerString);

    }

    public static void recur(int idx, int sumDan, int sumJi, int sumTan, int sumVi, int sumPrice,int count) {
        if (idx >= n) {
            if(count == 0){
                return;
            }

            if(danMini <= sumDan && jiMini <= sumJi && tanMini <= sumTan && viMini <= sumVi) {
                if (min > sumPrice) {
                    min = sumPrice;

                    sb.setLength(0);
                    for(int num : indexList){
                        sb.append(num+1).append(" ");
                    }
                    answerString = sb.toString();
                }

                if (min == sumPrice) {
                    min = sumPrice;

                    sb.setLength(0);
                    for(int num : indexList){
                        sb.append(num+1).append(" ");
                    }

                    if(answerString.compareTo(sb.toString()) > 0){
                        answerString = sb.toString();
                    }
                }
            }
            return;
        }

        recur(idx + 1, sumDan, sumJi, sumTan, sumVi, sumPrice, count);
        indexList.add(idx);
        recur(idx + 1,
                sumDan + al.get(idx).dan,
                sumJi + al.get(idx).ji,
                sumTan + al.get(idx).tan,
                sumVi + al.get(idx).vi,
                sumPrice + al.get(idx).price,
                count + 1
        );
        indexList.remove(idx);
    }

    private static class Ingredient {

        int dan;
        int ji;
        int tan;
        int vi;
        int price;

        protected Ingredient(int dan, int ji, int tan, int vi, int price) {
            this.dan = dan;
            this.ji = ji;
            this.tan = tan;
            this.vi = vi;
            this.price = price;
        }
    }
}
