import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        int len = a.length();
        String result = "";
        
        for(int i=0; i < len; i++) {
            char ch = a.charAt(i);
            if(ch >= 'a' && ch <= 'z') {
                result += (char)(ch-32);
            }
            else {
                result += (char)(ch+32);
            }   
        }
        System.out.print(result); 
    }
}