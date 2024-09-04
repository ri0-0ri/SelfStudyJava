class Solution {
    public int[] solution(int n, int k) {
        int len = n/k;
        int[] answer = new int[len];
        for(int i=1; i<=n ;i++){
            if((k*i)<=n){
                answer[i-1]+=k*i;
            }
        }        
        return answer;
    }
}