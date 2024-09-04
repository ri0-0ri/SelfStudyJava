class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        double hap=0;
        for(int i=0; i<numbers.length; i++){
            hap+=numbers[i];
        }
        answer = hap/numbers.length;
        return answer;
    }
}