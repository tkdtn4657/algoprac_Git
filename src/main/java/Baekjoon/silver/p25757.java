package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        char gameMode = st.nextToken().charAt(0);

        Set<String> gameSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            gameSet.add(br.readLine());
        }

        switch (gameMode) {
            case 'Y':
                System.out.println(gameSet.size());
                break;
            case 'F':
                System.out.println(gameSet.size() / 2);
                break;
            case 'O':
                System.out.println(gameSet.size()/ 3);
                break;

        }
    }
}
