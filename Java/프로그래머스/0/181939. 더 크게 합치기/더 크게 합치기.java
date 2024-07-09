class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String a1 = a+"";
		String b1 = b+"";
		String ab = a1+b1;
		String ba = b1+a1;
		
		int abreal = Integer.parseInt(ab);
		int bareal = Integer.parseInt(ba);
		
		if(abreal >= bareal) {
			answer = abreal;
		}
		else if(abreal < bareal) {
			answer = bareal;
		}
        
        return answer;
    }
}