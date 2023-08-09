package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p11004 {
    static int[] a;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(a, 0, n-1, k-1);
        //출력


        System.out.println(a[k-1]);

    }

    static void quickSort(int[] a, int start, int end, int k){
        if(start < end){
            int pivot = partition(a, start, end);
            if(pivot == k){
                return;
            }else if(k < pivot){
                quickSort(a, start, pivot -1, k);
            }else{
                quickSort(a, pivot + 1, end, k);
            }
        }
    }

    static int partition(int[] a, int start, int end){
        if(start + 1 == end){
            if(a[start] > a[end]) swap(a, start, end);
            return end;
        }
        int middle = (start + end) / 2;
        swap(a, start, middle);
        int pivot = a[start];
        int i = start + 1;
        int j = end;
        while(i <= j){
            while (pivot < a[j] && j > 0){
                j--;
            }
            while(pivot > a[i] && i < a.length-1){
                i++;
            }
            if(i <= j){
                swap(a, i++, j--);
            }
        }
        a[start] = a[j];
        a[j] = pivot;
        return j;
    }

    static void swap(int[] a, int start, int end){
        int temp = a[start];
        a[start] = a[end];
        a[end] = temp;
    }
}
