class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        int len = overwrite_string.length()+s;
        
        String answer = ""; 
	    answer += my_string.substring(0,s); //He
	    answer += overwrite_string; //lloWorl
	    answer += my_string.substring(len); //d
	    System.out.println(answer);

        return answer;
    }
}