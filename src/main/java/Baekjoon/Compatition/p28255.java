package Baekjoon.Compatition;

import java.io.*;


public class p28255 {//초콜릿컵2회ss
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] s = new String[n];

        for(int i = 0; i < n; i++){
            s[i] = br.readLine();
        }

        for(int i = 0; i < n; i++){
            if(!thirdFloor(s[i])){
                System.out.println(0);
            }
        }
    }

    static boolean thirdFloor(String s){
        int subStringLength = s.length()/3;
        StringBuilder sb = new StringBuilder();
        while(s.length() > subStringLength){
            sb.append(s.substring(0, subStringLength));
            if(case1(s, sb)) {
                System.out.println(1);
                return true;
            }
            else if(case2(s, sb)) {
                System.out.println(1);
                return true;
            }
            else if(case3(s, sb)) {
                System.out.println(1);
                return true;
            }
            else if(case4(s, sb)) {
                System.out.println(1);
                return true;
            }
            sb.setLength(0);
            subStringLength++;
        }
        return false;
    }

    static boolean case1(String s, StringBuilder sub){
        StringBuilder sb = new StringBuilder(sub);
        StringBuilder temp = new StringBuilder(sub.toString());
        sb.append(temp.reverse()).append(sub);
        if(s.equals(sb.toString())){
            return true;
        }else{
            return false;
        }
    }
    static boolean case2(String s, StringBuilder sub){
        StringBuilder sb = new StringBuilder(sub);
        StringBuilder temp = new StringBuilder(sub.toString());
        sb.append(temp.reverse().substring(1, temp.length())).append(sub);
        if(s.equals(sb.toString())){
            return true;
        }else{
            return false;
        }
    }
    static boolean case3(String s, StringBuilder sub){
        StringBuilder sb = new StringBuilder(sub);
        StringBuilder temp = new StringBuilder(sub.toString());
        sb.append(temp.reverse()).append(sub.substring(1, sub.length()));
        if(s.equals(sb.toString())){
            return true;
        }else{
            return false;
        }
    }
    static boolean case4(String s, StringBuilder sub){
        StringBuilder temp = new StringBuilder(sub.toString());
        StringBuilder sb = new StringBuilder(sub);
        sb.append(temp.reverse().substring(1, temp.length())).append(sub.substring(1, sub.length()));
        if(s.equals(sb.toString())){
            return true;
        }else{
            return false;
        }
    }
}
