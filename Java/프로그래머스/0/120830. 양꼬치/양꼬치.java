class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        int count = 0;
        count += k-(n/10);
        answer += n*12000;
        answer += count*2000;
        return answer;
    }
}