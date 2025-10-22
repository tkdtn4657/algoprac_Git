package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p13335 {
    static int n, w, l;
    static int timeCount = 0;
    static int sumWeight;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken()); // 길이
        l = Integer.parseInt(st.nextToken()); // 하중

        Queue<Integer> queue = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            queue.add(Integer.parseInt(st.nextToken()));
        }

        int[] bridge = new int[w];
        //bridge 배열 기준으로 1칸씩 시뮬레이션 진행
        while(!isBridgeEmpty(bridge) || !queue.isEmpty()){
            if (!queue.isEmpty()) {
                int truck = queue.peek();
                //트럭이 진입되면 poll 진행 false 반환
                if (sumWeight - bridge[bridge.length - 1] + truck > l) {
                    truck = 0;
                }
                if (goBridge(bridge, truck)) {
                    queue.poll();
                }
            } else {
                goBridge(bridge, 0);
            }

        }

        System.out.println(timeCount);

    }

    private static boolean goBridge(int[] bridge, int truck){
        timeCount++;
        for(int i = bridge.length-1; i > 0; i--){
            bridge[i] = bridge[i-1];
        }

        bridge[0] = truck;

        return truck != 0;
    }

    //브릿지가 존재하면 현재 무게 반환
    private static boolean isBridgeEmpty(int[] bridge) {
        sumWeight = 0;
        for(int i = 0; i < w; i++){
            if(bridge[i] != 0){
                sumWeight += bridge[i];
            }
        }
        if(sumWeight == 0){
            return true;
        } else {
            return false;
        }
    }
}
