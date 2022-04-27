//Ch.11 - 31 Comparator와 Comparable 예제

import java.util.*;

class Ex11_07 {
	public static void main(String[] args) {
		
		String[] strArr = { "cat", "Dog", "lion", "tiger" };

//		static void sort(Object[] a) - 객체 배열에 저장된 객체가 구현한 Comparable에 의한 정렬 
		Arrays.sort(strArr); //strArr에 저장된 객체 String이 Comparable을 구현하고 있으므로, 그에 의한 정렬(사전순, 오름차순)이 가능함 
		System.out.println("strArr= " + Arrays.toString(strArr));
		
//		Arrays.sort(정렬대상, 정렬기준)
//		static void sort(Object[] a, Comparator c) - 지정한 Comparator에 의한 정렬
		Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); //대소문자 구분 없이 정렬
		//이때 String클래스의 CASE_INSENSITIVE_ORDER은 static 상수
			//public static final Comparator<String> CASE_INSENSITIVE_ORDER = new CaseInsensitiveComparator();
			//CaseInsensitiveComparator는 String클래스의 내부 클래스이며, Comparator인터페이스를 구현하고 있다. 
		System.out.println("strArr= " + Arrays.toString(strArr));
		
		Arrays.sort(strArr, new Descending()); //역순 정렬(기본 정렬의 반대)
		System.out.println("strArr= " + Arrays.toString(strArr));
	}
}

class Descending implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		if (o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable)o1;
			Comparable c2 = (Comparable)o2;
			return c1.compareTo(c2) * -1; //-1을 곱해서 기본정렬방식의 역으로 변경한다.
//			return c2.compareTo(c1) //또는 이와 같이순서를 순서를 바꿔 쓰는 것도 가능하다.
		}
		return -1;
	}
}
