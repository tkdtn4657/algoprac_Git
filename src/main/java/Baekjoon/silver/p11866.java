package Baekjoon.silver;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p11866 {
    public static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder("<");

        ArrayList<Integer> ll = new ArrayList<>();

        for (int i = 1; i < n + 1; i++) {
            ll.add(i);
        }

        int index = k - 1;
        while (ll.size() > 0) {
            if (ll.size() == 1) {
                sb.append(ll.get(0));
                break;
            }
            sb.append(ll.get(index) + ", ");
            ll.remove(index);
            if (ll.size() != 0) {
                index = (index + k - 1) % (ll.size());
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}
