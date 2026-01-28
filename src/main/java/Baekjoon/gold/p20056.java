package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p20056 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<FireBall> list = new ArrayList<>();
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int weight = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());

            list.add(new FireBall(x, y, weight, speed, direction));

        }

        for(int i = 0; i < k; i++){
            list.forEach( fireBall -> {
                int[] dxDy = Direction.getDxDY(fireBall.direction);

                dxDy[0] *= fireBall.speed;
                dxDy[1] *= fireBall.speed;

                int dx = fireBall.x + dxDy[0];
                int dy = fireBall.y + dxDy[1];

                if(dx < 0){
                    dx = n+dx%n;
                } else {
                    dx = dx % n;
                }

                if(dy < 0){
                    dy = n+dy%n;
                } else {
                    dy = dy % n;
                }

                fireBall.move(dx, dy);
            });

            ArrayList<FireBall>[][] map = new ArrayList[n][n];
            for(int j = 0; j < n; j++){
                for(int g = 0; g < n; g++){
                    map[j][g] = new ArrayList<>();
                }
            }

            list.forEach( fireBall -> {
                fireBall.setToMap(map);
            });

            System.out.println();
        }

        int result = 0;
        for (FireBall fireBall : list) {
            result += fireBall.weight;
        }

        System.out.println(result);

    }

    private static class FireBall{

        int x;
        int y;
        int weight;
        int speed;
        int direction;


        public FireBall(int x, int y, int weight, int speed, int direction) {
            this.x = x;
            this.y = y;
            this.weight = weight;
            this.speed = speed;
            this.direction = direction;
        }

        public void move(int dx, int dy) {
            this.x = dx;
            this.y = dy;
        }

        public void setToMap(ArrayList<FireBall>[][] map) {
            map[this.x][this.y].add(this);
        }
    }

    private static class Direction{

        public static int[] getDxDY(int direction){
            switch (direction){
                case 0 :
                    return new int[]{-1, 0};
                case 1 :
                    return new int[]{-1, 1};
                case 2 :
                    return new int[]{0, 1};
                case 3 :
                    return new int[]{1, 1};
                case 4 :
                    return new int[]{1, 0};
                case 5 :
                    return new int[]{1, -1};
                case 6 :
                    return new int[]{0, -1};
                case 7 :
                    return new int[]{-1, -1};

            }
            throw new IllegalArgumentException("x");
        }

    }
}
