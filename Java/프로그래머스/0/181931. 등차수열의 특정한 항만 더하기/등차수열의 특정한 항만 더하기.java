class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        int[] numIncluded = new int [included.length];
        numIncluded[0] = a;
        
        for(int i = 1; i<included.length; i++){
            numIncluded[i] = a+=d;
            }
        
        for(int j = 0; j<included.length; j++){
            if(included[j]){
                answer += numIncluded[j];
            }
        }
        return answer;
        }         
    }