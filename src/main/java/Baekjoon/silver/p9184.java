package Baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 첫 dp시도로는 -50 < a,b,c < 50의 범위이기에 각 범위에 맞는 dp배열인 dp[101][101][101]
 * 을 만들려고 했었지만, 해당 문제의 의도가 아니였다고 판단한게 메모리가 128mb제한으로 다른 문제보다 더 적은 편이였다.
 * 때문에 다른 방법을 생각했었고, 20 초과일 때와 0이하일때는 반환되는 조건이 있기 때문에
 * 0~20의 인덱스 범위를 가진 3차원배열을 선언해서 각 a, b, c의 경우의 수에 대해 저장해주면 된다고 생각했다.
 * dp의 아이디어로 dp 배열에는 각 a,b,c의 값을 사용할 때 어떤 값이 나오는지,
 * 최초 계산값을 메모리제이션을 통해 dp배열에 저장한다.
 * 이후 출력하면 된다.
 *
 * 다른 방식으로는 dp배열을 아예 먼저 채워두는 방식도 있는 듯 하다
 * 이후 복습할 때는 해당 방법으로 풀어보면 될듯?
 */
public class p9184 {

    static int dp[][][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = 0;
        int b = 0;
        int c = 0;
        StringTokenizer st;
        //마이너스의 범위니까.... 음................... +50할까?//2차원배열인가..?3xn?
        dp = new int[21][21][21];
//        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 20; j++) {
                for (int k = 0; k <= 20; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        dp[0][0][0] = 1;

        //dp초기화해줄게 뭐가 있을까? 3차원 배열에 대한 0이 하나라도 들어가있는거!
        //0 이하가 하나라도 있으면 무조건 1리턴이니까
        //50이하는 전부 1로
        //이만큼 할필요없이, 0이하면 1로바뀌게하는거니까 for문을 덜 돌리는게 나을거같다?
//        for(int i = 0; i <= 50; i++){
//            for(int j = 0; j <=50; j++){
//                for(int k = 0; k <= 50; k++){
//                    dp[i][j][k] = 1;
//                }
//            }
//        }
        //조금 더 생각하면 메모리적으로도 더 아낄 수 있을 것 같음.(dp배열 21개정도만?)


        StringBuilder sb = new StringBuilder();
        while (a != -1 || b != -1 || c != -1) {
            st = new StringTokenizer(br.readLine());
            //a, b, c 투입
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            //"w(" 등 newString("") 연산을 줄여 더 빠르게 할 수는 있을 것 같지만 가독성이 너무 떨어질 것이 우려되어
            //이 상태로 마무리
            sb.append("w(")
                    .append(a).append(", ")
                    .append(b).append(", ")
                    .append(c).append(") = ")
                    .append(w(a, b, c)).append("\n");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }

    static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return dp[0][0][0];
        } else if (a > 20 || b > 20 || c > 20) {
            return dp[20][20][20] = w(20, 20, 20);
        } else if (dp[a][b][c] != Integer.MAX_VALUE) {//해당값이 아니면.... 리턴!
            return dp[a][b][c];
        }else if(a < b && b < c){
            return dp[a][b][c] = w(a,b,c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        } else {
            //값은 없는데 초기화 안됐다면 otherwise해주기
            return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }
    }
}
