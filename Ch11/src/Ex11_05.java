//Ch.11 - 23 Iterator, ListIterator, Enumeration 예제

import java.util.*;

class Ex11_05 {
	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
//		Collection c = new ArrayList(); //위의 코드를 이와 같이 쓴다면, ArrayList가 아닌 다른 컬렉션 클래스(HashSet, TreeSet 등...)로 변경할 경우에 참조변수를 검토할 필요 없어 편리하다. 
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		Iterator it = list.iterator(); //list에서 iterator()를 호출하여 Iterator객체를 얻어온다. 단, 이렇게 받아온 iterator는 일회용이다.
		
		//boolean hasNext() - 읽어올 요소가 남아있는지 확인한다. 있으면 true, 없으면 false를 반환한다.
		while(it.hasNext()) {
			Object obj = it.next(); //Object next() - 다음 요소를 읽어온다. next()를 호출하기 전에 hasNext()를 호출해서 읽어올 요소가 있는지 미리 확인하는 것이 안전하다.
			System.out.println(obj);
		}

		it = list.iterator(); //iterator는 일회용이다. 다 쓰고 난 뒤 다시 사용하고 싶다면, iterator객체를 다시 얻어와야 한다. 
		
		while(it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
		
		//Iterator대신 for문과 get()으로 List의 모든 요소를 출력할 수도 있다.
		for(int i=0; i<list.size(); i++) {
			Object obj = list.get(i);
			System.out.println(obj);
		} //하지만 이 경우 컬렉션을 List가 아닌 다른 것으로 바꾼다면, 코드가 동작하지 않는다. (바꾼 컬렉션 클래스에 get()메서드가 없을 수도 있기 때문이다.) 
		
		//Iterator는 컬렉션의 요소를 읽어오는 방법을 표준화하였으므로 코드의 재사용성이 높다. 
		//Iterator를 사용하면 컬렉션 클래스가 바뀌어도 컬렉션의 요소를 읽어오는 방법까지 변경할 필요 없으므로 편리하다. 
	}

}
