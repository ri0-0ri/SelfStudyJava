class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        String hol = "";
        String zzak = "";
        
        for(int i = 0; i<num_list.length; i++){
            if(num_list[i]%2==0){ //짝수이면
                zzak += num_list[i]+"";
            }
            else { //홀수이면
                hol += num_list[i]+"";
            }
        }
        
        answer = Integer.parseInt(zzak)+Integer.parseInt(hol);
        
        return answer;
    }
}