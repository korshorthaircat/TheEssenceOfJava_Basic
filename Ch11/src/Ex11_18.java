//Ch.11 - 51 HashMap 예제3  
//빈도수 계산하기(카운팅) 

import java.util.*;

class Ex11_18 {
	public static void main(String[] args) {
		
		String[] data = { "A", "K", "A", "K", "D", "K", "A", "K", "K", "K", "Z", "D" };
		
		HashMap map = new HashMap();
		
		//문자열 배열에 담긴 문자열을 하나씩 읽어서 HashMap에 키로 저장 
		for(int i=0; i<data.length; i++) {
			if(map.containsKey(data[i])) {
				int value = (int)map.get(data[i]);
				map.put(data[i], value + 1); //카운팅하기 위해서 기존에 있던 키는 기존 값에 1을 더해서 저장 
			} else {
				map.put(data[i], 1); //기존에 없던 키는 값을 1로 저장
			}
		}
		
		Iterator it = map.entrySet().iterator();
		
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			int value = (int)entry.getValue();
			System.out.println(entry.getKey() + " : " + printBar('#', value) + " " + value);
		}
		
	} //main의 끝
	
	public static String printBar(char ch, int value) {
		char[] bar = new char[value];
		
		for(int i=0; i<bar.length; i++) 
			bar[i] = ch;
			
		return new String(bar); //Strings(char[] chArr)
	}

}
