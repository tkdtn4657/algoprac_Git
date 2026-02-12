package Baekjoon.gold;

import java.io.*;
import java.util.*;

public class p16722 {

    static boolean gyeolFlag = false;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Polygon> list = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            String color = st.nextToken();
            String background = st.nextToken();

            list.add(new Polygon(s, color, background));
        }

        int n = Integer.parseInt(br.readLine());


        int result = 0;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);

            switch (command){
                case 'H':
                    int a = Integer.parseInt(st.nextToken())-1;
                    int b = Integer.parseInt(st.nextToken())-1;
                    int c = Integer.parseInt(st.nextToken())-1;

                    Polygon aPolygon = list.get(a);
                    Polygon bPolygon = list.get(b);
                    Polygon cPolygon = list.get(c);
                    if(Polygon.hapCheck(aPolygon, bPolygon, cPolygon)){
                        //polygon 사용처리
                        aPolygon.useFlag = true;
                        bPolygon.useFlag = true;
                        cPolygon.useFlag = true;
                        result++;
                    } else {
                        if(result != 0) {
                            result--;
                        }
                    }
                    break;

                case 'G':
                    if(Polygon.gyeolCheck(list)){
                        result += 3;
                    } else {
                        if(result != 0) {
                            result--;
                        }
                    }
                    break;

            }
        }

        System.out.println(result);

    }

    private static class Polygon{
        String s;
        String color;
        String background;
        boolean useFlag = false;

        public Polygon(String s, String color, String background) {
            this.s = s;
            this.color = color;
            this.background = background;
        }

        public static boolean hapCheck(Polygon aPolygon, Polygon bPolygon, Polygon cPolygon) {
            //합 조건이 전부 맞으면 true 그 외에 false
            //useFlag가 false인 것 중에서
            if(aPolygon.useFlag || bPolygon.useFlag || cPolygon.useFlag) return false;

            boolean sTrueFlag = false;
            boolean colorTrueFlag = false;
            boolean backgroundTrueFlag = false;

            if(aPolygon.s.equals(bPolygon.s)){
                //s가 모두 같은 케이스
                if(aPolygon.s.equals(cPolygon.s)){
                    sTrueFlag = true;
                }
            } else {
                if(!aPolygon.s.equals(cPolygon.s)){
                    if(!bPolygon.s.equals(cPolygon.s)){
                        sTrueFlag = true;
                    }
                }
            }

            if(aPolygon.color.equals(bPolygon.color)){
                //color가 모두 같은 케이스
                if(aPolygon.color.equals(cPolygon.color)){
                    colorTrueFlag = true;
                }
            } else {
                if(!aPolygon.color.equals(cPolygon.color)){
                    if(!bPolygon.color.equals(cPolygon.color)){
                        colorTrueFlag = true;
                    }
                }
            }

            if(aPolygon.background.equals(bPolygon.background)){
                //background가 모두 같은 케이스
                if(aPolygon.background.equals(cPolygon.background)){
                    backgroundTrueFlag = true;
                }
            } else {
                if(!aPolygon.background.equals(cPolygon.background)){
                    if(!bPolygon.background.equals(cPolygon.background)){
                        backgroundTrueFlag = true;
                    }
                }
            }

            if(sTrueFlag && colorTrueFlag && backgroundTrueFlag) {
                return true;
            } else {
                return false;
            }
        }

        public static boolean gyeolCheck(List<Polygon> list) {
            //list안의 useFlag가 false인 것 중에서
            List<Polygon> notUseList = list.stream()
                    .filter(s -> !s.useFlag)
                    .toList();

            gyeolFlag = false;
            backtrack(notUseList, 0, new ArrayList<Polygon>());

            //한번이라도 gyeolFlag가 true로 바뀌었다면 합이 있는 것
            if(gyeolFlag){
                return false;
            } else {
                return true;
            }
        }
    }

    private static void backtrack(List<Polygon> notUseList, int index, List<Polygon> selectList){
        if(notUseList.size() == index) return;

        if(selectList.size() == 3){
            if(Polygon.hapCheck(selectList.get(0), selectList.get(1), selectList.get(2))){
                gyeolFlag = true;
            }
        }

        for(int i = index; i < notUseList.size(); i++){
            selectList.add(notUseList.get(i));
            backtrack(notUseList, i+1, selectList);
            selectList.remove(notUseList.get(i));
        }
    }
}
