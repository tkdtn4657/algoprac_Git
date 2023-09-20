package Baekjoon.silver;

import java.io.*;
import java.util.*;


/**
 * dp유형을 집어서 시작한 문제
 * p11057 오르막 수
 * 이번엔 큰 틀에서 본건 아니고
 * 작은 조각에서 체크를 했음(bottom-Up)
 *
 * dp에 들어갈 값 dp[n][h]
 * 각 자리의 수 n
 * n의 자리에 위치한 첫번째값인 h | ex)13579일 때 1
 *
 * 부녀회장문제와 동일하게 생각하면 되는데, 먼저 값을 초기화해줄 것들을 찾음
 * 이 문제에서 초기화해줄 수 있는 조건은 두가지
 *  1. 9일때 모든 자릿수의 끝값의 경우의 수가 1로 고정된다. 9, 99, 999, 9999, 99999 등등 때문에 끝값을 고정,
 *  2. n이 1일 때 1의 자릿수의 경우의수는 모두 1개 ex) 0, 1, 2, 3, 4, 5, 6 등등 1개
 *
 *  이 초기화 값을 가지고 나머지 dp배열을 채워나가면 되는데 오르막 수의 특성상
 *  이전 자릿수첫 값(h)이 9일때는 1개, 8일때는 88, 89 2개 ... 형식으로 늘어나고
 *  같은 자릿수 값에 있는 경우의 수는 h+1의 값을 앞에 저장하면 된다
 *  되는 이유 : 오르막수의 조건에 따라 더 높은 수의 경우의 수를 다 가져올 수 있기 때문
 *  해당 두 조건을 가지고 dp배열의 점화식을 만들면
 *
 *  dp[i][j] = dp[i-1][j] + dp[i][j+1];
 *  식을 통해 해결
 *
 */

public class p11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 1; i <= n; i++) { // 아랫자리의 9의 경우의 수에 하나가 더 생김
            dp[i][9] = 1;
        }

        for(int i = 1; i <= n; i++) {
            for (int j = 8; j >= 0; j--) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j + 1]) % 10007;
            }
        }

        long result = 0;
        for(long num : dp[n]){
            result = (result + num) % 10007;
        }
        System.out.println(result);

    }
}
