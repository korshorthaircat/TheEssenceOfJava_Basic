//Ch.11 - 36 HashSet 예제2
//로또 번호 추첨기(set을 이용한 중복 없이 숫자 뽑기) 

import java.util.*;

class Ex11_10 {
	public static void main(String[] args) {
	
		Set set = new HashSet();
		
		//set의 크기가 6보다 작은 동안 1~45 사이의 난수를 저장 
		for (int i=0; set.size()<6; i++) {
			int num = (int)(Math.random()*45+1);
			set.add(new Integer(num)); //set.add(num)이라고 써도 컴파일러가 알아서 Integer객체로 바꿔준다. 
		}
		System.out.println(set); //set의 요소들이 순서 상관없이 출력된다.
		//set은 순서를 유지하지 않으므로 정렬이 불가능하다. 
		
		//따라서 번호를 크기 순으로 정렬하고 싶다면 HashSet에 저장된 객체들을 LinkedList로 옮겨 담아 리스트를 정렬해야한다.
		List list = new LinkedList(set); //LinkedList(Collection c)
		Collections.sort(list); //Collections클래스의 sort(List list)사용. 컬렉션에 저장된 객체가 Integer이므로, Integer클래스에 정의된 기본정렬이 사용됨
		System.out.println(list);
		
	}
}
