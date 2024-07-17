class Solution {
    public int[] solution(int n) {
        
        int num = 0;
        for(int i=1; i<=n; i++){
            if(n%2==1){
                num = n/2+1;
            }
            else{
                num = n/2;
            }
        }
        
        int[] answer = new int [num];
        
        for(int i = 0; i<answer.length; i++){
            answer[i] = i*2+1;
        }
    
        return answer;
    }
}