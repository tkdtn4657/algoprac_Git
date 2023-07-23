package Baekjoon.gold;

import java.io.*;
import java.util.*;


public class p2023_2 {
    static int[] firstPrime = {2, 3, 5, 7};
    static int n;
    static ArrayList<Integer> magicPrime = new ArrayList<>();//신기한 소수를 담을 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        //4메가면 에토체가 가능한가?
        // 1000000 백만에 1M 4백만이면 끝나는데 안된다.
        //나중에 에토체로 구현되나만 체크해보면 재밌을듯

        //한자릿수는 배열을만들자 이걸 가지고 시작
        //이걸로 조합을 다하면 그건 브루트포스아닌가?
        //그래서 DFS느낌으로 가는건가?

        //슈도흐름을 생각해보자.
        //1. 한자릿수 prime등록 이후는 전부됨......
        //2. 두번째부터 그 수를 붙여서 prime인지 확인 (n을 입력받은 중단점까지)
        //2_1. DFS를 활용, String에 붙여서 다음 DFS로 이동
        //2_2. 백트래킹도 무조건 넣어야할듯? 한 Depth에서 같은 소수를 여러번 반복해야함
        //3. 중단점을 찾았으면 그 수를 리스트에 추가
        //4. 리스트에 추가된거 출력!

        for (int i = 0; i < firstPrime.length; i++) {
            dfs(String.valueOf(firstPrime[i]), 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < magicPrime.size(); i++) {
            if(i == magicPrime.size()-1){
                sb.append(magicPrime.get(i));
            }else {
                sb.append(magicPrime.get(i) + "\n");
            }
        }
        System.out.print(sb);

    }

    static void dfs(String s, int count) {
        if (count == n && isPrime(Integer.valueOf(s))) {//중단점
            magicPrime.add(Integer.valueOf(s));
        }
        if (isPrime(Integer.valueOf(s))) {
            for (int i = 1; i < 10; i += 2) {
                    dfs(s.concat(String.valueOf(i)), count + 1);
            }
        }
    }

    static boolean isPrime(int isPrimeNum) {
        for (int i = 2; i <= (int) Math.sqrt(isPrimeNum); i++) {
            if (isPrimeNum % i == 0) {
                return false;
            }
        }
        return true;
    }
}
