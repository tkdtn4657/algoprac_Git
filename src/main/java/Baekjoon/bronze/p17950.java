package Baekjoon.bronze;


import java.math.BigInteger;
import java.util.*;
import java.io.*;


//public class p17950 {
//    static long x;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        long h = Long.parseLong(st.nextToken()); // 4
//        x = Long.parseLong(st.nextToken()); // 5
//
//        long result = 0;
//        long n;
//
//        for(int i = 0; i < h;i++){
//
//        }
//
//    }
//}
public class p17950 {
    static long x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long h = Long.parseLong(st.nextToken()); // 4
        x = Long.parseLong(st.nextToken()); // 5

        long result = 0;
        long n;
        long pow = 1;
        for (long i = 1; i <= h; i++) {
            n = Long.parseLong(br.readLine()); // 1, 3, 2, 4
            pow = (pow * x) % 1000000007; // pow 25
            result = (result + (pow * n) % 1000000007) % 1000000007; // 75
        }

        System.out.println(result);
    }
}

//import java.util.*;
//import java.io.*;
//
//public class p17950 {
//    public static void main() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        long h = Long.parseLong(st.nextToken());
//        long x = Long.parseLong(st.nextToken());
//
//        long result = 0;
//        long n;
//        long temp = 1;
//        for (long i = 1; i <= h; i++) {
//            n = Long.parseLong(br.readLine());
//            temp = (long)Math.pow((long) x, i) % 1000000007;
//            temp = (temp * n) % 1000000007;
//            result = (result + temp) % 1000000007;
//        }
//        System.out.println(result);
//    }
//}
