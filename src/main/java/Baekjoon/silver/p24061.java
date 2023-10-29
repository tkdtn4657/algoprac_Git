package Baekjoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class p24061 {

    static int[] a;
    static int count = 0;
    static int k = 0;
    static int[] tmp;
    static boolean check = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        a = new int[n];
        tmp = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(0, a.length - 1);

        if (!check) {
            System.out.print(-1);
        }
    }

    static void merge_sort(int start, int end) {
        if (start < end && !check) {
            int center = (start + end) / 2;
            merge_sort(start, center);
            merge_sort(center + 1, end);
            merge(start, center, end);
        }
    }

    static void merge(int p, int q, int r) {
        if (!check) {
            int i = p;
            int j = q + 1;
            int t = 0;
            while (i <= q && j <= r) {
                if (a[i] <= a[j]) {
                    tmp[t] = a[i];
                    i++;
                    t++;
                } else {
                    tmp[t] = a[j];
                    j++;
                    t++;
                }
            }

            while (i <= q) {
                tmp[t] = a[i];
                i++;
                t++;
            }

            while (j <= r) {
                tmp[t] = a[j];
                j++;
                t++;
            }

            i = p;
            t = 0;

            while (i <= r) {
                a[i] = tmp[t];
                i++;
                t++;
                count++;
                if (count == k) {
                    sout();
                }
            }
        }
    }

    static void sout() {
        check = true;
        StringBuilder sb = new StringBuilder();
        for (int num : a) {
            sb.append(num + " ");
        }
        System.out.println(sb);
    }
}
