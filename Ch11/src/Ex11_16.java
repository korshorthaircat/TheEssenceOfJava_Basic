//Ch.11 - 49 HashMap 예제1 
//로그인

import java.util.*; 

class Ex11_16 {
	public static void main(String[] args) {
		
		//HashMap을 생성해 사용자 ID와 password를 키와 값의 쌍으로 저장 
		HashMap map = new HashMap();
		map.put("myID", "1234");
		map.put("asdf", "1111");
		map.put("asdf", "1234"); //Ok. 이미 존재하는 키 추가 가능. 단, 기존 값은 없어짐.(덮어씌워짐) 
		
		Scanner s = new Scanner(System.in); //화면으로부터 라인 단위로 입력을 받는다. 
		
		while(true) {
			System.out.println("ID와 password를 입력해주세요.");
			System.out.print("id: ");
			String id = s.nextLine().trim(); //trim()으로 앞뒤 공백 제거 
			
			System.out.print("password: ");
			String password = s.nextLine().trim();
			System.out.println();
			
			if(!map.containsKey(id)) {
				System.out.println("입력하신 ID는 존재하지 않습니다. 다시 입력해주세요.");
				continue;
			}
			
			if(!(map.get(id)).equals(password)) {
				System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
			} else {
				System.out.println("ID와 비밀번호가 일치합니다.");
				break;
			}
		
		}//while의 끝 
	}//main의 끝 

}
