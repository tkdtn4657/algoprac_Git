package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p23253 {

    static PriorityQueue<Stack> sList = new PriorityQueue<Stack>(new Comparator<Stack>() {
        @Override
        public int compare(Stack o1, Stack o2) {
            return (int) o1.peek() - (int) o2.peek();
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int mSize = 0;
        for (int i = 0; i < m; i++) {
            mSize = Integer.parseInt(br.readLine());
            Stack<Integer> stack = new Stack<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < mSize; j++) {
                stack.push(Integer.parseInt(st.nextToken()));
            }
            sList.offer(stack);
        }

        // 값 초기화 끝
        for (int i = 1; i <= n; i++) {
            if (sList.isEmpty() || !findNum(i)) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");

    }

    static boolean findNum(int num) {
        Stack<Integer> s = sList.poll();
        if (s.peek() == num) {
            s.pop();
            if(!s.isEmpty()) {
                sList.offer(s);
            }
            return true;
        } else {
            return false;
        }
    }
}


/**
 * 시간초과코드
 * 시간초과 이유 : 2*10^5 * 2*10^5라면 20억번의 조회를하는데 1초의 제한시간을 넘길수없음
 */
//public class p23253 {
//
//    static List<Stack> sList = new ArrayList<Stack>();
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//
//        int mSize = 0;
//        for(int i = 0; i < m; i++){
//            mSize = Integer.parseInt(br.readLine());
//            Stack<Integer> stack = new Stack<Integer>();
//            st = new StringTokenizer(br.readLine());
//            for(int j = 0; j < mSize; j++) {
//                stack.push(Integer.parseInt(st.nextToken()));
//            }
//            sList.add(stack);
//        }
//
//        // 값 초기화 끝
//        for(int i = 1; i <= n; i++) {
//            if(!findNum(i)){
//                System.out.println("No");
//                return;
//            }
//        }
//
//        System.out.println("Yes");
//
//    }
//    static boolean findNum(int num){
//
//        for(Stack<Integer> s : sList){
//            if(s.peek() == num){
//                s.pop();
//                if(s.isEmpty()){
//                    sList.remove(s);
//                }
//                return true;
//            }
//        }
//
//        return false;
//    }
//}

