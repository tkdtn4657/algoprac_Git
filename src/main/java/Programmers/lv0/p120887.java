package Programmers.lv0;

public class p120887 {
    public int solution(int i, int j, int k) {
        int answer = 0;

        for(int start = i; start <= j; start++){
            answer += comp(Integer.toString(start), k);
        }

        return answer;
    }

    int comp(String s, int k){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(Integer.parseInt(String.valueOf(s.charAt(i))) == k){
                count++;
            }
        }
        return count;
    }
}