//Ch.11 - 35 HashSet 예제1

import java.util.*;

class Ex11_09 {
	public static void main(String[] args) {

		Object[] objArr = { "1", new Integer(1), "2", "2", "3", "3", "3", "4", "4", "4", "4" };
		Set set = new HashSet();
		
		for(int i=0; i<objArr.length; i++) {
			System.out.println(objArr[i] + "=" + set.add(objArr[i])); //HashSet에 objArr의 모든 요소들을 저장한다. 
		}
		
		//HashSet에 저장된 요소들을 출력한다. 
		System.out.println(set);
		
		//HashSet에 저장된 요소들을 출력한다.(Iterator이용)
		
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		//결과)
		//2, 3, 4는 중복 요소가 저장되지 않았음.
		//그러나 1은 중복 출력되었음.
			//둘 다 '1'로 보이기 때문에 구별이 안되지만, 사실 하나는 String인스턴스이고, 다른 하나는 Integer인스턴스.
			//서로 다른 객체이므로 중복으로 간주하지 않은 것
	}
}
