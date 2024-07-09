class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String a1 = a+"";
		String b1 = b+"";
		String ab = a1+b1;
		
		int abreal = Integer.parseInt(ab);
		int ab2 = 2*a*b;
		
		if(abreal >= ab2) {
			answer = abreal;
		}
		else if(abreal < ab2) {
			answer = ab2;
		}
        
        return answer;
    }
}