class Solution {
    public int solution(String number) {
        int answer = 0;
        int hap = 0;
        for(int i=0; i<number.length(); i++){
            hap += Character.getNumericValue(number.charAt(i));
        }
        answer = hap%9;        
        return answer;
    }
}