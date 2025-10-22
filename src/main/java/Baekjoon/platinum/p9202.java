package Baekjoon.platinum;

import java.io.*;
import java.util.*;

public class p9202 {
    static final int n = 4;
    static int sumScore = 0;
    static Set<String> wordSet = new HashSet<>();
    static Set<String> correctWordSet = new TreeSet<>(
            (o1, o2) -> {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                } else {
                    return o2.length() - o1.length();
                }
            }
    );
    static boolean[][] visited;
    static char[][] boggle;
    static int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, 1}, {1, 1}, {-1, -1}, {1, -1}};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int w = Integer.parseInt(br.readLine());
        for(int i = 0; i < w; i++){
            wordSet.add(br.readLine());
        }
        br.readLine();

        int b = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int gameCount = 0; gameCount < b; gameCount++) {

            boggle = new char[n][n];
            visited = new boolean[n][n];
            sumScore = 0;
            correctWordSet.clear();

            for (int i = 0; i < n; i++) {
                boggle[i] = br.readLine().toCharArray();
            }

            //길이 기준으로 w목록을 안돌려도 되는가?
            //길이 기준은 이따 가지치기 생각해보자
            //일단 셋으로만 계속 비교해볼까?
            //단어는 최대 8글자
            //브루트포스로 다 돌아봐

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    visited[i][j] = true;
                    dfs(new StringBuilder(String.valueOf(boggle[i][j])), i, j);
                    visited[i][j] = false;
                }
            }

            sb.append(sumScore)
                    .append(" ")
                    .append(correctWordSet.stream().findFirst().get())
                    .append(" ")
                    .append(correctWordSet.size())
                    .append(System.lineSeparator());

            if(gameCount == b-1) break;
            br.readLine();
        }

        System.out.println(sb);

    }

    private static void dfs(StringBuilder word, int x, int y){
        int wordLength = word.length();
        if(wordLength > 8) {
            return;
        }
        String wordString = word.toString();
        if(wordSet.contains(wordString)){
            //이미 셋에 존재하면 점수추가x
            if(correctWordSet.add(wordString)){
                switch (wordString.length()){
                    case 3:
                        sumScore+=1;
                        break;
                    case 4:
                        sumScore+=1;
                        break;
                    case 5:
                        sumScore+=2;
                        break;
                    case 6:
                        sumScore+=3;
                        break;
                    case 7:
                        sumScore+=5;
                        break;
                    case 8:
                        sumScore+=11;
                        return;
                    default:
                        break;
                }
            }
        }

        for(int[] move : moves){
            int dx = move[0] + x;
            int dy = move[1] + y;
            if(dx >= 0 && dy >= 0 && dx < n && dy < n) {
                if(!visited[dx][dy]) {
                    if(word.length() >= 9) continue;
                    visited[dx][dy] = true;
                    word.append(boggle[dx][dy]);
                    dfs(word, dx, dy);
                    word.setLength(word.length() - 1);
                    visited[dx][dy] = false;
                }
            }
        }
    }
}
