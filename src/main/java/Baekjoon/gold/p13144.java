package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p13144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        boolean[] check = new boolean[100001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        /**
         * 1. start = 0, end = 0으로 초기화합니다.
         * 2. start를 n까지 for문 순회합니다.
         * 3. start값부터 시작하여 처음 같은 숫자가 나올 때까지 end를 증가시킵니다.
         * 4. end가 더 이상 진전할 수 없다면, end - start를 결괏값에 더해줍니다.
         * 5. 만약에 1, 2, 3, 4, 5라는 수열이라면, start가 0일 때 end는 5까지 진행됩니다.
         * 6. 따라서 1, 12, 123, 1234, 12345의 5개의 수열이 생성될 수 있기 때문에 end - start를 더해줍니다.
         * 7. 현재 start값에 대한 모든 판단이 끝났다면, start값에 대한 방문처리를 해제해줍니다.
         * 8. 다음 start값에 대해 3~5 반복
         */
        int left = 0;
        int right = 0;
        int sum = 0;
        //1, 12, 123, 1234, 12345 | 2345, 234, 23, 2 | 3, 34, 345 | 45, 4 | 5
        while (left < n) {
            while (right < n) {
                if(check[a[right]]){
                    break;
                }
                check[a[right]] = true;
                right++;
            }

            sum += right - left;

            check[a[left]] = false;
            left++;
        }

        System.out.println(sum);
    }


    // 망한코드 -> 메모리초과 char로 각 위치 탐색해서 그럴듯?
//    static int[] a;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        a = new int[n];
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//            a[i] = Integer.parseInt(st.nextToken());
//        }
//
//        //5
//        //1 2 3 4 5
//        //1, 2, 3, 4, 5
//        //12, 23, 34, 45
//        //123, 234, 345
//        //1234, 2345
//        //12345
//        //1, 12, 123, 1234, 12345, 2345, 234, 23, 2, 3, 345, 34, 4, 45, 5
//
//        //1, 12, 123, 1234, 12345 | 2345, 234, 23, 2 | 3, 34, 345 | 45, 4 | 5
//
//
//        Set<Integer> set = new HashSet<>();
//
//        int left = 0;
//        int right = 0;
//        boolean flag = false;
//        StringBuilder sb = new StringBuilder();
//        set.add(Integer.valueOf(sb.append(a[left]).toString()));
//        while (right < n && left < n) {
//            if (!flag) {
//                if (right == n - 1) {
//                    left++;
//                    sb.deleteCharAt(0);
//                    if (!sb.toString().equals("")) {
//                        set.add(Integer.valueOf(sb.toString()));
//                    }
//                    flag = true;
//                    continue;
//                }
//                right++;
//                if (!sb.toString().equals("")) {
//                    set.add(Integer.valueOf(sb.append(a[right]).toString()));
//                }
//                continue;
//            } else {
//                if (right == left) {
//                    flag = false;
//                    left++;
//                    right++;
//                    sb.deleteCharAt(0);
//                    if (!sb.toString().equals("")) {
//                        set.add(Integer.valueOf(sb.append(a[right]).toString()));
//                    }
//                    continue;
//                }
//                right--;
//                sb.deleteCharAt(sb.length() - 1);
//                if (!sb.toString().equals("")) {
//                    set.add(Integer.valueOf(sb.toString()));
//                }
//                continue;
//            }
//        }
////        set.remove("");
//        System.out.println(set.size());
//    }
}
