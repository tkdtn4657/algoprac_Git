package Baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 스택은 무시되고, 큐의 집합으로만 이루어진다면
 * 해당 큐는 단일큐로 합쳐서 생각할 수 있음
 * 또는 디큐하나로 스택큐연산을 통해 해결할 수도 있음
 */
public class p24511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] queueOrStack = new int[n];
        int[] initNum = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            queueOrStack[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            initNum[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] inputNum = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            inputNum[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (queueOrStack[i] == 0) {
                q.add(initNum[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            q.add(inputNum[i]);
            sb.append(q.poll()).append(" ");
        }

        System.out.println(sb);

    }
}

/**
 * 시간초과코드 이유 : q가 n개로 되어있다면 똑같음... 생각전환이 필요
 * n개의 q처리로도 오래걸림
 * <p>
 * 시간초과코드
 * 다음 코드는 그냥 스택자체면 사이즈도 반영하지말자
 * 진짜 속도만 생각해보기
 */
//public class p24511{
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        int[] queueOrStack = new int[n];
//        int[] initNum = new int[n];
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        for(int i = 0; i < n; i++) {
//            queueOrStack[i] = Integer.parseInt(st.nextToken());
//        }
//        st = new StringTokenizer(br.readLine());
//
//        for(int i = 0; i < n; i++) {
//            initNum[i] = Integer.parseInt(st.nextToken());
//        }
//
//        int m = Integer.parseInt(br.readLine());
//        int[] inputNum = new int[m];
//        st = new StringTokenizer(br.readLine());
//        for(int i = 0; i < m; i++){
//            inputNum[i] = Integer.parseInt(st.nextToken());
//        }
//        //입력받기 끝
//        List<Queue> qList = new ArrayList<>();
//        Queue<Integer> queue;
//
//        for(int i = 0; i < n; i++){
//            queue = new LinkedList<>();
//            if(queueOrStack[i] == 0){
//                queue.add(initNum[i]);
//                qList.add(queue);
//            }
//        }
//
//        StringBuilder sb  =new StringBuilder();
//        String blank = " ";
//        for(int i = 0; i < m; i++){
//            int temp = inputNum[i];
//            for(Queue<Integer> q : qList){
//                q.offer(temp);
//                temp = q.poll();
//            }
//            sb.append(temp).append(blank);
//        }
//
//        System.out.println(sb);
//
//
//    }
//}


/**
 * 시간초과코드
 * 다음 코드는 그냥 스택자체면 사이즈도 반영하지말자
 * 진짜 속도만 생각해보기
 */
//public class p24511 {
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        int[] queueOrStack = new int[n];
//        int[] initNum = new int[n];
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        for(int i = 0; i < n; i++) {
//            queueOrStack[i] = Integer.parseInt(st.nextToken());
//        }
//        st = new StringTokenizer(br.readLine());
//
//        for(int i = 0; i < n; i++) {
//            initNum[i] = Integer.parseInt(st.nextToken());
//        }
//
//        int m = Integer.parseInt(br.readLine());
//        int[] inputNum = new int[m];
//        st = new StringTokenizer(br.readLine());
//        for(int i = 0; i < m; i++){
//            inputNum[i] = Integer.parseInt(st.nextToken());
//        }
//
//        p24511QueueStack queueStack = new p24511QueueStack(queueOrStack, initNum);
//
//        StringBuilder sb = new StringBuilder();
//        for(int num : inputNum) {
//            sb.append(queueStack.inputNum(num)).append(" ");
//        }
//
//        System.out.println(sb);
//    }
//}
//
//class p24511QueueStack{
//    List<Queue<Integer>> queueList = new ArrayList<>();
//    Queue<Integer> q = new LinkedList<>();
//    boolean[] isQueue;
//
//    p24511QueueStack(int[] queueOrStack, int[] numArray){//원소 하나씩 넣어야하기때문
//        isQueue = new boolean[numArray.length];
//        int index = 0;
//        for(int num : numArray){
//            q = new LinkedList<>();
//            q.add(num);
//            queueList.add(q);
//            if(queueOrStack[index++] == 0) {
//                isQueue[index-1] = true;
//            }
//        }
//
//    }
//
//    int inputNum(int inputNum){
//        int index = 0;
//        int returnNum = inputNum;
//        for(Queue<Integer> a : queueList){
//            if(isQueue[index++]) {
//                a.offer(returnNum);
//                returnNum = a.poll();
//            }
//        }
//        return returnNum;
//    }
//
//}
