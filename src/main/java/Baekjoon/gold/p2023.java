package Baekjoon.gold;

import java.util.Scanner;

public class p2023 {
    static int n;
    public void main() {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        //1의자리 소수는 2, 3, 5, 7
        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);

    }

    static void DFS(int number, int jari){
        if(n == jari){ // 재귀종료시점
            if(isPrime(number)){
                System.out.println(number);
            }
            return;
        }

        for(int i = 0; i < 10; i++) {
            if( i % 2 == 0){
                continue;
            }
            if (isPrime(number * 10 + i)) {
                DFS(number * 10 + i, jari + 1);
            }
        }
    }

    static boolean isPrime(int number){
        for(int i = 2; i < number; i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}
