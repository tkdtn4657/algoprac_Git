package Programmers.lv0;


public class p120886 {
    public int solution(String before, String after) {
        int answer = 0;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for(int i = 0; i < before.length(); i++){
            count1[(int)before.charAt(i) - 97]++;

        }

        for(int i = 0; i < after.length(); i++){
            count2[(int)after.charAt(i) - 97]++;
        }

        if(equalArray(count1, count2)){
            return 1;
        }

        return 0;
    }

    boolean equalArray(int[] a, int[] b){
        for(int i = 0; i < a.length; i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }
}
