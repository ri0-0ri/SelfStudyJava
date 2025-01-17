class Solution {
    public int solution(int order) {
        int answer = 0;
        String orderstr = String.valueOf(order);
        for(int i=0; i<orderstr.length(); i++){
            if(!(orderstr.charAt(i)=='0')){
                if((orderstr.charAt(i)-'0')%3==0){
                answer ++;
                }   
            }
        }
        return answer;
    }
}