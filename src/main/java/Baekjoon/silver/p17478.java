package Baekjoon.silver;

import java.io.*;
import java.util.*;

class Main{
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int end = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        go(n, 0);

        bw.flush();
        bw.close();
    }

    static void go(int n, int depth) throws IOException{
        bw.write("____".repeat(depth)+"재귀함수가 뭔가요?\n");
        if(n != end){
            bw.write("____".repeat(depth)+"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
            bw.write("____".repeat(depth) + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
            bw.write("____".repeat(depth) + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
            go(n - 1, depth+1);
        }else{
            bw.write("____".repeat(depth)+"\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
        }
        bw.write("____".repeat(depth) + "라고 답변하였지.\n");
    }
}
//import java.util.*;
//import java.io.*;
//
//public class p17478 {
//    static StringBuilder sb = new StringBuilder("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
//    static int start = 0;
//    static int end = 0;
//
//    //static int depth = 0;
//    public static void main() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        start = n;
//        nappungyosu(n, 0);
//
//        System.out.println(sb);
//    }
//
//    static void nappungyosu(int n, int depth) {
//        sb.append("____".repeat(depth) + "\"재귀함수가 뭔가요?\"\n");
//        if (n != end) {
//            sb.append("____".repeat(depth) + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n" +
//                    "____".repeat(depth) + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n" +
//                    "____".repeat(depth) + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
//            nappungyosu(n - 1, depth + 1);
//        }
//
//        if (n == end) {
//            sb.append("____".repeat(depth) + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
//        }
//        sb.append("____".repeat(depth) + "라고 답변하였지.\n");
//    }
//}


//public class p17478 {
//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    static int start = 0;
//    static int end = 0;
//    //static int depth = 0;
//    public static void main() throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        start = n;
//        nappungyosu(n, 0);
//
//        bw.flush();
//        bw.close();
//        br.close();
//
//    }
//
//    static void nappungyosu(int n, int depth) throws IOException{
//        if(n == start) {
//            bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
//        }
//        bw.write("____".repeat(depth)+"\"재귀함수가 뭔가요?\"\n");
//        if(n != end) {
//            bw.write("____".repeat(depth) + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n" +
//                    "____".repeat(depth) + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n" +
//                    "____".repeat(depth) + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
//            nappungyosu(n - 1, depth+1);
//        }
//        if(n == end){
//            bw.write("____".repeat(depth)+"\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
//        }
//        bw.write("____".repeat(depth)+"라고 답변하였지.\n");
//    }
//}
