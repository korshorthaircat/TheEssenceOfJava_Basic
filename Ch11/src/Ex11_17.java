//Ch.11 - 50 HashMap 예제2  

import java.util.*;

class Ex11_17 {
	public static void main(String[] args) {
		
		HashMap map = new HashMap();
		map.put("김자바", 90);
		map.put("김자바", 100); //키 값이 일치하므로 갚이 덮어씌워진다. 
		map.put("이자바", 100);
		map.put("강자바", 80);
		map.put("안자바", 90);
		
		//Set entrySet() - HashMap에 저장된 키와 값을 엔트리(키와 값의 결합)의 형태로 Set에 저장해서 반환 
		Set set = map.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next(); //Map.Entry는 Map의 내부 인터페이스
			System.out.println("이름: " + e.getKey() + ", 점수: " + e.getValue());
		}
		
		//Set keySet() - HashMap에 저장된 모든 키가 저장된 Set을 반환 
		set = map.keySet();
		System.out.println("참가자 명단: " + set);
		
		//Collection values() - HashMap에 저장된 모든 값을 컬렉션의 형태로 반환 
		Collection values = map.values();
		it = values.iterator();
		
		int total = 0;
		
		while(it.hasNext()) {
			int i = (int)it.next();
			total += i;
		}
		
		System.out.println("총점: " + total);
		System.out.println("평균: " + (float)total/set.size());
		System.out.println("최고점수: " + Collections.max(values));
		System.out.println("최저점수: " + Collections.min(values));
		
	}

}
