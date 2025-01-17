class Solution {
    public int[] solution(int[] numbers, String direction) {
        int len = numbers.length;
        int[] answer = new int[len];
        
        switch (direction) {
            case "right" :
                answer[0] = numbers[len-1];
                for(int i=len-1; i>=1; i--) {
                    answer[i] = numbers[i-1];
                }
                break;
                
            case "left" :
                answer[len-1] = numbers[0];
                for(int i=0; i<len-1; i++) {
                    answer[i] = numbers[i+1];
                }
                break;
        }
        return answer;
    }
}