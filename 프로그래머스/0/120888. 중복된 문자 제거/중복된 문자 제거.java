import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        Set<Character> check = new LinkedHashSet<>();
        for(int i=0; i<my_string.length(); i++){
            check.add(my_string.charAt(i));
        }
        for(char ch : check){answer += ch;}
        return answer;
    }
}