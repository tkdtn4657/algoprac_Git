package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p12764 {

    private static final Comparator<People> startTimeComparator = Comparator.comparingInt(o -> o.startTime);
    private static final Comparator<People> endTimeComparator = Comparator.comparingInt(o -> o.endTime);
    private static final int NOT_PLACED = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //우선순위 큐를 두개 두고, 가변길이인 List를 둠
        //시작시간 순 큐, 종료시간 순 큐
        //시작시간 순으로 최초 사용자를 받고,
        //받은 사용자는 종료시간 큐에 넣음(여기 있는게 현재 사용중인 경우)
        //최초 입력 받을 때 종료시간 젤 긴 시간을 저장하고
        //제일 긴 시간까지 for문 1초씩 증가
        //종료시간 큐에서 peek하며 타임을 확인해서 time이 지나는 순간 사용 큐에서 제거

        //여기서 디테일은 큐에 넣을 때 클래스에 좌석 선점정보를 같이 넣어둠
        //좌석이 이미 arraylist 사이즈에 맞게 속하면 해당 위치에 ++하면 되고,
        //좌석이 풀로 차 있으면 arraylist에 add하면 되니까!

        //1. 클래스에 시작시간, 종료시간, 좌석 큐를 둠
        //2. 최초 입력받을 때 클래스를 생성해서 시작시간큐에 넣음
        //3. 시작시간큐를 peek해서 사용큐에 담음, 이 때 arraylist 사이즈 확인
        //4. arraylist사이즈와 시작큐의 크기가 안맞으면 좌석을 add로 늘림

        PriorityQueue<People> startTimePq = new PriorityQueue<>(startTimeComparator);
        PriorityQueue<People> endTimePq = new PriorityQueue<>(endTimeComparator);
        PriorityQueue<Integer> seatTicket = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        int maxTime = 0;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            maxTime = Integer.max(maxTime, q);

            People people = new People(p, q, NOT_PLACED);
            startTimePq.add(people);
        }

        List<Integer> seatList = new ArrayList<>();
        for(int time = 0; time <= maxTime; time++){
            if(!startTimePq.isEmpty()) {
                int peopleTime = startTimePq.peek().startTime;
                if(time == peopleTime){
                    People nowPeople = startTimePq.poll();

                    //정상적으로 돌아가는 경우
                    if(!seatTicket.isEmpty()){
                        int seatNumber = seatTicket.poll();
                        seatList.set(seatNumber, seatList.get(seatNumber)+1);
                        nowPeople.seat = seatNumber;
                    } else {
                        //좌석을 추가해줘야 하는 경우
                        seatList.add(1);
                        //티켓 번호는 순차적으로
                        nowPeople.seat = seatList.size()-1;
                    }

                    endTimePq.add(nowPeople);
                }
            }

            if(!endTimePq.isEmpty()) {
                int peopleTime = endTimePq.peek().endTime;
                if(time == peopleTime){
                    People nowPeople = endTimePq.poll();

                    int ticketNumber = nowPeople.seat;
                    seatTicket.add(ticketNumber);
                }
            }
        }

        System.out.println(seatList.size());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < seatList.size(); i++){
            sb.append(seatList.get(i)).append(" ");
        }

        sb.setLength(sb.length()-1);
        System.out.println(sb);

    }

    private static class People{
        int startTime;
        int endTime;
        int seat;

        public People(int startTime, int endTime, int seat) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.seat = seat;
        }
    }


}
