class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int gop = num_list[0];
        int hap = 0;
        int hapzegop = 0;
        
        for(int i = 1; i<num_list.length; i++){
            gop *= num_list[i];
        }
        
        for(int j = 0; j<num_list.length; j++){
            hap += num_list[j];
        }
        
        hapzegop = hap*hap;
        
        if(gop < hapzegop){
            answer = 1;
        }
        else {
            answer = 0;
        }
        
        return answer;
    }
}