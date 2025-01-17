import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int len = numbers.length;
        Arrays.sort(numbers);
        int num1 = numbers[0]*numbers[1];
        int num2 = numbers[len-1]*numbers[len-2];
        answer = num1<num2 ? num2 : num1;
        return answer;
    }
}