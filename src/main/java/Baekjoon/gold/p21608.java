package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p21608 {

    static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] likes = new int[n*n][5];

        int[][] classRoom = new int[n+1][n+1];

        for(int i = 0; i < n*n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                likes[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //n이 20이라서 전체 구현을 브루트포스로 매번 진행해도 시간은 문제가 없음
        //정말 무식하게 풀어보자

        //자리배치
            //좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
            //1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
            //2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.

        for(int i = 0; i < n*n; i++){
            //각 배열의 0번 인덱스를 기준으로 가로세로 위치에 있어야 인접
            setClassRoom(likes[i], classRoom);
        }

        //점수계산
        int totalScore = 0;
        for(int student = 0; student < n*n; student++){
            Set<Integer> likeStudents = new HashSet<>();
            for(int i = 1; i < 5; i++){
                likeStudents.add(likes[student][i]);
            }

            for(int i = 0; i < classRoom.length; i++) {
                for(int j = 0; j < classRoom.length; j++){
                    if(likes[student][0] == classRoom[i][j]){

                        int likeCount = 0;

                        for(int[] move : moves){
                            int dx = i + move[0];
                            int dy = j + move[1];

                            if(dx < 1 || dy < 1 || dx >= classRoom.length || dy >= classRoom.length)
                                continue;

                            if(likeStudents.contains(classRoom[dx][dy])){
                                likeCount++;
                            }

                        }

                        switch (likeCount){
                            case 1:
                                totalScore += 1;
                                break;
                            case 2:
                                totalScore += 10;
                                break;
                            case 3:
                                totalScore += 100;
                                break;
                            case 4:
                                totalScore += 1000;
                                break;
                        }
                    }
                }
            }

        }

        System.out.println(totalScore);

    }

    private static void setClassRoom(int[] likes, int[][] classRoom){

        int length = classRoom.length;
        //1번 조건 priority
        int[][] classRoomLikePriority = new int[length][length];

        //2번 조건 priority
        int[][] classRoomEmptyPriority = new int[length][length];

        //2번 조건은 1번 조건을 만족하는 칸이 여러 개
        //3번 조건은 2번 조건을 만족하는 칸이 여러 개

        Queue<Integer[]> firstPriorityCorrectList = new ArrayDeque<>();
        Queue<Integer[]> secondPriorityCorrectList = new ArrayDeque<>();

        int student = likes[0];
        Set<Integer> likeStudent = new HashSet<>();
        for(int i = 1; i < likes.length; i++){
            likeStudent.add(likes[i]);
        }

        for(int i = 1; i < length; i++){
            for(int j = 1; j < length; j++){
                //0이여야 아직 배치하지 않은 값이기 때문에 활용 가능
                if(classRoom[i][j] == 0){

                    int likeCount = 0;

                    for(int[] move : moves){
                        int dx = i + move[0];
                        int dy = j + move[1];

                        if(dx < 1 || dy < 1 || dx >= length || dy >= length) continue;

                        if(likeStudent.contains(classRoom[dx][dy])){
                            likeCount++;
                        }
                    }

                    classRoomLikePriority[i][j] = likeCount;
                }
            }
        }

        int firstMax = -1;
        for(int i = 1; i < length; i++){
            for(int j = 1; j < length; j++){
                if(classRoom[i][j] != 0) continue;
                if(classRoomLikePriority[i][j] > firstMax){
                    firstMax = classRoomLikePriority[i][j];
                    firstPriorityCorrectList.clear();
                    firstPriorityCorrectList.add(new Integer[]{i, j});
                } else if(classRoomLikePriority[i][j] == firstMax){
                    firstPriorityCorrectList.add(new Integer[]{i, j});
                }
            }
        }

        if(firstPriorityCorrectList.size() == 1) {
            Integer[] place = firstPriorityCorrectList.poll();
            classRoom[place[0]][place[1]] = student;
            return;
        }
        for(int i = 1; i < length; i++){
            for(int j = 1; j < length; j++) {
                if(classRoom[i][j] != 0) continue;
                //0이여야 아직 배치하지 않은 값이기 때문에 활용 가능
                if(classRoomLikePriority[i][j] == firstMax){
                    for(int[] move : moves){
                        int dx = i + move[0];
                        int dy = j + move[1];

                        if(dx < 1 || dy < 1 || dx >= length || dy >= length) continue;

                        if(classRoom[dx][dy] == 0){
                            classRoomEmptyPriority[i][j]++;
                        }
                    }
                }
            }
        }

        //2번째 조건
        int secondMax = -1;
        for(Integer[] place : firstPriorityCorrectList){
            int i = place[0];
            int j = place[1];
            if(classRoomEmptyPriority[i][j] > secondMax){
                secondMax = classRoomEmptyPriority[i][j];
                secondPriorityCorrectList.clear();
                secondPriorityCorrectList.add(new Integer[]{i, j});
            } else if(classRoomEmptyPriority[i][j] == secondMax){
                secondPriorityCorrectList.add(new Integer[]{i, j});
            }
        }

        Integer[] place = secondPriorityCorrectList.poll();
        classRoom[place[0]][place[1]] = student;

    }
}
