package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p14658 {
    static ArrayList<int[]> coordinate;
    static int n;
    static int m;
    static int l;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 구역 가로
        m = Integer.parseInt(st.nextToken()); // 구역 세로
        l = Integer.parseInt(st.nextToken()); // 정사각형 트램펄린 한변의 길이
        k = Integer.parseInt(st.nextToken()); // 별똥별 갯수

        coordinate = new ArrayList<>(k);

        /**
         * 기본 예제
         * 12 10 4 7
         * 2 4
         * 7 3
         * 3 1
         * 5 6
         * 4 7
         * 12 10
         * 8 6
         */

        /**
         *
         원래는 배열을 한칸 더 늘리는게 가장 직관적이긴 할테지만,
         알고리즘적으로 생각하면 해당 문제의 배열은 자체만으로도 상당히 크기 때문에 범위를 더 늘리고 싶지 않았다.
         이러한 이유로 배열이 아닌 좌표를 입력받을 때 -1을 통해서 저장할 예정이다.
         원래는 점을 기준으로 정말 모든 부분을 전체탐색하는게 맞지않나 싶은데,
         전체탐색 방식을 좌표를 기준으로 +-해서 검색하는 것이 더 효율적이란 생각이 들어서 해당 방식으로 접근 해볼 것 같다.
         */
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            coordinate.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

//        int max = 0;

        searchNearbyStar();
//        for (int[] starFall : coordinate) {//별똥별의 갯수만큼 전체 좌표 탐색
//            max = Integer.max(searchNearbyStar(starFall[0], starFall[1], l), max);
//        }

//        System.out.println(max);
    }

//    static int searchNearbyStar() {//본인 포함 근처에 있는 별똥별의 갯수를 리턴
//        int count = 0;
//        int[] nowArray = {};
//
//        for (int[] starFallCoordinate : coordinate) {
//            count = slidingRectangle(starFallCoordinate[0], starFallCoordinate[1]);
//        }
//
//        return count;
//    }
//
//    static int slidingRectangle(int x, int y) {
//        //기준점 기준으로 전체탐색
//
//        return 0;
//    }
//}

    //브루트포스인데 전체탐색 해봐? 역시 이건 안된다 ㅋㅋㅋ
    static void searchNearbyStar(){
        int count = 0;
        int x;
        int y;
        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                count = 0;
                x = i + l;
                y = j + l;
                for (int[] starFall : coordinate) { // count : 트램펄린이 튕겨낸 별똥별
                    if (starFall[0] >= i && starFall[0] <= x && starFall[1] >= j && starFall[1] <= y) {
                        count++;
                    }
                }
                max = Integer.max(count, max);
            }
        }
        System.out.println(k - max); // k-max를 해야 트램펄린이 팅겨내지못한 별똥별
    }
}


