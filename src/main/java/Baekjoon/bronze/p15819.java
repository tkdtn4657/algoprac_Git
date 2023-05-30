package Baekjoon.bronze;


import java.util.*;
import java.io.*;


public class p15819 {
    public static void main() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int rank = Integer.parseInt(st.nextToken());

        String[] as = new String[k];

        for(int i = 0; i < k; i++){
            as[i] = br.readLine();
        }

        Arrays.sort(as);

        System.out.println(as[rank-1]);

    }

}

//import java.util.*;
//import java.io.*;
//
//
//public class p15819 {
//    public static void main() throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int k = Integer.parseInt(st.nextToken());
//        int rank = Integer.parseInt(st.nextToken());
//
//        String[] as = new String[k];
//
//        for(int i = 0; i < k; i++){
//            as[i] = br.readLine();
//        }
//
//        //Arrays.sort(as);
//        mergeSort(as, 0, as.length);
//
//        System.out.println(as[rank-1]);
//
//    }
//
//    static void mergeSort(String[] as, int a, int b){//병합정렬
//        if(a < b){
//            int center = (a+b)/2;
//            mergeSort(as, 0, center);
//            mergeSort(as, center+1, b);
//            merge(as, a, center, b);
//
//
//        }
//    }
//
//    static void merge(String[] as, int a, int center, int b){
//        int i = a;
//        int j = center + 1;
//        int t = 1;
//        String[] tmp = new String[as.length];
//
//
//        while(i <= center && j <= b){
//            if(as[i].charAt(0) <= as[j].charAt(0)){
//                tmp[t++] = as[i++];
//            }
//            else {
//                tmp[t++] = as[j++];
//            }
//
//        }
//        while(i <= center){
//            tmp[t++] = as[i++];
//        }
//        while(j <= b){
//            tmp[t++] = as[j++];
//        }
//        i = b; t = 1;
//        while(i <= b){
//            as[i++] = tmp[t++];
//        }
//    }
//
//
//}
