//Ch.11 - 44 TreeSet 예제2 

import java.util.*;

class Ex11_14 {
	public static void main(String[] args) {
		
		TreeSet set = new TreeSet();
		
		String from = "b";
		String to = "d";
		
		set.add("abc");			set.add("alien");		set.add("bat");
		set.add("car");			set.add("Car");			set.add("disc");
		set.add("dance");		set.add("dZZZZ");		set.add("dzzzz");
		set.add("elephant");	set.add("elevator");	set.add("fan");
		set.add("flower");
		
		System.out.println(set);
		System.out.println("range search: form " + from + " to " + to);
		//subSet()을 이용한 범위 검색에서 시작 범위(form)은 포함되지만 끝 범위(to)는 포함하지 않음 
		System.out.println("result1 : " + set.subSet(from, to)); 
		System.out.println("result2 : " + set.subSet(from, to + "zzz"));
		
	}
}
