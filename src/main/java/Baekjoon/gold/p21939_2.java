package Baekjoon.gold;

import java.io.*;
import java.util.*;

/**
 * 우선순위큐 구현
 */
public class p21939_2 {

    static final Comparator<Problem> ascComparator = (o1, o2) -> {
        if(o1.problemLevel == o2.problemLevel) {
            return o1.problemNumber - o2.problemNumber;
        }
        return o1.problemLevel - o2.problemLevel;
    };

    static final Comparator<Problem> descComparator = (o1, o2) -> {
        if(o1.problemLevel == o2.problemLevel) {
            return o2.problemNumber - o1.problemNumber;
        }
        return o2.problemLevel - o1.problemLevel;
    };

    static PriorityQueue<Problem> ascPq = new PriorityQueue<>(ascComparator);
    static PriorityQueue<Problem> descPq = new PriorityQueue<>(descComparator);
    static Map<Integer, Integer> solvedProblem = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int problemNumber = Integer.parseInt(st.nextToken());
            int problemLevel = Integer.parseInt(st.nextToken());
            add(problemNumber, problemLevel);

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

    private static class Problem{
        int problemNumber;
        int problemLevel;

        Problem(int problemNumber, int problemLevel){
            this.problemNumber = problemNumber;
            this.problemLevel = problemLevel;
        }
    }

    private static void recommend(int x){
        if(x == 1){
            while(!solvedProblem.containsKey(descPq.peek().problemNumber)
                    || solvedProblem.get(descPq.peek().problemNumber) != descPq.peek().problemLevel){
                descPq.poll();
            }
            sb.append(descPq.peek().problemNumber).append(System.lineSeparator());
        } else {
            while(!solvedProblem.containsKey(ascPq.peek().problemNumber)
            || solvedProblem.get(ascPq.peek().problemNumber) != ascPq.peek().problemLevel){
                ascPq.poll();
            }
            sb.append(ascPq.peek().problemNumber).append(System.lineSeparator());
        }
    }

    private static void add(int p, int l){
        Problem problem = new Problem(p, l);

        ascPq.add(problem);
        descPq.add(problem);
        solvedProblem.put(p, l);
    }

    private static void solved(int p){
        solvedProblem.remove(p);
    }
}
