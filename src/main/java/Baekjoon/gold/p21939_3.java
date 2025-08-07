package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p21939_3 {

    static StringBuilder sb = new StringBuilder();
    static Map<Integer, Integer> problemMap = new HashMap<>();
    static TreeSet<Problem> problemTree = new TreeSet<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            add(p, l);
        }

        int m = Integer.parseInt(br.readLine());
        while(m-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            int paramOne = Integer.parseInt(st.nextToken());
            int paramTwo = 0;
            if(st.hasMoreTokens()){
                paramTwo = Integer.parseInt(st.nextToken());
            }

            switch(command){
                case "recommend" :
                    recommend(paramOne);
                    break;
                case "add" :
                    add(paramOne, paramTwo);
                    break;
                case "solved" :
                    solved(paramOne);
                    break;
            }

        }
        System.out.println(sb);
    }

    private static class Problem implements Comparable<Problem>{
        int p;
        int l;

        Problem(int p, int l){
            this.p = p;
            this.l = l;
        }

        @Override
        public int compareTo(Problem o) {
            if(this.l == o.l){
                return this.p - o.p;
            }
            return this.l - o.l;
        }
    }

    private static void add(int p, int l){
        problemTree.add(new Problem(p, l));
        problemMap.put(p, l);
    }

    private static void recommend(int x){
        if(x == 1){
            while(!problemMap.containsKey(problemTree.last().p)) {
                problemTree.pollLast();
            }
            sb.append(problemTree.last().p).append(System.lineSeparator());
        } else {
            while(!problemMap.containsKey(problemTree.first().p)){
                problemTree.pollFirst();
            }
            sb.append(problemTree.first().p).append(System.lineSeparator());
        }
    }

    private static void solved(int p){
        int level = problemMap.get(p);
        problemMap.remove(p);

        problemTree.remove(new Problem(p, level));
    }

}
