package Baekjoon.gold;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class p17825 {

    static final int ARRIVED_HORSE = Integer.MIN_VALUE;
    static final int[] dices = new int[10];
    static int maxScore = 0;
    static List<Field> fields = initMap();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 10; i++){
            dices[i] = Integer.parseInt(st.nextToken());
        }

        List<Horse> horseList = List.of(
                new Horse(0, false),
                new Horse(0, false),
                new Horse(0, false),
                new Horse(0, false)
        );

        playGame(0, 0, horseList);

        System.out.println(maxScore);

    }

    private static void playGame(int diceIndex, int sumScore, List<Horse> horseList) {
        if(diceIndex == 10){
            maxScore = Integer.max(sumScore, maxScore);
            return;
        }

        for(int i = 0; i < horseList.size(); i++){
            if(horseList.get(i).nowField == ARRIVED_HORSE) continue;
            List<Horse> copiedHorseList = Horse.deepCopyHorses(horseList);
            //이 때 horse의 위치가 변경됨
            int score = moveHorse(copiedHorseList.get(i), dices[diceIndex]);

            boolean rollBackFlag = false;
            for(int j = 0; j < 4; j++){
                if(i == j) continue;
                if(copiedHorseList.get(i).nowField == copiedHorseList.get(j).nowField){
                    if(copiedHorseList.get(i).nowField == ARRIVED_HORSE){
                        continue;
                    }
                    rollBackFlag = true;
                }
            }

            if(rollBackFlag){
                continue;
            }

            playGame(diceIndex+1, sumScore + score, copiedHorseList);
        }

    }

    //말이 이동 후 도착지점의 점수 반환
    private static int moveHorse(Horse horse, int moveCount){
        int nowField = horse.nowField;
        Field field = fields.get(nowField);

        if(field.index == 32){
            horse.nowField = ARRIVED_HORSE;
            return 0;
        }

        if(moveCount == 0){

            if(fields.get(nowField).nextFields.size() >= 2){
                horse.branchFlag = true;
            }

            return field.score;

        } else {

            if(horse.branchFlag){
                horse.nowField = field.nextFields.get(1).index;
                horse.branchFlag = false;
            } else {
                horse.nowField = field.nextFields.get(0).index;
            }

            return moveHorse(horse, moveCount-1);
        }
    }

    private static class Horse{
        int nowField;
        boolean branchFlag;

        public Horse(int nowField, boolean branchFlag) {
            this.nowField = nowField;
            this.branchFlag = branchFlag;
        }

        public static List<Horse> deepCopyHorses(List<Horse> horseList){
            return horseList.stream()
                    .map(horse -> new Horse(horse.nowField, horse.branchFlag))
                    .collect(Collectors.toList());
        }

    }

    private static class Field{

        List<Field> nextFields = new ArrayList<>();
        int score;
        int index;

        public Field(int score, int index) {
            this.score = score;
            this.index = index;
        }
    }

    private static List<Field> initMap(){
        List<Field> fields = new ArrayList<>();
        for(int i = 0; i <= 20; i++){
            fields.add(new Field(i*2, i));
        }

        //겉면 세팅
        for(int i = 0; i < 20; i++){
            fields.get(i).nextFields.add(fields.get(i+1));
        }

        //내부 추가
        fields.add(new Field(13, 21)); //21
        fields.add(new Field(16, 22)); //22
        fields.add(new Field(19, 23)); //23
        fields.add(new Field(25, 24)); //24
        fields.add(new Field(26, 25)); //25
        fields.add(new Field(27, 26)); //26
        fields.add(new Field(28, 27)); //27
        fields.add(new Field(22, 28)); //28
        fields.add(new Field(24, 29)); //29
        fields.add(new Field(30, 30)); //30
        fields.add(new Field(35, 31)); //31

        //브랜치 갈라지는 곳
        //10 -> 13 -> 16 -> 19 -> 25
        fields.get(5).nextFields.add(fields.get(21));
        fields.get(21).nextFields.add(fields.get(22));
        fields.get(22).nextFields.add(fields.get(23));
        fields.get(23).nextFields.add(fields.get(24));

        //20 -> 22 -> 24 -> 25 -> 30 -> 35 -> 40
        fields.get(10).nextFields.add(fields.get(28));
        fields.get(28).nextFields.add(fields.get(29));
        fields.get(29).nextFields.add(fields.get(24));
        fields.get(24).nextFields.add(fields.get(30));
        fields.get(30).nextFields.add(fields.get(31));
        fields.get(31).nextFields.add(fields.get(20));

        //30 -> 28 -> 27 -> 26 -> 25
        fields.get(15).nextFields.add(fields.get(27));
        fields.get(27).nextFields.add(fields.get(26));
        fields.get(26).nextFields.add(fields.get(25));
        fields.get(25).nextFields.add(fields.get(24));

        //종료필드 추가
        fields.add(new Field(ARRIVED_HORSE, 32));
        fields.get(20).nextFields.add(fields.get(32));

        return fields;
    }
}
