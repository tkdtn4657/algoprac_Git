package Programmers.lv1;

public class p120815 {
    public int solution(int n) {
        int answer = 1;
        int pizzaPiece = 6;
        int pizzaCount = 1;
        while(true){
            if(pizzaPiece % n == 0){
                return pizzaCount;
            }
        pizzaPiece += 6;
            pizzaCount++;
        }
    }
}
