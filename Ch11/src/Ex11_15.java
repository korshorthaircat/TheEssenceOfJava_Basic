//Ch.11 - 45 TreeSet 예제3 

import java.util.*;

class Ex11_15 {
	public static void main(String[] args) {

		TreeSet set = new TreeSet();
		int[] score = { 80, 95, 50, 35, 45, 65, 10, 100 };
	
		for(int i=0; i < score.length; i++)
			set.add(new Integer(score[i])); //set.add(score[i]);도 가능 
		//배열 score의 데이터를 TreeSet에 옮겨 담음(범위 검색을 위하여)
		
		//TreeSet의 범위 검색
		//SortedSet subSet(Object fromElement, Object toElement) - formElement~toElement 사이의 결과를 반환한다. (끝 범위인 toElement는 범위에 포함X)
		//SortedSet headSet(Object toElement) - 지정된 객체보다 작은 값의 객체들을 반환 (끝 범위인 toElement는 포함 X)
		//SortedSet tailSet(Object fromElement) - 지정된 객체보다 큰 값의 객체들을 반환 (시작 범위인 fromElement는 포함) 
		System.out.println("40과 80 사이의 값: " + set.subSet(40, 80)); //오토박싱
		System.out.println("50보다 작은 값: " + set.headSet(new Integer(50)));
		System.out.println("50보다 큰 값: " + set.tailSet(new Integer(50)));
	
		
	}
}
