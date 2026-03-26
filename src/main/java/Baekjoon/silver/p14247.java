package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p14247 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] aH = new int[n];
        int[] aL = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            aH[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            aL[i] = Integer.parseInt(st.nextToken());
        }

        Comparator<Tree> pq = new Comparator<Tree>(){
            @Override
            public int compare(Tree o1, Tree o2) {
                return (o1.grow) - (o2.grow);
            }
        };

        List<Tree> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new Tree(aH[i], aL[i]));
        }

        list.sort(pq);

        long sum = 0;
        for(int i = 0; i < n; i++){
            Tree poll = list.get(i);
            sum += ((i * poll.grow) + poll.height);
        }

        System.out.println(sum);

    }

    private static class Tree{
        int height;
        int grow;

        public Tree(int height, int grow) {
            this.height = height;
            this.grow = grow;
        }
    }
}
