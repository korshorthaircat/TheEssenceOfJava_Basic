//Ch.11 - 33 Integer와 Comparable 예제

import java.util.*;

class Ex11_08 {
	public static void main(String[] args) {
		
		Integer[] arr = { 30, 50, 10, 40, 20 };
		
		Arrays.sort(arr); //arr에 저장된 Integer가 가지고 있는 기본 정렬기준 compareTo()로 정렬 
		System.out.println(Arrays.toString(arr));
		
//		static void sort(Object[] a, Comparator c) - 지정한 Comparator에 의한 정렬
		Arrays.sort(arr, new DescComp()); //DesComp의 정렬기준 compare()로 정렬
		System.out.println(Arrays.toString(arr));
	}
}

class DescComp implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		if(! (o1 instanceof Integer && o2 instanceof Integer))
			return -1; //Integer가 아니라면 비교하지 않고 -1 반환
		
		Integer i = (Integer)o1;
		Integer i2 = (Integer)o2;
		return i.compareTo(i2) * -1; //기본정렬인 compareTo()의 역순으로 정렬 - 정렬기준이란 0, 양수, 음수 중 하나를 반환하도록 작성한 메서드라서 그저 -1을 곱하기만 하면 반대로 정렬된 결과를 얻을 수 있음. 
//		return i2.compareTo(i); 
//		return i2 -i ; 
	}
}
