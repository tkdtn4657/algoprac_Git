package Baekjoon.Compatition.UtilCupChapter2;

import java.io.*;
import java.util.*;

public class p1079_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int I = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] color = br.readLine().toCharArray();

        int[] commandU = {-1, 0};
        int[] commandD = {1, 0};
        int[] commandL = {0, -1};
        int[] commandR = {0, 1};
        char[][] map = new char[N][N];

        int[] nowPlace = new int[2];
        ArrayList<int[]> opstaclePlaceList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == '@') {
                    nowPlace[0] = i;
                    nowPlace[1] = j;
                } else if (map[i][j] == '#') {
                    opstaclePlaceList.add(new int[]{i, j});
                }
            }
        }

        char[] commandList = br.readLine().toCharArray();

        //값 초기화 끝

        int ink = 0;
        int colorIndex = 0;
        char nowColor = color[colorIndex];
        for (char command : commandList) {
            switch (command) {
                case 'U':
                    if (nowPlace[0] + commandU[0] >= N || nowPlace[1] + commandU[1] >= N || nowPlace[0] + commandU[0] < 0 || nowPlace[1] + commandU[1] < 0
                            || isOpstaclePlace(opstaclePlaceList, new int[]{nowPlace[0] + commandU[0], nowPlace[1] + commandU[1]})) {
                        break;
                    }
                    map[nowPlace[0]][nowPlace[1]] = '.';
                    nowPlace[0] += commandU[0];
                    nowPlace[1] += commandU[1];
                    map[nowPlace[0]][nowPlace[1]] = '@';
                    break;
                case 'D':
                    if (nowPlace[0] + commandD[0] >= N || nowPlace[1] + commandD[1] >= N || nowPlace[0] + commandD[0] < 0 || nowPlace[1] + commandD[1] < 0
                            || isOpstaclePlace(opstaclePlaceList, new int[]{nowPlace[0] + commandD[0], nowPlace[1] + commandD[1]})) {
                        break;
                    }
                    map[nowPlace[0]][nowPlace[1]] = '.';
                    nowPlace[0] += commandD[0];
                    nowPlace[1] += commandD[1];
                    map[nowPlace[0]][nowPlace[1]] = '@';
                    break;
                case 'L':
                    if (nowPlace[0] + commandL[0] >= N || nowPlace[1] + commandL[1] >= N || nowPlace[0] + commandL[0] < 0 || nowPlace[1] + commandL[1] < 0
                            || isOpstaclePlace(opstaclePlaceList, new int[]{nowPlace[0] + commandL[0], nowPlace[1] + commandL[1]})) {
                        break;
                    }
                    map[nowPlace[0]][nowPlace[1]] = '.';
                    nowPlace[0] += commandL[0];
                    nowPlace[1] += commandL[1];
                    map[nowPlace[0]][nowPlace[1]] = '@';
                    break;
                case 'R':
                    if (nowPlace[0] + commandR[0] >= N || nowPlace[1] + commandR[1] >= N || nowPlace[0] + commandR[0] < 0 || nowPlace[1] + commandR[1] < 0
                            || isOpstaclePlace(opstaclePlaceList, new int[]{nowPlace[0] + commandR[0], nowPlace[1] + commandR[1]})) {
                        break;
                    }
                    map[nowPlace[0]][nowPlace[1]] = '.';
                    nowPlace[0] += commandR[0];
                    nowPlace[1] += commandR[1];
                    map[nowPlace[0]][nowPlace[1]] = '@';
                    break;
                case 'j':
                    ink++;
                    break;
                case 'J':
                    for (int[] opstaclePlace : opstaclePlaceList) {
                        if (Math.abs(nowPlace[0] - opstaclePlace[0]) + Math.abs(nowPlace[1] - opstaclePlace[1]) <= ink) {
                            map[opstaclePlace[0]][opstaclePlace[1]] = color[colorIndex % color.length];
                        }
                    }
                    colorIndex++;
                    ink = 0;
                    break;
                default:
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static boolean isOpstaclePlace(ArrayList<int[]> opstaclePlaceList, int[] xy) {
        for (int[] opstacleXY : opstaclePlaceList){
            if(opstacleXY[0] == xy[0] && opstacleXY[1] == xy[1]){
                return true;
            }
        }
        return false;
    }
}
