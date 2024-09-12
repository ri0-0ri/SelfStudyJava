import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];		
		       
		for (int i = 0; i < queries.length; i++) {
			int start = queries[i][0];
			int end = queries[i][1];
			int num = queries[i][2];
            
            List<Integer> numlist = new ArrayList();
			for (int j = start; j <= end; j++) {
				numlist.add(arr[j]);
			}
		
			Collections.sort(numlist);
		
			for (int k = 0; k < numlist.size(); k++) {
				if(numlist.get(k)>num) {
					answer[i] = numlist.get(k);
					break;
				}
				else {
					answer[i] = -1;
				}
			}
		}
        
        return answer;
    }
}