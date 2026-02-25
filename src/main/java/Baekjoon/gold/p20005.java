package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p20005 {

    static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1000 * 1000의 배열에서 전리품을 가져갈 수 있는 케이스 확인인데
        //최초에 Boss 기준으로 플레이어의 거리를 BFS로 모두 계산
        //플레이어의 정보를 배열에 저장해두기
        //플레이어 최초 도착 시점부터 보스를 치기 시작
        //시뮬레이션으로 구현하면 될듯
        //최종적으로 보스가 죽은 시점에 종료시키고 플레이어가 한대라도 쳤다면 카운트

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int bossHP = 0;

        Integer[] bossXy = new Integer[2];
        char[][] map = new char[m][n];
        Map<Character, Player> playerMap = new HashMap<>();
        for(int i = 0; i < m; i++){
            String inputLine = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = inputLine.charAt(j);

                if(map[i][j] == 'B'){
                    bossXy[0] = i;
                    bossXy[1] = j;
                }

                if(map[i][j] != 'B' && map[i][j] != 'X' && map[i][j] != '.'){
                    Player player = new Player(map[i][j], false);
                    playerMap.put(map[i][j], player);
                }
            }
        }

        for(int i = 0; i < p; i++){
            st = new StringTokenizer(br.readLine());
            char id = st.nextToken().charAt(0);
            int dps = Integer.parseInt(st.nextToken());

            playerMap.get(id).setDps(dps);
        }

        bossHP = Integer.parseInt(br.readLine());

        boolean[][] visited = new boolean[m][n];
        Queue<Integer[]> queue = new ArrayDeque<>();
        queue.add(new Integer[]{bossXy[0], bossXy[1], 0});
        visited[bossXy[0]][bossXy[1]] = true;

        while(!queue.isEmpty()){
            Integer[] nowXy = queue.poll();

            for(int[] move : moves){
                int dx = nowXy[0] + move[0];
                int dy = nowXy[1] + move[1];

                if(dx < 0 || dy < 0 || dx >= m || dy >= n || visited[dx][dy] || map[dx][dy] == 'X') continue;

                visited[dx][dy] = true;
                queue.add(new Integer[]{dx, dy, nowXy[2]+1});
                if(map[dx][dy] != 'B' && map[dx][dy] != 'X' && map[dx][dy] != '.'){
                    int distance = nowXy[2];
                    playerMap.get(map[dx][dy]).setBossDistance(distance);
                }

            }
        }

        PriorityQueue<Player> playerPriorityQueue = new PriorityQueue<>((o1, o2) -> {
            return o1.bossDistance - o2.bossDistance;
        });

        for(Character ID : playerMap.keySet()){
            playerPriorityQueue.add(playerMap.get(ID));
        }

        Player firstPlayer = playerPriorityQueue.poll();
        int totalDps = firstPlayer.dps;
        firstPlayer.bossAttackFlag = true;
        int time = firstPlayer.bossDistance;
        while(bossHP > 0){

            while(!playerPriorityQueue.isEmpty() &&
                    time == playerPriorityQueue.peek().bossDistance){
                Player joinPlayer = playerPriorityQueue.poll();
                totalDps += joinPlayer.dps;
                joinPlayer.bossAttackFlag = true;
            }

            bossHP -= totalDps;
            time++;

        }

        // 플레이어 플래그 카운트
        long count = playerMap.keySet().stream()
                .filter(playerKey -> playerMap.get(playerKey).bossAttackFlag)
                .count();

        System.out.println(count);

    }

    private static class Player{
        char ID;
        int dps = 0;
        boolean bossAttackFlag;
        int bossDistance = Integer.MAX_VALUE;

        public Player(char ID, boolean bossAttackFlag) {
            this.ID = ID;
            this.bossAttackFlag = bossAttackFlag;
        }

        public void setDps(int dps){
            this.dps = dps;
        }

        public void setBossDistance(int distance){
            this.bossDistance = distance;
        }
    }
}
