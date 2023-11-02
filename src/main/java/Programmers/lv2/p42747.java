package Programmers.lv2;

import java.util.Arrays;
import java.util.Comparator;

public class p42747 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{0, 0, 0, 0, 0}));
    }

    public static int solution(int[] citations) {

        Integer[] a = Arrays.stream(citations).boxed().toArray(Integer[]::new);

        Arrays.sort(a, new Comparator<Integer>(){
                    @Override
                    public int compare(Integer o1, Integer o2){
                        return o2 - o1;
                    }
                }
        );


        //6, 5, 3, 1, 0
        // for(int num : a){
        for(int j = a[0]; j >= 0; j--){
            for(int i = 0; i < a.length; i++){
                if(a[i] < j){
                    if(i >= j){
                        if(a.length-i <= j) {
                            return j;
                        }
                    }
                    break;
                }else if(i == a.length-1){
                    if(a[i] >= j){
                        if(a[i] > 1){
                            return a.length;
                        }else {
                            return 0;
                        }
                    }
                }
            }
        }

        return a.length;

    }
}
