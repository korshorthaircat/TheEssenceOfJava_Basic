//Ch.11 - 20 Stack과 Queue의 활용 예제1
//수식의 괄호 검사 - 스택을 활용해 소괄호'( )'가 잘 닫겼는지 체크하는 프로그램

import java.util.*;

public class Ex11_03 {
	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println("Usage: java Ex11_03 \"EXPRESSION\""); //프로그램의 사용법법을 알려준다. 프로그램을 실행할 매개변수에 검사하고자 하는 식을 넣어야 한다. 
			System.out.println("Example: java Ex11_03 \"((2+3)*1+3\"");
			System.exit(0);
		}

		Stack st = new Stack();
		String expression = args[0]; //사용자로부터 매개변수로 입력받은 식을 문자열 expression에 저장한다.
		System.out.println("expression: " + expression);
		
		try {
			for (int i=0; i<expression.length(); i++) {
				char ch = expression.charAt(i); //사용자로부터 입력받은 식을 한 글자(char)씩 검사할 것이다. 
			
				//한 글자씩 검사하면서 여는 소괄호'('를 만나면 스택에 집어넣고,
				//닫는 소괄호')'를 만나면 스택에서 꺼내는 일을 반복한다. 
				if (ch == '(') { 
					st.push(ch + ""); 
				} else if (ch == ')') { 
					st.pop(); 
				}
			}
			
				
			if (st.isEmpty()) { //만일 스택이 비어있다면, 여는 소괄호와 닫는 소괄호의 쌍이 맞아 괄호가 잘 닫혀 있다는 의미이다.
				System.out.println("괄호가 일치합니다.");
			} else {
				System.out.println("괄호가 일치하지 않습니다.");
			}
			
		} catch (EmptyStackException e) { //스택이 비어있는데도 닫는 소괄호')'를 만나서 여는 소괄호'('를 꺼내려 하는 경우 
			System.out.println("괄호가 일치하지 않습니다.");
		} //try-catch의 끝 
	}

}
