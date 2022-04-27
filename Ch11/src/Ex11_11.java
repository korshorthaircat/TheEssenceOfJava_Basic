//Ch.11 - 37 HashSet 예제3

import java.util.*;

class Ex11_11 {
	public static void main(String[] args) {

	HashSet set = new HashSet();
	set.add("abc");
	set.add("abc"); //중복이라 저장 안 됨.
	set.add(new Person("David", 10));
	set.add(new Person("David", 10)); //중복처럼 보이는데 저장됨. *왜?*
	//만일 두 Person인스턴스를 같은것으로 인식하게 하고 싶다면,
	//Person클래스에 equals()와 hashCode()를 오버라이딩해야 한다.
		//이클립스 IDE에서 Source > Generate hashCode() and equals()를 사용하면 편리하다. 
	
	//왜냐하면 HashSet의 add메서드는
	//새로운 요소를 추가하기 전에 중복 여부를 판별하기 위해서
	//추가하려는 요소의 equals()와 hashCode()를 호출하여 확인하기 때문이다. 
	
	System.out.println(set);
	
	}
}

class Person {
	String name;
	int age;
	
//	@Override
//	public int hashCode() {
//		return Objects.hash(name, age); //int hash(Object...values)
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (!(obj instanceof Person))
//			return false;
//		Person p = (Person)obj;
//		return this.name.equals(p.name) && this.age==p.age; //객체 자신(this)와 매개변수 obj의 name과 age를 각각 비교
//	}

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return (name + ":" + age);
	}

	
	
}
