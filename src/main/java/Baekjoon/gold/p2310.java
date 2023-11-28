package Baekjoon.gold;

import java.io.*;
import java.util.*;


/**
 * 3
 * E 0 2 0
 * L 10 3 0
 * T 15 1 2 0
 *
 * E 빈방, L 레프리콘, T 트롤
 * 두번째 0, 10, 15 금액
 * 레프리콘은 10원 기준
 * 트롤은 15원 기준
 *
 * 1번방 출발 빈방시작
 * 이후의 값은 다 다른 방과 이어지는 번호
 *
 * 처음 모험가가 시작하는 방 번호 1
 *
 * 연결리스트로 추가하기
 *
 */
public class p2310 {

    static ArrayList<Room> mapList;
    static boolean[] visited;
    static int n;
    static StringBuilder sb = new StringBuilder();
    static boolean flag;
    static boolean success;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        while(n > 0){
            mapList = new ArrayList<>();
            visited = new boolean[n+1];
            int myMoney = 0;
            flag = true;
            success = false;
            //0번방의 필요없는 데이터 주입
            mapList.add(new Room(-1,"NOTHING",-1));
            //

            for(int roomNumber = 1; roomNumber <= n; roomNumber++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                Room roomInit = new Room(
                        roomNumber,
                        st.nextToken(),
                        Integer.parseInt(st.nextToken())
                );

                int inputNum = Integer.parseInt(st.nextToken());
                while(inputNum > 0){
                    roomInit.roomNumberAdd(inputNum);
                    inputNum = Integer.parseInt(st.nextToken());
                }
                mapList.add(roomInit);
            }

            dfs(1, myMoney);

            if(!success){
                sb.append("No").append("\n");
            }else{
                sb.append("Yes").append("\n");
            }
            n = Integer.parseInt(br.readLine());
        }

        System.out.println(sb);

    }

    static void dfs(int roomNum, int myMoney){
        if(success){
            return;
        }
        visited[roomNum] = true;

        Room nowRoom = mapList.get(roomNum);
        myMoney = nowRoom.visitRoomEvent(myMoney);
        if(myMoney >= 0){
            if(n == roomNum){
                success = true;
                return;
            }
            for(int roomNumber : nowRoom.getLinkedRoomList()){
                if(!visited[roomNumber]) {
                    dfs(roomNumber, myMoney);
                }
            }
        }else{
            visited[roomNum] = false;
            return;
        }
    }

    private static class Room{
        int roomNum;
        String roomType;
        int roomMoney;
        final ArrayList<Integer> roomList;
        Room(int roomNumber, String type, int money){
            this.roomMoney = money;
            this.roomNum = roomNumber;
            this.roomList = new ArrayList<>();
            this.roomType = type;
        }

        void roomNumberAdd(int number){
            roomList.add(number);
        }

        ArrayList<Integer> getLinkedRoomList(){
            return roomList;
        }

        int visitRoomEvent(int money){
            if(roomType.equals("L")){
                if(money < this.roomMoney){
                    return this.roomMoney;
                }
            }
            if(roomType.equals("T")){
                if(money < this.roomMoney){
                    return -1;
                }
                money -= roomMoney;
                return money;
            }
            return money;
        }
    }
}
