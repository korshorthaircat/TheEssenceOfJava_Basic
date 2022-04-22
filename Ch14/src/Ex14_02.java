//Ch.14 - 08 java.util.function 패키지

import java.util.function.*;
import java.util.*;

class Ex14_02 {
	public static void main(String[] args) {
		
		//Supplier<T> - 매개변수는 없고 반환값만 있음. get()
		Supplier<Integer> s = () -> (int)(Math.random()*100)+1;
		
		//Consumer<T> - 매개변수는 있고 반환값은 없음. accept(T t)
		Consumer<Integer> c = i -> System.out.print(i + ", ");
		
		//Predicate<T> - 하나의 매개변수를 받아서 boolean타입을 반환함(조건식 표현에 사용). test(T t)
		Predicate<Integer> p = i -> i%2==0; //짝수이면 true, 홀수이면 false
		
		//Function<T, R> - 하나의 매개변수를 받아서 하나의 결과를 반환함(일반적인 함수). apply(T t)
		Function<Integer, Integer> f = i -> i/10*10; //i의 일의 자리를 없앤다
		
		
		List<Integer> list = new ArrayList<>();
		makeRandomList(s, list); 
		System.out.println(list);
		printEvenNum(p, c, list);
		List<Integer> newList = doSomething(f, list);
		System.out.println(newList);
	
	}
	
	static <T> List<T> doSomething(Function<T, T> f, List<T> list) {
		List<T> newList = new ArrayList<T>(list.size());
		
		for(T i : list) {
			newList.add(f.apply(i));
		}
		
		return newList;
	}
	

	static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
		System.out.print("[");
		for(T i : list) {
			if(p.test(i)) //만일 list에 담긴 수가 짝수이면,
				c.accept(i); //출력
		}
		System.out.println("]");
	}
	
	static <T> void makeRandomList(Supplier<T> s, List<T> list) {
		for (int i=0; i<10; i++) {
			list.add(s.get());
		}
	}
	
}
