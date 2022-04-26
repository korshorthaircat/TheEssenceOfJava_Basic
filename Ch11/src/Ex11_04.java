//Ch.11 - 21 Stack과 Queue의 활용 예제2
//최근 명령어 이력(히스토리) 보여주기 - 큐를 활용하여 유닉스의 history 명령어 구현 
//비슷한 방식으로 최근 열어본 문서들의 목록 보여주는 기능도 구현 가능함 

import java.util.*;

class Ex11_04 {

	static Queue q = new LinkedList(); //Queue를 구현한 클래스로 객체를 생성해 사용
	static final int MAX_SIZE = 5; //Queue에 최대 5개까지만 저장되도록 한다.

	public static void main(String[] args) {
		System.out.println("help를 입력하면 도움말을 볼 수 있습니다.");
		
		while(true) { //무한반복문을 통해 계속 입력을 받음 
			System.out.print(">>");
			
			try {
				//화면으로부터 라인 단위로 입력을 받는다.
				Scanner s = new Scanner(System.in);
				String input = s.nextLine().trim(); //입력 받은 것을 앞뒤 공백 제거하여 문자열 input에 저장
				
				if("".equals(input)) continue; //입력한 내용이 없다면 while(true)의 처음으로 돌아간다.
				
				if(input.equalsIgnoreCase("q")) {  
					System.exit(0); //프로그램을 종료함 
				
				} else if(input.equalsIgnoreCase("help")) { //대소문자를 구분하지 않
					System.out.println(" help - 도움말을 보여줍니다.");
					System.out.println(" q 또는 Q - 프로그램을 종료합니다.");
					System.out.println(" history - 최근에 입력한 명령어를 " + MAX_SIZE + "개 보여줍니다.");
				
				} else if(input.equalsIgnoreCase("history")) {
					save(input); //입력받은 명령어를 저장하고,
					
					//LinkedList의 내용을 보여준다.
					LinkedList list = (LinkedList)q;
					
					final int SIZE = list.size();
					for(int i=0; i<SIZE; i++)
						System.out.println((i+1)+"."+list.get(i)); //모든 요소를 루프 돌면서 번호 붙여서 get(i)로 보여줌
					
//					ListIterator it = list.listIterator();
//					
//					while(it.hasNext())
//						System.out.println(++i+"."+it.next());	
//					
				} else {
					save(input);
					System.out.println(input);
				} //if(input.equalsIgnoreCase("q")) {
					
				
			} catch(Exception e) {
				System.out.println("입력 오류입니다.");
			}
	
		}//while(true)
	} //main()
	
	public static void save(String input) {
		//queue에 저장한다
		if(!"".equals(input)) //if(input!=null && !input.equals(""))을 간단히 쓰기 위한 조건문 
			q.offer(input); //빈 문자열이 아닐 때 저장함 
		
		//queue의 최대 크기를 넘으면 제일 처음 입력된 것을 삭제한다.
		if(q.size() > MAX_SIZE) //size()는 Collection인터페이스에 정의 
			q.poll();
	}

} 
