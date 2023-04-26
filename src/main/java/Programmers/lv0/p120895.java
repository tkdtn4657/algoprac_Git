package Programmers.lv0;

public class p120895 {//  char[] ch = my_string.toCharArray(); 활용도 좋았을듯?
    public String solution(String my_string, int num1, int num2) {

        char[] c  = new char[2];
        c[0] = my_string.charAt(num1);
        c[1] = my_string.charAt(num2);

        char[] string = new char[my_string.length()];

        for(int i = 0; i < my_string.length(); i++){
            if(i == num1){
                string[i] = c[1];
            }else if(i == num2){
                string[i] = c[0];
            }
            else{
                string[i] = my_string.charAt(i);
            }
        }
        return new String(string);
    }
}
