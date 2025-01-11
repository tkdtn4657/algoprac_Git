package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p2304 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0; i <= 1000; i++){
            list.add(i, new ArrayList<>());
        }

        int maxHeight = 0;
        int maxHeightX = 0;

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if(maxHeight < h){
                maxHeight = h;
                maxHeightX = l;
            }

            list.get(l).add(h);
        }

        //올라갈 때는 기존의 숫자를 입력하거나 높은 숫자를 더해,
        final IntStorage leftIntVal = new IntStorage();
        final IntStorage rightIntVal = new IntStorage();

        boolean inRangeFlag = false;
        for(int i = 0; i < maxHeightX; i++){
            if(!inRangeFlag && list.get(i).isEmpty()){
                continue;
            }

            inRangeFlag = true;

            if(list.get(i).isEmpty()){
                leftIntVal.sum(leftIntVal.number);
            }else {
                list.get(i).forEach(each -> {
                    leftIntVal.sum(Integer.max(each, leftIntVal.number));
                });
            }
        }

        inRangeFlag = false;
        for(int i = list.size()-1; i >= maxHeightX; i--){
            if(!inRangeFlag && list.get(i).isEmpty()){
                continue;
            }

            inRangeFlag = true;
            if(list.get(i).isEmpty()){
                rightIntVal.sum(rightIntVal.number);
            }else {
                list.get(i).forEach(each -> {
                    rightIntVal.sum(Integer.max(each, rightIntVal.number));
                });
            }
        }

        System.out.println(leftIntVal.getSum() + rightIntVal.getSum());


    }

    private static class IntStorage {
        int number = 0;
        int sum = 0;
        public void sum(int number){
            this.sum += number;
            this.number = number;
        }

        public int getNumber(){
            return number;
        }

        public int getSum(){
            return sum;
        }
    }
}
