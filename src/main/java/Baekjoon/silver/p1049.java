package Baekjoon.silver;

import java.util.*;
import java.io.*;

public class p1049 {
    public static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> setLine = new ArrayList<>();
        ArrayList<Integer> eachLine = new ArrayList<>();


        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            setLine.add(Integer.parseInt(st.nextToken()));
            eachLine.add(Integer.parseInt(st.nextToken()));
        }

//        세트를 사서 6을 추가하거나 낱개로 채우거나

        //세트에서 싼걸 찾고
        //낱개에서 싼걸 찾고
        //걍 어레이정렬 돌려도 될듯?

        Collections.sort(setLine);
        Collections.sort(eachLine);
        int remain = n;
        int result = 0;

        while(remain > 0){
            //6개보다 많을 때 세트가 좋은지 낱개가 좋은지 낱개가좋으면 그냥 보내
            if(remain >= 6 && setLine.get(0) >= eachLine.get(0) * 6){
                result += remain*eachLine.get(0);
                remain -= remain;
            }
            else if(remain >= 6 && setLine.get(0) < eachLine.get(0)*6){
                result += remain / 6 * setLine.get(0);
                remain = remain % 6;
            }
            else if(remain < 6){
                if(setLine.get(0) > eachLine.get(0) * remain){
                    result += eachLine.get(0) * remain;
                    remain -= remain;
                }else{
                    result += setLine.get(0);
                    remain -= remain;
                }
            }
        }
        System.out.println(result);

    }

}
