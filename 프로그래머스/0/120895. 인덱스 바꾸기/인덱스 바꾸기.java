class Solution {
    public String solution(String my_string, int num1, int num2) {
        char ch = my_string.charAt(num1);
        char ch2 = my_string.charAt(num2);
        StringBuilder answer = new StringBuilder(my_string);
        answer.setCharAt(num1, ch2);
        answer.setCharAt(num2, ch);

        return answer.toString();
    }
}