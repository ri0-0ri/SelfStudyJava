import java.util.Arrays;

class Solution {
    public int solution(int[] array) {
		    int answer = 0;
        Arrays.sort(array);
        int num = array.length/2;
        answer = array[num];
        return answer;
    }
}