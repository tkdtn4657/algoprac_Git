package Baekjoon.silver;

import java.io.*;
import java.util.*;

public class p28256 {
    static char[][] chocoCase;
    static boolean[] check = new boolean[8];
    static int[][] map = {{0, 0}, {0, 1}, {0, 2}, {1, 2}, {2, 2}, {2, 1}, {2, 0}, {1, 0}}; //좌표 왼쪽위부터 쭉 이어지게
    static ArrayList<Integer> resultList;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = false;
        ArrayList<Integer> al = new ArrayList<>(4);
        resultList = new ArrayList<>(4);
        int t = Integer.parseInt(br.readLine());
        chocoCase = new char[3][3];
        StringTokenizer st;
        while(t-->0) {
            resultList.clear();
            al.clear();
            check = new boolean[8];
            flag = false;
            for (int i = 0; i < 3; i++) {
                chocoCase[i] = br.readLine().toCharArray();
            }
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            for(int i = 0; i < length; i++){
                al.add(Integer.parseInt(st.nextToken()));
            }

            for(int i = 0; i < 8; i++){
                int x = map[i][0];
                int y = map[i][1];
                if(chocoCase[x][y] == 'O'){
                    check[i] = true;
                }else{

                }
            }

            if(checkFull()){
                if(al.size() == resultList.size() && al.size() == 1) {
                    if(al.get(0) != resultList.get(0)) {
                        System.out.println(0);
                        continue;
                    }else{
                        System.out.println(1);
                        continue;
                    }
                }else{
                    System.out.println(0);
                    continue;
                }
            }
            else if(al.size() == 0){
                if(checkXFull()) {
                    System.out.println(1);
                    continue;
                }
                else{
                    System.out.println(0);
                    continue;
                }
            }
            else {
                checkChoco();
            }
            Collections.sort(resultList);
            if(al.size()>0 && resultList.size() > 0) {
                if (al.size() == resultList.size()) {
                    for (int i = 0; i < al.size(); i++) {
                        if (al.get(i) != resultList.get(i)) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                } else {
                    System.out.println(0);
                }
            }else{
                System.out.println(0);
            }
//            resultList.clear();
//            al.clear();
//            check = new boolean[8];
//            flag = false;
        }

    }
    static void checkChoco(){//맵 순서대로 어케 탐색해?
        int count = 1;
        int index = 0;
        boolean recentbool = check[0];

        for(int i = 1; i < check.length+1; i++){
            if(recentbool != check[i%8] && check[i%8] == true) {
                index = i;
                break;
            }else {
                recentbool = check[i%8];
            }
        }
        //2부터 시작
        recentbool = check[index%8];
        for(int i = (index+1)%8, each = 0; each < 8; each++, i++){
            if(recentbool == check[i%8] && check[i%8] == true){
                count++;
                recentbool = check[i%8];
            }else if(recentbool != check[i%8] && check[i%8] == true){
                count = 1;
                recentbool = check[i%8];
            }else if(recentbool != check[i%8] &&check[i%8] == false) {
                resultList.add(count);
                recentbool = check[i % 8];
            }
        }
    }

    static boolean checkFull(){
        for(int i = 0; i < 8; i++){
            if(!check[i]){
                return false;
            }
        }
        resultList.add(8);
        return true;
    }

    static boolean checkXFull(){
        for(int i = 0; i < 8; i++){
            if(check[i]){
                return false;
            }
        }
        return true;
    }
}
