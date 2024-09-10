class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        
        for(int i=0; i<my_string.length(); i++){
            if(my_string.charAt(i)>='A'&&my_string.charAt(i)<='Z'){ //대문자(26개)
                answer[my_string.charAt(i)-'A']++;
            }
            else{ //소문자
                answer[my_string.charAt(i)-'a'+26]++;
            }
        }
        
        return answer;
    }
}