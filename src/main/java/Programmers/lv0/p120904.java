package Programmers.lv0;

public class p120904 {
    public int solution(int num, int k) {
        int answer = 0;
        String s = Integer.toString(num);

        for(int i = 0; i < s.length(); i++){
            if(Character.getNumericValue(s.charAt(i)) == k){
                return i+1;
            }
        }

        return -1;
    }
}
