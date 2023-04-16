package Programmers.lv1;

public class p120848 {
    public int solution(int n) {

        for(int i = 10; i > 0; i--){
            if(fac(i) <= n){
                return i;
            }
        }
        return 0;
    }

    int fac(int n){
        if (n == 1){
            return 1;
        }
        return n * fac(n-1);
    }
}
