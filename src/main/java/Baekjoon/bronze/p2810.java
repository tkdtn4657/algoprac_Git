package Baekjoon.bronze;

import java.io.*;

public class p2810 {
    public static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        char[] cArray = br.readLine().toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            sb.append('*');
            if (cArray[i] == 'L') {
                sb.append(cArray[i]);
                i++;
                sb.append(cArray[i]);
            } else {
                sb.append(cArray[i]);
            }
        }
        sb.append('*');

        System.out.println(sb);

        int escapeCount = 0;
        int count = 0;
        while (sb.length() > 1) {
            if (sb.charAt(0) == '*') {
                escapeCount = 0;
                if (sb.charAt(1) == 'S') {
                    sb.delete(0, 2);
                    System.out.println(sb);
                    count++;
                } else if (sb.charAt(1) == 'L') {
                    sb.delete(0, 4);
                    System.out.println(sb);
                    count += 2;
                }
            }
            else{
                if(escapeCount == 3){
                    break;
                }
                sb.append(sb.charAt(0));
                sb.deleteCharAt(0);
                escapeCount++;

            }
        }
        System.out.print(count);
    }
}

//public class p2810 {
//    public static void main()throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        char[] cArray = br.readLine().toCharArray();
//
//        //*S*LL*S*
//        //*S*S*S*
//        //*S*LL*LL*S*S*LL*
//        //*S*LL*S*
//
//        StringBuilder sb = new StringBuilder();
//
//        int count = 0;
//        for(int i = 0; i < cArray.length; i++){
//            sb.append('*');
//            if(cArray[i] == 'L') {
//                sb.append(cArray[i]);
//                i++;
//                sb.append(cArray[i]);
//                count++;
//            }
//            else {
//                sb.append(cArray[i]);
//                count++;
//            }
//        }
//        sb.append('*');//여기가 문제
//        count++;
//
////        if(count > n){ // *S*S*S*
////            count = n;
////        }
//        System.out.println(sb.toString());
//        System.out.println(count);
//    }
//}
