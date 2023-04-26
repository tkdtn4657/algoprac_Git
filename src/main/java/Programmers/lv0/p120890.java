package Programmers.lv0;

public class p120890 {

    public int solution(int[] array, int n) {
        int answer = 0;
        int judgeNumber = n - array[0];
        if(judgeNumber < 0) judgeNumber *= -1;
        answer = array[0];
        for(int i = 1; i < array.length; i++){
            if(judgeNumber > n-array[i]){
                //if(judgeNumber )
                judgeNumber = n-array[i];
                answer = array[i];
            }
        }
        return answer;
    }
}
