package Baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//dp풀이 참고링크 https://small-stap.tistory.com/8
//아직 dp개념이 부족해서 형태를 익히고 싶다
public class p9655_dp {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] dp = new boolean[n+1];//1부터 시작하기 때문에
        //상근이가 이기면 false, 창영이가 이기면 true
        //0은 필요가 없고,
        //1은 상근이가 이기니까 false기본이면 안건드려도 돼
        if(n == 1){
            System.out.println("SK");
            return;
        }
        dp[2] = true;//그냥 이기고지고 반복이니까 그 전에 이긴애를 기준으로 판단
        for(int i = 3; i <= n; i++){
            dp[i] = !dp[i-1];
        }

        if(dp[n]) { //true면 창영이
            System.out.println("CY");
        }
        else{
            System.out.println("SK");
        }

    }
}
