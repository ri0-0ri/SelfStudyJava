import java.util.*;
class Solution {
    public int[] solution(int n, int[] numlist) {
        List<Integer> list = new ArrayList();
		       
		for(int i=0; i<numlist.length;i++){
		    if(numlist[i]%n==0){
		    	list.add(numlist[i]); //배수일때 어레이리스트에 넣어
		    }
		}
		
		int[] answer = new int [list.size()]; //배수인 리스트 사이즈만큼 배열 생성
		
		for(int i=0; i<list.size(); i++) {	//어레이리스트 값을 배열로 옮겨
			answer[i] = list.get(i);
		}
        return answer;
    }
}