class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {

        int resultnum = numer1 * denom2 + numer2 * denom1;
        int resultdenom = denom1 * denom2;
        

        int gcd = gcd(resultnum, resultdenom);
        

        resultnum /= gcd;
        resultdenom /= gcd;        

        int[] answer = {resultnum, resultdenom};
        
        return answer;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a); 
    }
}