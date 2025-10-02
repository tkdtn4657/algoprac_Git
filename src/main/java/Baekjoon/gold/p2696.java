package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p2696 {
    static int count = 1;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //우선순위큐로 정렬된 값을 만들고 이분탐색으로 중앙값 계속 보여주기?
        //우선순위큐가 두개 있을 때 입력되는 값보다 크면?
        //23 41 13 22
        //13 22 -----  23 41
        //위와 같이 있을 때 -3이 들어오면
        //어디에 넣을건데?
        //짝수일 땐 마지막 peek값을 기준으로 어디 넣을지 판단
        //수가 많은 큐에 들어갔다면, 많은쪽에 있는 큐 하나를 빼서 반대쪽 큐에 넣어줌

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            PriorityQueue<Integer> ascQueue = new PriorityQueue<>();
            PriorityQueue<Integer> descQueue = new PriorityQueue<>(Comparator.reverseOrder());

            int m = Integer.parseInt(br.readLine());
            sb.append(m/2+1).append(System.lineSeparator());
            Queue<Integer> inputNumbers = new LinkedList<>();
            while(m > 0){
                //10개 단위
                m -= 10;
                StringTokenizer st = new StringTokenizer(br.readLine());
                while(st.hasMoreTokens()) {
                    inputNumbers.add(Integer.parseInt(st.nextToken()));
                }
            }

            count = 1;
            inputNumbers.forEach(
                    number -> {
                        addNumber(number, ascQueue, descQueue, count++);
                    }
            );
            sb.setLength(sb.length()-1);
            sb.append("\n");

        }

        System.out.println(sb);

    }

    private static void addNumber(int inputNum, PriorityQueue<Integer> rightQueue, PriorityQueue<Integer> leftQueue, int count){
        if(count % 20 == 0){
            //10개마다 줄바꿈
            sb.setLength(sb.length()-1);
            sb.append(System.lineSeparator());
        }
        if(count % 2 == 1){
            //홀수일 때 로직 순서 적어
            //앞뒤 큐를 비교해
            //0부터 시작하자
            //왼쪽 peek보다 작은지, 오른쪽 peek보다 큰지 체크
            //둘중 조건에 맞는 곳에 들어갈거야

            //최초 첫번째 입력!
            if(rightQueue.isEmpty() && leftQueue.isEmpty()){
                sb.append(inputNum).append(' ');
                leftQueue.add(inputNum);
                return;
            }

            //짝수일 때 밸런스 맞추기 때문에 여기서 널포인트는 안나와
            if(inputNum < leftQueue.peek()){
                sb.append(leftQueue.peek()).append(" ");
                leftQueue.add(inputNum);
            } else if (inputNum > rightQueue.peek()){
                sb.append(rightQueue.peek()).append(" ");
                rightQueue.add(inputNum);
            } else {
                //얘 자체가 중앙값일 때
                sb.append(inputNum).append(" ");
                leftQueue.add(inputNum);
            }
        } else {
            //짝수번째 입력일 때 큐 밸런스 맞춰줄거야
            if(inputNum < leftQueue.peek()){
                rightQueue.add(leftQueue.poll());
                leftQueue.add(inputNum);
            } else if(!rightQueue.isEmpty() && inputNum > rightQueue.peek()){
                rightQueue.add(inputNum);
            } else {
                rightQueue.add(inputNum);
            }
            while(rightQueue.size() - leftQueue.size() > 1){
                leftQueue.add(rightQueue.poll());
            }
        }
    }

}
