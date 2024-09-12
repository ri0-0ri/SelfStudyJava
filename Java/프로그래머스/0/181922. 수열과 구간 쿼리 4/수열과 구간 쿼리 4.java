class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            int num = query[2];

            for (int j = start; j <= end; j++) {
                if (j % num == 0) {
                    arr[j]++;
                }
            }
        }
        return arr;
    }
}