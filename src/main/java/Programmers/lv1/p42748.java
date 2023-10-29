package Programmers.lv1;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class p42748 {
    static int[] needSortArray;
    static int[] tmp = new int[101];

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        Arrays.toString(solution(array, commands));

    }

        static public int[] solution(int[] array, int[][] commands) {
            List<Integer> answer = new ArrayList<>();

            for(int[] numbers : commands){
                //자른 배열의 정렬값에서 k번째 수(numbers[2]) add
                answer.add(divide_sort(Arrays.copyOfRange(array, numbers[0]-1, numbers[1]))[numbers[2]-1]);
            }

            return answer.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
        }

        /**
         * comannds 에서의 2 -> 5 : 1index -> 4index 범위
         */
        static int[] divide_sort(int[] divideArray){
            needSortArray = divideArray;
            merge_sort(0, needSortArray.length-1);

            return needSortArray;
        }

        static void merge_sort(int start, int end){
            if(start < end){
                int center = (start+end) / 2;
                merge_sort(start, center);
                merge_sort(center+1, end);
                merge(start, center, end);
            }
        }

        //needSortArray
        static void merge(int start, int center, int end){
            int i = start;
            int j = center+1;
            int t = 0;
            while(i <= center && j <= end){
                if(needSortArray[i] <= needSortArray[j]){
                    tmp[t] = needSortArray[i];
                    i++;
                    t++;
                }
                if(needSortArray[i] >= needSortArray[j]){
                    tmp[t] = needSortArray[j];
                    j++;
                    t++;
                }
            }
            while(i <= center){
                tmp[t] = needSortArray[i];
                i++;
                t++;
            }
            while(j <= end){
                tmp[t] = needSortArray[j];
                j++;
                t++;
            }

            int index = start;
            t = 0;
            while(index <= end){
                needSortArray[index] = tmp[t];
                index++;
                t++;
            }
        }
}
