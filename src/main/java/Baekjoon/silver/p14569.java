package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p14569 {
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        //과목 초기화
        List<Integer>[] subjects = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            subjects[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            for (int j = 0; j < size; j++) {
                subjects[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            ArrayList<Integer> student = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                student.add(Integer.parseInt(st.nextToken()));
            }
            int[] visited = new int[51];
            Arrays.fill(visited, -1);
            boolean[] subjectVisited = new boolean[subjects.length];
            max = 0;
            maxSubject(subjects, student, subjectVisited, visited, 0, 0);
            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }

    static void maxSubject(List<Integer>[] subjects, List<Integer> student, boolean[] subjectVisited, int[] visited, int n, int hitCount) {
        if (n == subjects.length) {
            max = Integer.max(hitCount, max);
            return;
        }
        for (int i = 0; i < subjects.length; i++) {
            if (!subjectVisited[i]) {
                subjectVisited[i] = true;
                boolean flag = false;
                for (int time : subjects[i]) {
                    if (visited[time] != -1) {
                        flag = true;
                        break;
                    }
                    visited[time] = i;
                }
                if (flag) {
                    maxSubject(subjects, student, subjectVisited, visited, n + 1, hitCount);
                } else {
                    maxSubject(subjects, student, subjectVisited, visited, n + 1, hitCount + checkCount(subjects[i], student, visited, i));
                }
                subjectVisited[i] = false;
            }
        }
    }

    static int checkCount(List<Integer> subject, List<Integer> student, int[] visited, int i) {
        int count = 0;
        int hitSubject = 0;

        for (int time : student) {
            //contain이 비용이 비싸니까 배열로 체크?
            if (visited[time] == i) {
                count++;
            }

        }
        if (count == subject.size()) {
            return 1;
        }

        return 0;
    }
}
