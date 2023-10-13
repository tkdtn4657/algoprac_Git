package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p1966 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<keyValueClass> keyValueClassQueue = new LinkedList<>();

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int n, targetIndex;
        for(int testCase = 0; testCase < t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            targetIndex = Integer.parseInt(st.nextToken());
            int[] a = new int[10];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int important = Integer.parseInt(st.nextToken());
                a[important]++;
                keyValueClass kv = new keyValueClass(important, i);
                keyValueClassQueue.offer(kv);
            }
            int count = 0;
            int index = a.length-1;
            while(index >= 1){
                while(a[index] >= 1){
                    keyValueClass kvc = keyValueClassQueue.poll();
                    if(kvc.getValue() == index){
                        a[index]--;
                        count++;
                        if(kvc.valueIndex == targetIndex){
                            sb.append(count).append("\n");
                            break;
                        }
                    }else{
                        keyValueClassQueue.offer(kvc);
                    }
                }
                if(a[index] == 0){
                    index--;
                }
            }
        }
        System.out.println(sb);
    }
    static class keyValueClass{
        private int value;
        private final int valueIndex;

        keyValueClass(int value, int valueIndex){
            this.value = value;
            this.valueIndex = valueIndex;
        }

        public int getValue() {
            return value;
        }

        public int getValueIndex() {
            return valueIndex;
        }
    }
}
