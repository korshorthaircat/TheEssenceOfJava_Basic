//Ch.11 - 38 HashSet 예제4

import java.util.*;

class Ex11_12 {
	public static void main(String args[]) {
		
		HashSet setA = new HashSet();
		HashSet setB = new HashSet();
		HashSet setHab = new HashSet(); //합집합 
		HashSet setKyo = new HashSet(); //교집합 
		HashSet setCha = new HashSet(); //차집합 
		
		setA.add("1");	setA.add("2");	setA.add("3");	setA.add("4");	setA.add("5");
		System.out.println("A = " + setA);
		
		setB.add("4");	setB.add("5");	setB.add("6");	setB.add("7");	setB.add("8");
		System.out.println("B = " + setB);
		
		Iterator it = setB.iterator();
		while(it.hasNext()) {
			Object tmp = it.next();
			if(setA.contains(tmp))
				setKyo.add(tmp);
		}
		
		it = setA.iterator();
		while(it.hasNext()) {
			Object tmp = it.next();
			if(!setB.contains(tmp))
				setCha.add(tmp);
		}
		
		it = setA.iterator();
		while(it.hasNext())
			setHab.add(it.next());
		it = setB.iterator();
		while(it.hasNext())
			setHab.add(it.next());
		
//		setA.retainAll(setB); //교집합(공통된 요소만 남기고 삭제)
//		setA.removeAll(setB); //차집합(공통된 요소를 제거) 
//		setA.addAll(setB); //합집합(중복 제외 모든 요소를 추가) 
		
		System.out.println("A 합 B = " + setHab);
		System.out.println("A 교 B = " + setKyo);
		System.out.println("A 차 B = " + setCha);
		
	}
}
