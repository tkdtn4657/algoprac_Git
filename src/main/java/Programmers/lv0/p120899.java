package Programmers.lv0;

public class p120899 {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        answer[0] = array[0];
        for(int i = 1; i < array.length; i++){
            if(array[i] > answer[0]){
                answer[0] = array[i];
                answer[1] = i;
            }
        }

        return answer;
    }
}
