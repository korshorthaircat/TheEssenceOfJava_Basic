//Ch.11 - 09 ArrayList

import java.util.*;

class Ex11_01 {
	public static void main(String[] args) {
		
		ArrayList list1 = new ArrayList(10); //기본 길이(용량, capacity)가 10인 ArrayList를 생성
		//add(Object o) 
		list1.add(new Integer(5)); //ArrayList에는 객체만 저장 가능 
		list1.add(4); //이와 같이 쓸 경우 컴파일러의 오토박싱에 의해 기본형이 참조형으로 자동 변환됨
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));
		
		//List subList(int fromIdx, int toIdx) - fromIdx부터 toIdx까지(toIdx는 포함X) 저장된 객체를 반환 
		ArrayList list2 = new ArrayList(list1.subList(1,4)); // 1<=index<4
		//위의 한 줄을 풀어쓰면 다음과 같다.
		//List sub = list1.subList(1,4); //subList()는 읽기만 가능
		//ArrayList list2 = new ArrayList(sub); //sub와 같은 내용의 ArrayList 생성
		print(list1, list2); //편한 출력을 위해 만든 메서드
		
		//Collections.sort(List l) - 오름차순으로 정렬 
		//참고) Collection은 인터페이스, Collections는 유틸 클래스
		Collections.sort(list1);
		Collections.sort(list2);
		print(list1, list2);
		
		//boolean containsAll() -모든 요소를 포함하고 있을 때 true
		System.out.println("list1.containsAll(list2): " + list1.containsAll(list2));
	
		list2.add("B");
		list2.add("C");
		list2.add(3, "A"); // add(int idx, Collection c) - 지정된 위치 idx에 객체 저장 
		print(list1, list2);
		
		list2.set(3, "AA"); // set(int idx, Collection c) -지정된 위치 idx에 객체 저장(치환, 변경)
		print(list1, list2);
		
		
		list1.add(0, "1"); //지정된 위치 0에 문자열 "1"을 저장한다.
		//int indexOf(Object o) - 지정된 객체가 어느 위치(index)에 있는지 찾아 반환(못 찾으면 -1 반환)
		System.out.println("indedx= " + list1.indexOf("1"));
		System.out.println("indedx= " + list1.indexOf(new Integer(1)));
		print(list1, list2);
		
		//boolean remove(Object o) - 지정한 객체를 삭제함
		list1.remove(new Integer(1));
		//Object remove(int index) - 지정된 위치(index)에 있는 객체를 삭제함
		list1.remove(1);
		print(list1, list2);
		
		//boolean retainAll()
		System.out.println("list1.retainAll(list2): " + list1.retainAll(list2)); //list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제함(차집합)
		print(list1, list2);
		
		//list2dㅔ서 list1에 포함된 객체들을 삭제하기 
		for(int i = list2.size()-1; i>=0; i--) { //ArrayList의 요소를 삭제할 때, 저장된 마지막 객체부터 삭제하는 것이 배열의 복사가 발생하지 않아 작업 시간이 덜 걸린다. 
			if(list1.contains(list2.get(i))) //list2에서 get(i)로 객체를 하나씩 꺼내서, contains()로 꺼낸 객체가 list1에 포함되어있는지 확인한다.
				list2.remove(i); //list2에서 remove(i)로 해당 객체를 삭제한다 
		}
		print(list1, list2);
	}
	
	static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1: " + list1);
		System.out.println("list2: " + list2);
		System.out.println();
	}
}
