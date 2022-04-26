
## 15 Stack과 Queue
* **스택**
	* 마지막에 저장한 데이터를 가장 먼저 꺼내게 되는 **LIFO(Last In First Out)** 구조
		* 0, 1, 2의 순서로 데이터를 넣었다면(push)
		* —> 꺼낼 때는 2, 1, 0의 순서로 꺼내게(pop) 됨
	* 양 옆과 바닥이 막혀있는 상자처럼 한 방향으로만 꺼낼 수 있는 구조 
	* 순차적으로 데이터를 추가하고 삭제함
		* —> **ArrayList**같은 **배열 기반**의 컬렉션 클래스가 구현에 적합
	
* **큐**
	* 처음에 저장한 데이터를 가장 먼저 꺼내게 되는 **FIFO(First In First Out)** 구조
		* 0, 1, 2의 순서로 데이터를 넣었다면(offer) 
		* —> 꺼낼 때도 0, 1, 2의 순서로 꺼내게(poll) 됨
	* 양 옆만 막혀 있고 위아래로 뚫려 있는 파이프처럼 한 방향으로는 넣고 다른 방향으로는 빼는 구조
	* 데이터를 꺼낼 때마다 항상 첫번째 저장된 데이터를 삭제해야함
		* —> **LinkedList**처럼 데이터의 추가/삭제가 쉬운 컬렉션 클래스가 구현에 적합

* 자바에서는 스택을 Stack클래스로 구현하여 제공하지만
	*  사용의 예) Stack st = new Stack();
* 큐는 Queue인터페이스로만 정의해놓았을 뿐 별도의 클래스를 제공하지 않음(인터페이스는 객체 생성 불가)
	* 따라서 Queue를 직접 구현하거나
	* Queue인터페이스를 구현한 클래스들 중 하나를 선택해 객체 생성해 사용해야 함 
		* 예) Queue q = new LinkedList(); 
	* —> 인터페이스를 구현한 클래스 찾으려면? 
		* Java API문서 참고(All Known Implementing Classes)

## 16 Stack과 Queue의 메서드
### Stack의 메서드
* 추가하기(스택에 넣기)
	* **Object push(Object item)** - 스택에 객체(item)을 저장한다. 
* 꺼내기(스택에서 삭제)
	* **Object pop()** - 스택의 맨 위에 저장된 객체를 꺼낸다. (스택이 비어있으면 EmptyStackException 발생)
* 슬쩍 보기(삭제 없이 요소 읽어오기)
	* **Object peek()** - 스택의 맨 위에 저장된 객체를 반환한다. pop()과는 달리 객체를 꺼내지는 않는다.(스택이 비어있으면 EmptyStackException 발생)
* 비어있는지 확인
	* **boolean empty()** - 스택이 비어있는지 알려준다
* 검색하기
	* **int search(Object o)** - 스택에서 주어진 객체(o)를 찾아서 그 위치를 반환함, 못 찾으면 -1 반환(배열과 달리 위치는 0이 아닌 1부터 시작함) 

### Queue의 메서드
* 추가하기(큐에 넣기)
	* **boolean offer(Object o)** - 큐에 객체를 저장, 성공하면 true를 반환함(예외 발생X)	
	* boolean add(Object o) - 지정된 객체를 Queue에 추가한다. 성공하면 true를 반환함 (큐의 저장공간이 부족하면 IllegalStateException 발생)
* 꺼내기(큐에서 삭제)
	* **Object poll()** - 큐에서 객체를 꺼내서 반환, 비어있으면 null을 반환(예외 발생X)
	* Object remove() - Queue에서 객체를 꺼낸다. (큐가 비어있으면 NoSuchElementException 발생)
* 슬쩍 보기(삭제 없이 요소 읽어오기)
	* **Object peek()** - 삭제 없이 요소를 읽어온다. 큐가 비어있으면 null을 반환(예외 발생X)
	* Object elememt() - 삭제 없이 요소를 읽어온다. (큐가 비어있다면 NoSuchElement 발생)

## 17 Stack과 Queue 예제
Ch11/src/Ex11_02

## 18 인터페이스를 구현한 클래스 찾기
## 19 Stack과 Queue의 활용
* 스택의 활용 예
	* 수식 계산
	* 수식 괄호 검사
	* 워드프로세서의 undo/redo
	* 웹브라우저의 뒤로/앞으로
* 큐의 활용 예
	* 최근 사용 문서
	* 인쇄 작업 대기 목록
	* 버퍼(buffer)
	
## 20 Stack과 Queue의 활용 예제1
Ch11/src/Ex11_03

## 21 Stack과 Queue의 활용 예제2
Ch11/src/Ex11_04
