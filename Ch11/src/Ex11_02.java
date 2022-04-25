//Ch.11 - 17 Stack과 Queue 예제

import java.util.*;

class Ex11_02 {
	public static void main(String[] args) {

		//자바에서는 스택을 Stack클래스로 구현하여 제공하지만, 큐는 Queue인터페이스로만 정의해놓았을 뿐 별도의 클래스를 제공하지는 않는다. 
		Stack st = new Stack();
		Queue q = new LinkedList(); //Queue인터페이스를 구현한 LinkedList를 사용 

		//스택에 저장할 때는 push()
		st.push("0");
		st.push("1");
		st.push("2"); //스택에 0, 1, 2 순서로 저장 
		
		//큐에 저장할 때는 offer()
		q.offer("0");
		q.offer("1");
		q.offer("2");
		
		System.out.println("= S t a c k =");
		//스택에서 꺼낼 때는 pop()
		while(!st.empty()) { //스택이 비어있는지 확인 
			System.out.println(st.pop()); //스택에서 요소 하나를 꺼내서 출력
		}
		
		System.out.println("= Q u e u e =");
		//큐에서 꺼낼 때는 poll()
		while(!q.isEmpty()) { //큐가 비어있는지 확인 
			System.out.println(q.poll()); //큐에서 요소 하나를 꺼내서 출력
		}
		
		//결과
		//스택 - 먼저 넣은 것이 나중에 꺼내지는 구조(LIFO)
		//큐 - 먼저 넣은 것이 먼저 꺼내지는 꾸조(FIFO)
	}
}
