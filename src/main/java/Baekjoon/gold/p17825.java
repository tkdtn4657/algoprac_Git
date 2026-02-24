package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p17825 {

    //41보다 크면 도착
    static final int ARRIVED_NODE_NUMBER = 41;
    static final int START_NODE_NUMBER = 0;
    static List<Field> map = new ArrayList<>();
    static int[] diceArray = new int[10];
    static List<Horse> horseList = new ArrayList<>();
    static int maxScore = 0;
    static int parent = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //주사위 수 10개를 입력받아서 백트래킹으로 모든 경우의 수를 탐색.
        //점수는 이동을 마칠 때마다 칸에 적혀있는 수가 점수에 추가

        //말 4개를 시뮬레이션 해서 주사위 10개를 다 돌려보는 문제

        //1. 노드를 단방향으로 추가
        //2. 출발 노드와 도착 노드는 각각 MAX,MIN value
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 10; i++){
            diceArray[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < 4; i++){
            horseList.add(new Horse(0, false));
        }

        setGame(map);

        horseMove(0, horseList, 0, 0);
        horseMove(0, horseList, 1, 0);
        horseMove(0, horseList, 2, 0);
        horseMove(0, horseList, 3, 0);

        System.out.println(maxScore);

    }

    private static void horseMove(int diceIndex, List<Horse> horseList, int pickedHorse, int score){
        if(diceIndex >= 10) {
            maxScore = Integer.max(score, maxScore);
            return;
        }
        Horse nowHorse = horseList.get(pickedHorse);

        int nodeNumber;
        if(map.get(nowHorse.nowNumber).isBranch()){
            nodeNumber = moveNode(diceArray[diceIndex], nowHorse.nowNumber, true, nowHorse.nowNumber);
        } else {
            nodeNumber = moveNode(diceArray[diceIndex], nowHorse.nowNumber, false, nowHorse.nowNumber);
        }


        for(int i = 0; i < 4; i++){
            if(pickedHorse == i) continue;
            if(nodeNumber == horseList.get(pickedHorse).nowNumber) return;
        }

        if(nodeNumber >= ARRIVED_NODE_NUMBER) {
            nowHorse.arrivedFlag = true;
        } else {
            nowHorse.nowNumber = nodeNumber;
            score += nodeNumber;
        }

        List<Horse> copiedHorseList = Horse.deepCopyHorseList(horseList);
        for(int horseNumber = 0; horseNumber < 4; horseNumber++){
            if(copiedHorseList.get(horseNumber).horseIsArrived()) continue;
            horseMove(diceIndex + 1, copiedHorseList, horseNumber, score);
        }

    }

    private static int moveNode(int remainMoveCount, int nextNode, boolean branchFlag){
        if(nextNode == 42) return 42;


        if(branchFlag){
            return moveNode(remainMoveCount-1, map.get(nextNode).nextNumbers.get(1), false);
        } else {
            if(remainMoveCount == 1) {
                if(map.get(nextNode).isBranch()){
                    return map.get(nextNode).nextNumbers.get(1);
                } else {
                    return map.get(nextNode).nextNumbers.get(0);
                }
            }
        }
        return moveNode(remainMoveCount-1, map.get(nextNode).nextNumbers.get(0), false);
    }

    private static class Field {
        Queue<Horse> horses = new ArrayDeque<>();
        List<Integer> nextNumbers = new ArrayList<>();

        public Field() {}
        public boolean fieldIsEmpty(Horse horse){
            return this.horses.isEmpty();
        }

        public boolean isBranch(){
            return this.nextNumbers.size() > 1;
        }

    }

    private static class Horse {
        int nowNumber;
        boolean arrivedFlag;

        Horse(int number, boolean flag){
            this.nowNumber = number;
            this.arrivedFlag = flag;
        }

        public boolean horseIsArrived(){
            return arrivedFlag;
        }

        public static List<Horse> deepCopyHorseList(List<Horse> horseList){
            return horseList.stream()
                    .map(horse -> new Horse(horse.nowNumber, horse.arrivedFlag))
                    .toList();
        }

        @Override
        public boolean equals(Object o1) {
            Horse horse = (Horse) o1;
            return this.nowNumber == horse.nowNumber;
        }
    }

    private static void setGame(List<Field> map){
        //시작노드와 출발노드를 포함해 모든 노드는 33개
        //하지만 인덱스로 노드위치를 매핑하기 위해 총 42개의 노드 생성
        final int totalNode = 42;
        for(int i = 0; i < totalNode; i++){
            map.add(new Field());
        }

        //겉면 초기화 (2점씩)
        for(int i = 0; i <= 40; i+=2){
            map.get(i).nextNumbers.add(i+2);
        }
        
        //분기 처리 (10, 20, 30)
        map.get(10).nextNumbers.add(13);
        map.get(20).nextNumbers.add(22);
        map.get(30).nextNumbers.add(28);

        //중앙 필드 next처리
        map.get(13).nextNumbers.add(16);
        map.get(16).nextNumbers.add(19);
        map.get(19).nextNumbers.add(25);

        map.get(22).nextNumbers.add(24);
        map.get(24).nextNumbers.add(25);

        map.get(28).nextNumbers.add(27);
        map.get(27).nextNumbers.add(26);
        map.get(26).nextNumbers.add(25);

        map.get(25).nextNumbers.add(30);
        map.get(30).nextNumbers.add(35);
        map.get(35).nextNumbers.add(40);
    }
}
