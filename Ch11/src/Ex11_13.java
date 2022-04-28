//Ch.11 - 43 TreeSet 예제1

import java.util.*;

class Ex11_13 {
	public static void main(String[] args) {
		
		Set set = new TreeSet();
		
		for(int i=0; set.size()<6; i++) {
			int num = (int)(Math.random()*45) + 1;
			set.add(num); //set.add(new Integer(num));
		}
		
		System.out.println(set);
		//TreeSet은 저장할 때 이미 정렬하기 때문에, 읽어올 때 따로 정렬할 필요 없음
		//비교)HashSet 
	}
}
