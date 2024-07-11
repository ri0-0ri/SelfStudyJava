class Solution {
    public String solution(String code) {
        String answer = "";
        int mode = 0;
        
        for (int i = 0; i < code.length(); i++) {
			char ch = code.charAt(i);
			
			if(ch=='1') {
				mode = 1 - mode;
			}
			else {
				if(mode==0) {
					if(i%2==0) {
						answer += code.charAt(i);
					}
				}
				else {
					if(i%2==1) {
						answer += code.charAt(i);
					}
				}
			}
		} 
        
        if(answer == "") {
            answer = "EMPTY";
        }

            return answer;
    }
}