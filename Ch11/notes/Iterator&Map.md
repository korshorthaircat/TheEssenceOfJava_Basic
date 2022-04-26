## 22 Iterator, ListIterator, Enumeration
* 용도
	* 컬렉션에 저장된 데이터에 접근하기 위해(읽어오기 위해) 사용하는 인터페이스
	* 다양한 컬렉션들에 저장된 요소들을 읽어오는 방법을 표준화함
* **Iterator**
	* 컬렉션에 저장된 요소에 접근하는데 사용되는 인터페이스
	* 읽어올 요소가 있는지 확인하고hasNext() —> 요소를 읽어온다next()
* ListIterator
	* Iterator에 양방향 조회 기능을 추가함(List를 구현한 경우만 사용 가능)
* Enumeration
	* Iterator의 구버전

### Iterator 인터페이스의 메서드들
* **boolean hasNext()** - 읽어올 요소가 남아있는지 확인한다. 있으면 true, 없으면 false를 반환
* **Object next()** - 다음 요소를 읽어온다. next()를 호출하기 전에 hasNext()를 호출해서 읽어올 요소가 있는지 미리 확인하는 것이 안전하다.
* void remove() - next()로 읽어온 요소를 삭제한다. next()를 호출한 다음에 remove()를 호출해야한다.(선택적 기능)

### Iterator의 사용
* Collection인터페이스에는 ‘Iterator를 구현한 클래스의 인스턴스’를 반환하는 iterator()를 정의하고 있음
	* List, Set, Map 등 컬렉션마다 데이터의 구조가 다르기 때문에, 저장된 요소를 읽어오는 코드도 달라져야 함 —> 이 때 데이터를 편리하게 읽어오기 위해 표준화한것이 Iterator
* 컬렉션에 Iterator()를 호출해 Iterator를 구현한 객체를 얻어서 사용함 
```
List list = new ArayList(); //다른 컬렉션으로 변경할 때는 이 부분만 고치면 된다.
Iterator it = list.iterator(); //컬렉션에 Iterator() 호출

while(it.hasNext()) { //boolean hasNext()로 읽어올 요소가 있는지 확인 
	System.out.println(it.next()); //Object next()로 다음 요소를 읽어옴
}	
```

## 23 Iterator, ListIterator, Enumeration 예제
Ch11/src/Ex11_05

## 24 Map과 Iterator
* Map에는 iterator()가 없다
	*  iterator()는 Collection인터페이스에 정의되어 있다.
	* Map은 Lists, Set과는 다르게 Collection인터페이스의 자손이 아니다. 
	* 따라서 Map에는 iterator()가 없다.

* Map에 저장된 요소를 읽어오려면?
	* **keySet()**, **entrySet()**, **values()** 같은 메서드를 통해 Set이나 Collections를 얻은 후 
	* --> 그렇게 얻어온 Set이나 Collections에 대하여 다시 iterator()를 호출해 Iterator객체를 얻어와야 한다. 
```
Map map = new HashMap();
...
Iterator it = map.entrySet().iterator();
//Set eSet = map.entrySet();
//Iterator it =eSet.iterator();
```
