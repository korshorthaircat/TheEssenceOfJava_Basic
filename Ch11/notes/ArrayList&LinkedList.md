## 07 ArrayList 
* ArrayList
	* List 인터페이스를 구현 
		* —> 데이터의 **저장 순서가 유지되고 중복을 허용함**
	* 기존의 **Vector클래스를 개선**한 것
		* Vector와 구현 원리와 기능적인 측면이 동일
		* Vector는 동기화 처리 되어있으나, ArrayList는 동기화 처리 되어있지 않음
	* 데이터의 저장 공간으로 **배열** 사용 (배열 기반)
		* Object배열을 이용해 데이터를 순차적으로 저장함
			* 첫번째로 저장한 객체는 Object배열의 0번째 위치에 저장됨. 이런 식으로 계속 배열에 순서대로 저장함
			* 배열에 더이상 저장할 공간이 없으면 새로운 배열을 생성해 기존의 배열에 저장된 내용을 새로운 배열로 복사한 다음 저장
			
## 08 ArrayList의 메서드
* 생성자
	* ArrayList() - 기본 생성자
	* ArrayList(Collection c) - 매개변수로 주어진 컬렉션이 저장된 ArrayList 생성(컬렉션끼리 변환할 때 자주 사용)
	* ArrayList(int initialCapacity) - 지정된 초기용량을 갖는 ArrayList 생성
* 추가
	* boolean add(Object o) - 리스의 마지막에 객체를 추가(성공하면 true)
	* void add(int index, Object element) -지정된 위치(index)에 객체를 저장
	* boolean addAll(Collection c) - 주어진 컬렉션의 모든 객체를 저장
	* boolean addAll(int index, Collection c) - 지정된 위치(index)부터 주어진 컬렉션의 모든 객체를 저장
* 삭제
	* void clear() - ArrayList를 완전히 비움
	* boolean remove(Object o) - 지정한 객체를 삭제함
	* Object remove(int index) - 지정된 위치(index)에 있는 객체를 삭제함
	* boolean removeAll(Collection c) - 지정한 컬렉션에 저장된것과 동일한 객체들을 ArrayList에서 전부 삭제함
	* boolean retainAll(Collection c) - ArrayList 저장된 객체 중 주어진 컬렉션과 공통의 것만 남기고 나머지는 삭제함(차집합)
* 복제
	* Object clone() - ArrayList를 복제함
* 검색
	* int indexOf(Object o) - 지정된 객체가 어느 위치(index)에 있는지 찾아 반환(못 찾으면 -1 반환)
	* int lastIndexOf(Object o) - 지정된 객체가 어느 위치(index)에 있는지 끝부터 역방향으로 찾아 반환
	* boolean contains(Object o) - 지정된 객체가 ArrayList에 포함되어있는지 확인
	* Object get(int index) - 지정된 위치(index)에 저장된 객체를 반환(읽기)
	* Object set(int index, Object element) - 지정된 위치(index)에 주어진 객체(element)를 저장(변경하기)
*  정렬
	* void sort(Comparator c) - 지정된 정렬기준 c로 ArrayList를 정렬
* 그외
	* int size() - ArrayList에 저장된 객체의 개수를 반환
	* boolean isEmpty() - 비어있는지 확인
	* 	void trimToSize() - 용량을 크기에 맞게 줄임(빈 공간을 없앰)
	* List subList(int fromIndex, int toIndex) - fromIndex부터 toIndex까지의 객체를 뽑아내서 새로운 리스트를 만듦
	* Object[] toArray() - ArrayList에 저장된 모든 객체들을 객체배열로 반환
	* Object[] toArray(Object[] a) - ArrayList에 저장된 모든 객체들을 객체배열 a에 담아 반환

## 09 ArrayList 예제
Ch11/src/Ex11_01.java

## 10 ArrayList의 삭제(와 추가)
* 과정
	* 1) 삭제할 데이터의 아래에 있는 데이터를 한 칸씩 위로 복사해 삭제할 데이터를 덮어쓴다.
	* 2) 데이터가 모두 한 칸씩 위로 이동하였으므로, 마지막 데이터는 null로 변경해야 한다.
		* **만일 삭제할 객체가 마지막 데이터라면, 복사할 필요 없이** 단순히 null로 변경해주면 된다. 
	* 3) 데이터가 삭제되어 데이터의 개수(size)가 줄었으므로 size의 값을 1 감소시킨다	
* 효율
	* 배열의 중간에 위치한 객체를 추가하거나 삭제하는 경우 
		* —> 다른 데이터의 위치를 이동시켜야 하기 때문에 작업시간이 오래 걸린다.   
	* 배열에 객체를 순차적으로 저장할 때와 객체를 마지막에 저장된 것부터 삭제하는 경우 
		* —>  데이터를 옮기는 과정이 필요 없으므로 작업 시간이 짧게 걸린다.
	
### ArrayList에 저장된 객체의 삭제 과정과 효율성
* ArrayList에 저장된 첫번째 객채부터 삭제할 경우 —> 배열의 복사 발생(성능도 나쁘고 잘 지워지지도 않음)
```
for(int i=0; i<list.size(); i++)
	list.remove(i);	
```
* ArrayList에 저장된 마지막 객체부터 삭제할 경우 —> 배열의 복사 발생X(빠르다!)
```
for(int i=list.size()-1; i>=0; i--)
	list.remove(i);	
```

## 11 JavaAPI 소스 보기
* JavaAPI에서 제공하는 기본 클래스들의 실제 소스 구경하기
	* JDK 설치 디렉토리에서 src.zip 압축 해제해 패키지별로 찾아 들어가 구경하기
	* 이클립스에서는
		* 소스를 보고 싶은 클래스나 메서드에서 우클릭 > Open Declaration > Attach Source… > External Location에서 jdk가 설치된 경로 알려주기 

## 12 LinkedList
* 배열의 장단점
	* 장점
		* 구조가 간단함, 데이터 읽어오는데 걸리는 시간(access time, 접근 시간)이 짧음
	* 단점
		* 실행 중에 크기를 변경할 수 없음
			* 크기를 변경해야 하는 경우 새로운 배열을 생성해 데이터 복사해야 함
			* 실행속도 향상을 위해 충분히 큰 크기의 배열을 생성해야 하므로 메모리가 낭비됨
		* 비순차적인 데이터의 추가 또는 삭제에 시간이 많이 걸림 
			* 참고) 순차적 추가 또는 삭제의 경우 빠름
			* 하지만 배열의 중간에 데이터를 추가하려면 빈자리를 만들기 위해 다른 데이터들을 복사해 이동해야 함 

* 배열의 단점을 보완하기 위한 LinkedList
	* 배열은 모든 데이터가 연속적으로 존재함
	* 링크드리스트는 불연속적으로 존재하는 데이터를 연결(link)한 형태로 구성
	* 링크드리스트의 각 요소(node)는 참조(자신과 연결될 다음 요소에 대한 주소값)와 데이터로 구성됨
```
class node {
	Node next; //다음 요소의 주소를 저장
	Object obj; //데이터를 저장 
}
```

## 13 LinkedList의 추가와 삭제
* LinkedList의 데이터 삭제
	* 삭제하고자 하는 요소의 이전 요소가 삭제하고자 하는 요소의 다음 요소를 참조하도록 참조를 변경하면 됨
* LinkedList의 데이터 추가
	* 새로운 요소를 생성한 다음 추가하고자 하는 위치의 이전 요소의 참조를 새로운 요소에 대한 참조로 변경하면 됨
* LinkedList의 데이터 추가와 삭제는 *참조만 변경*하면 되므로 처리속도 매우 *빠르다*!

## 14 ArrayList와 LinkedList의 비교
* 배열
	* 각 요소들이 연속적으로 메모리상에 존재함
	* 따라서 만일 인덱스가 n인 원소의 값을 가져오고자 한다면 간단히 계산해 알 수있음
		* 인덱스가 n인 데이터의 주소 = 배열의 주소 + n * 데이터 타입의 크기
* 연결 리스트(LinkedList)
	* 불연속적으로 위치한 각 요소들이 서로 연결됨
	* 따라서 원하는 값을 얻기 위해 처음부터 n번째 데이터까지 차례대로 따라가야만 함 
		* —> **접근시간(access time)이 길어진다!** 
* 이중 연결 리스트(DoublyLinkedList)
	* 링크드리스트의 접근성 나쁜점을 보안하기 위해 고안됨
	* 이전 노드와 다음 노트의 참조를 모두 가짐(연결이 두 개) --> 앞뒤로 이동 가능
```
class Node {
	Node next; //참조1
	Node previous; //참조2
	Object obj; //데이터를 저장
}
```
* 이중 원형 연결 리스트(Doubly Circular Linked List)
	* 첫번째 노드와 마지막 노드를 연결

### ArrayList와 LinkedList의 성능 비교

| 컬렉션 | 읽기(접근 시간) | 추가/삭제 | 특징 |
|:---:|:---:|:---:|:---:|
| ArrayList | 빠르다 | 느리다 | 순차적 추가 삭제는 더 빠름<br> 비효율적 메모리 사용<br> 데이터 개수 변하지 않을 때 좋음 |
| LinkedList | 느리다 | 빠르다 | 데이터가 많을수록 접근성 떨어짐<br> 데이터 개수 변경이 잦을 때 좋음 |
