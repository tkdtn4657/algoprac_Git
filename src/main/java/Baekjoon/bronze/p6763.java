package Baekjoon.bronze;

import java.io.*;

public class p6763 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int b = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());
        int number = a - b;
        if (number<=0) {
            System.out.println("Congratulations, you are within the speed limit!");
            return;
        }
        System.out.printf("You are speeding and your fine is $%d.", check(number));
    }

    private static int check(int gap) {
        if (gap <= 0)
            return 0;
        if (gap <= 20)
            return 100;
        if (gap <= 30)
            return 270;
        return 500;
    }
}
