package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p21939 {

    static class Problem {
        int problemNum, problemLevel;
        public Problem(int problemNum, int problemLevel) {
            this.problemNum = problemNum;
            this.problemLevel = problemLevel;
        }
    }

    static final Comparator<Problem> ascComp = (o1, o2) -> {
        if (o1.problemLevel == o2.problemLevel) return o1.problemNum - o2.problemNum;
        return o1.problemLevel - o2.problemLevel;
    };
    static final Comparator<Problem> descComp = (o1, o2) -> {
        if (o1.problemLevel == o2.problemLevel) return o2.problemNum - o1.problemNum;
        return o2.problemLevel - o1.problemLevel;
    };

    static PriorityQueue<Problem> ascPq = new PriorityQueue<>(ascComp);
    static PriorityQueue<Problem> descPq = new PriorityQueue<>(descComp);
    static Map<Integer, Integer> problemMap = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            add(num, level);
        }

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());
                recommend(x);
            } else if (cmd.equals("add")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                add(p, l);
            } else { // solved
                int p = Integer.parseInt(st.nextToken());
                solved(p);
            }
        }
        System.out.print(sb);
    }

    private static void add(int p, int l) {
        Problem prob = new Problem(p, l);
        ascPq.add(prob);
        descPq.add(prob);
        problemMap.put(p, l);
    }

    private static void solved(int p) {
        problemMap.remove(p); // 실제 제거는 안 하고 map에서만 삭제
    }

    private static void recommend(int x) {
        if (x == 1) {
            while (!descPq.isEmpty()) {
                Problem top = descPq.peek();
                if (problemMap.containsKey(top.problemNum) && problemMap.get(top.problemNum) == top.problemLevel) {
                    sb.append(top.problemNum).append('\n');
                    return;
                }
                descPq.poll(); // 이미 제거된 문제는 버림
            }
        } else {
            while (!ascPq.isEmpty()) {
                Problem top = ascPq.peek();
                if (problemMap.containsKey(top.problemNum) && problemMap.get(top.problemNum) == top.problemLevel) {
                    sb.append(top.problemNum).append('\n');
                    return;
                }
                ascPq.poll();
            }
        }
    }
}


/**
 * 시간 초과 코드.. 삭제에 대한 속도 개선이 이루어지지않아 상당히 느림
 * 
package Baekjoon.gold;

import java.io.*;
import java.util.*;
import java.util.stream.*;
 
public class p21939 {

    static final Comparator<Problem> ascProblemComparator = (o1, o2) -> {
        if(o1.problemLevel == o2.problemLevel){
            return o1.problemNum - o2.problemNum;
        }
        return o1.problemLevel - o2.problemLevel;
    };

    static final Comparator<Problem> descProblemComparator = (o1, o2) -> {
        if(o1.problemLevel == o2.problemLevel){
            return o2.problemNum - o1.problemNum;
        }
        return o2.problemLevel - o1.problemLevel;
    };

    static PriorityQueue<Problem> ascPq = new PriorityQueue<>(ascProblemComparator);
    static PriorityQueue<Problem> descPq = new PriorityQueue<>(descProblemComparator);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //recommend : 1 or -1
        //add : P : 문제번호 | L : 난이도
        //solved P : 문제 제거

        int n = Integer.parseInt(br.readLine());

        while(n-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int problemNum = Integer.parseInt(st.nextToken());
            int problemLevel = Integer.parseInt(st.nextToken());

            Problem problem = new Problem(problemNum, problemLevel);

            ascPq.add(problem);
            descPq.add(problem);
        }

        int m = Integer.parseInt(br.readLine());

        while(m-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int paramOne = Integer.parseInt(st.nextToken());
            int paramTwo = 0;
            if (st.hasMoreTokens()) {
                paramTwo = Integer.parseInt(st.nextToken());
            }

            switch (command) {
                case "recommend":
                    recommend(paramOne);
                    break;
                case "add":
                    add(paramOne, paramTwo);
                    break;
                case "solved":
                    solved(paramOne);
                    break;
            }
        }

        System.out.println(sb);

    }
 
    private static void recommend(int x){
        if(x == 1){
            sb.append(descPq.peek().problemNum).append(System.lineSeparator());
        } else {
            sb.append(ascPq.peek().problemNum).append(System.lineSeparator());
        }
    }

    private static void add(int p, int l){
        Problem problem = new Problem(p, l);
        ascPq.add(problem);
        descPq.add(problem);
    }

    private static void solved(int p){
        List<Problem> solvedList = ascPq.stream()
                .filter(problem -> problem.problemNum != p)
                .collect(Collectors.toList());

        ascPq.clear();
        descPq.clear();

        ascPq.addAll(solvedList);
        descPq.addAll(solvedList);
    }

    private static class Problem{
        int problemNum;
        int problemLevel;

        public Problem(int problemNum, int problemLevel) {
            this.problemNum = problemNum;
            this.problemLevel = problemLevel;
        }
    }
}
**/