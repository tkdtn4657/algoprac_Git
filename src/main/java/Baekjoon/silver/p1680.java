package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1680 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int weight, point;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            weight = Integer.parseInt(st.nextToken());
            point = Integer.parseInt(st.nextToken());
            p1680TrashCar garbageTruck = new p1680TrashCar(weight, 0);

            for (int i = 0; i < point; i++) {
                st = new StringTokenizer(br.readLine());
                int pointDistance = Integer.parseInt(st.nextToken());   //해당 위치의 거리값(원점기준)
                int pointWeight = Integer.parseInt(st.nextToken());     //해당 위치의 쓰레기양

                garbageTruck.movePoint(pointDistance); // 해당 포인트로 이동

                while (pointWeight > 0) {

                    if (!garbageTruck.possibleCollect(pointWeight)) { //용량을 넘게될때
                        garbageTruck.movePoint(0);
                        garbageTruck.movePoint(pointDistance);
                    }

                    if (garbageTruck.possibleCollect(pointWeight)) { // 용량이 넘지않으면 True반환
                        pointWeight = garbageTruck.collectTrash(pointWeight); // 쓰레기 수집 -> 해당 위치의 쓰레기는 0이됨
                    }

                    if (garbageTruck.isFull() && i != point - 1) { // 마지막 지점이 아닐 때 쓰레기가 꽉차면 수거장에 가서 비우고 와야함
                        garbageTruck.movePoint(0);
                        garbageTruck.movePoint(pointDistance);
                    }
                }
                if (i == point - 1) {
                    garbageTruck.movePoint(0);
                }
            }
            sb.append(garbageTruck.getMeter()).append("\n");
            System.out.println(garbageTruck.getPoints()); // 쓰레기를 담기위해 문제제출할 땐 주석처리해야함
        }
        System.out.println(sb);
    }
}

/**
 * 기본 차 인터페이스
 * recentDestination : 목적지에 이동할 때 이동한 거리를 매 순간 담음
 */
interface p1680Car {

    public int getMeter();

    public void movePoint(int distance);

    ArrayList<Integer> recentDestination = new ArrayList<>();

    default public void pointAdd(int n) {
        recentDestination.add(n);
    }

    default public ArrayList<Integer> getPoints() {
        return recentDestination;
    }

    default public void resetDestList() {
        recentDestination.clear();
    }

}

/**
 * TrashCar는 p15979Car의 상속을 받아 Meter와 movePoint를 반드시 사용해야한다.
 * 추가로 쓰레기를 담을 capacity, 쓰레기의 용량상태확인이 필요한 trashWeight이 필요
 */
class p1680TrashCar implements p1680Car {
    private int capacity;
    private int trashWeight;
    private int meter;
    private int nowLocation;

    public p1680TrashCar(int capacity, int nowLocation) {
        this.capacity = capacity;
        this.nowLocation = nowLocation;
        resetDestList();
    }

    @Override
    public int getMeter() {
        return meter;
    }

    @Override
    public void movePoint(int point) {
        if (point == 0) {
            pointAdd(nowLocation);
            meter += nowLocation;
            nowLocation = 0;
            trashWeight = 0;
            return;
        }
        pointAdd(point - nowLocation);
        meter += point - nowLocation;
        nowLocation += point - nowLocation;

    }

    public boolean possibleCollect(int weight) {
        if (capacity < trashWeight + weight) {
            return false;
        }
        return true;
    }

    public boolean isFull() { // 비었을 때는 꽉차는지 체크
        if (trashWeight >= capacity) {
            return true;
        }
        return false;
    }

    public int collectTrash(int weight) {
        trashWeight += weight;
        return 0;
    }
}