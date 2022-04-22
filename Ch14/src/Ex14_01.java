//CH.14 - 06 함수형 인터페이스 타입의 매개변수, 반환타입 

@FunctionalInterface
interface MyFunction { //함수형 인터페이스는 단 하나의 추상메서드만 가져야 함 
	void run(); // public abstract void run();
}

class Ex14_01 {
	static void execute(MyFunction f) { //메서드의 매개변수 타입이 함수형 인터페이스
		f.run();
	}
	
	static MyFunction getMyFunction() { //메서드의 반환타입이 함수형 인터페이스 
		MyFunction f = () -> System.out.println("f3.run()");
		return f;		
	}
 	
	public static void main(String[] args) {

		//람다식으로 MyFunction의 run()을 구현
		MyFunction f1 = () -> System.out.println("f1.run()");
		
		MyFunction f2 = new MyFunction() { //익명 클래스로 run()을 구현 
			public void run() { //public을 반드시 붙여야 함. 
				System.out.println("f2.run()");
			}
		};
		
		MyFunction f3 = getMyFunction();
		
		f1.run();
		f2.run();
		f3.run();
		
		execute(f1);
		execute( () -> System.out.println("run()") );
	}
}
