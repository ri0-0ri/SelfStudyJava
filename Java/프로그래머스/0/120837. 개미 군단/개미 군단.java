class Solution {
    public int solution(int hp) {
        int answer = 0;
        
        answer += hp/5; //장군개미
        hp = hp%5; //장군개미 빼고 난 체력

        answer += hp/3; //병정개미
        hp = hp%3; //병정개미 빼고 난 체력

        answer += hp/1; //일개미

        return answer;
    }
}