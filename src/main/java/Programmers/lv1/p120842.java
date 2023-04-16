package Programmers.lv1;

public class p120842 {
    public int[][] solution(int[] num_list, int n) {

        int[] size = new int[2];

        size[0] = n;
        size[1] = num_list.length/n;

        int[][] answer = new int[size[1]][size[0]];

        int numCount = 0;

        for(int i = 0 ; i < size[1]; i++){
            for(int j = 0; j < size[0]; j++){
                answer[i][j] = num_list[numCount++];
            }
        }
        return answer;
    }
}
