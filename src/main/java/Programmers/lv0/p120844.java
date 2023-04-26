package Programmers.lv0;

public class p120844 {
    public int[] solution(int[] numbers, String direction) {
        int temp;
        if (direction.equals("right")) {
            temp = numbers[numbers.length - 1];
            for (int i = numbers.length - 1; i > 0; i--) {
                numbers[i] = numbers[i - 1];
            }
            numbers[0] = temp;
        } else if (direction.equals("left")) {
            temp = numbers[0];
            for (int i = 0; i < numbers.length - 1; i++) {
                numbers[i] = numbers[i + 1];
            }
            numbers[numbers.length - 1] = temp;
        }

        return numbers;
    }
}
