## 39 TreeSet
* **TreesSet**
	* **이진 탐색 트리 구조** 로 데이터를 저장하는 컬렉션 클래스 
		* 이진 탐색 트리(binary search tree)
			* 정렬, 검색, 범위 검색(range search)에 높은 성능을 보이는 자료 구조
			* 이진 트리(binary search)의 한 종류
		* 이진 탐색트리의 성능을 향상시킨 ‘레드-블랙 트리(Red-Black tree)’로 구현
	* **Set 인터페이스 구현**
		* 중복된 데이터의 저장X, 저장 순서 유지X(정렬된 위치에 저장) 
		* boolean add(Object o)를 호출할 경우, equals()와 hashCode()를 호출해 중복 데이터인지 확인함

* 이진 트리(binary tree)
	*  링크드 리스트처럼 여러 개의 노드가 서로 연결된 구조
		* 각 노드에 최대 2개의 노드 연결 가능
		* 루트(root)라 불리는 하나의 노드에서 시작해 계속 확장해나갈 수 있음
		* 위 아래로 연결된 두 노드를 ‘부모-자식 관계'에 있다고 함
			* 위의 노드를 부모 노드, 아래의 노드를 자식 노드라고 함
			* 부모-자식 관계는 상대적인 것
			* 하나의 부모 노드는 최대 두 개의 자식 노드와 연결될 수 있음 
```
class TreeNode { //이진 트리의 노드를 코드로 표현 
	TreeNode left; //왼쪽 자식 노드
	Object element; //객체를 저장하기 위한 참조변수 
	TreeNode right; //오른쪽 자식 노드 
}
```


## 40 이진 탐색 트리(binary search tree)
* 이진 트리의 한 종류 
	* 모든 노드는 최대 두개의 자식 노드를 가질 수 있음
		* 부모 노드의 값보다 작은 값의 자식 노드를 왼쪽에 저장
		* 부모 노드의 값보다 큰 값의 자식 노드를 오른쪽에 저장
* 정렬된 상태 유지
	* 왼쪽 마지막 값부터 오른쪽 값까지 '왼쪽 노드 -> 부모 노드 -> 오른쪽 노드’ 순으로 읽어오면 오름차순으로 정렬된 순서를 얻을 수 있음
* 뛰어난 검색 효율
	* 단일 값 검색, 범위 검색(range search)에 유리
	* 저장된 값의 개수가 많아도 검색횟수는 적게 필요	
* 데이터의 추가와 삭제에 시간이 걸림
	* 데이터를 저장할 때 순차적으로 저장하지 않고 저장 위치를 찾아서 저장
	* 삭제하는 경우 트리의 일부 재구성 필요

## 41 이진 탐색 트리의 저장과정
* 저장 과정 
	* 첫 번째로 저장되는 값은 루트가 됨 
	* 두 번째 값부터는 트리의 루트부터 시작해 값의 크기를 비교하여 트리를 따라 내려감
		* 작은 값은 왼쪽에 저장
		* 큰 값은 오른쪽에 저장
* TreeSet에 데이터를 저장할 때 예외 발생할 수 있음
	* 컴퓨터는 알아서 값을 비하지 못함 
		* TreeSet에 저장되는 객체는 Comparable을 구현해야 함
		* 혹은 Comparator을 제공해 두 객체를 비교할 방법을 알려줘야 함
* 트리 순회
	* 이진 트리의 모든 노드를 한 번씩 읽는 것 
		
## 42 TreeSet의 메서드
* Collection인터페이스에 포함된 메서드들은 대체로 제외하고 정리함 
* 생성자
	* TreeSet() - 기본 생성자
	* TreeSet(Collection c) - 주어진 컬렉션을 저장하는 TreeSet을 생성 
	* **TreeSet(Comparator comp)** - 정렬 기준 제공. 주어진 정렬조건으로 정렬하는 TreeSet을 생성
	* TreeSet(SortedSet s) - 주어진 컬렉션(SortedSet 구현) s를 저장하는 TreeSet 생성
* 추가
	* boolean add(Object o)
	* boolean addAll(Collection c)
* 삭제
	* void clear() - 지정된 모든 객체를 삭제
	* boolean remove(Object o) - 지정된 객체를 삭제
	* boolean retainAll(Collection c) - 주어진 컬렉션과 공통의 요소만 남기고 삭제(교집합) 
* 검색
	* boolean contains(Object o) - 지정된 객체가 포함되어 있는지 확인
	* boolean containsAll(Object o) - 지정된 Collection의 객체들이 모두 포함되어 있는지 확인 
	* **SortedSet subSet(Object fromElement, Object toElement)** - 범위검색(formElement~toElement)의 결과를 반환한다. 끝 범위인 toElement는 범위에 포함되지 않는다.
	* **SortedSet headSet(Object toElement)** - 지정된 객체보다 작은 값의 객체들을 반환
	* **SortedSet tailSet(Object fromElement)** - 지정된 객체보다 큰 값의 객체들을 반환	
	* NavigableSet subSet(Object fromElement, boolean fromInclusive, Object toElement, boolean toInclusive) - 범위 검색(from Element~toElement)의 결과를 반환한다. (fromInclusive가 true면 시작값이 포함되고, toInclusive가 ture면 끝값이 포함된다.)
* 반환 
	* 올림 반환
		* Object ceiling(Object o) - 지정된 객체와 같은 객체를 반환, 없으면 큰 값을 가진 객체 중 제일 가까운 값의 객체를 반환
		* Object higher(Object o) - 지정된 객체보다 큰 값을 가진 객체 중 제일 가까운 값의 객체를 반환
	* 버림 반환
		* Object floor(Object o) - 지정된 객체와 같은 객체를 반환, 없으면 작은 값을 가진 객체 중 제일 가까운 값의 객체를 반환, 없으면 null
		* Object lower(Object o) - 지정된 객체보다 작은 값을 가진 객체 중 제일 가까운 값의 객체를 반환
	* 작은 값 반환
		* Object first() - 정렬된 순서에서 첫 번째 객체를 반환
		* Object pollFirst() - TreeSet의 첫번째 요소(제일 작은 값의 객체) 반환 
	* 큰 값 반환  
		* Object last() - 정렬된 순서에서 마지막 객체를 반환
		* Object pollLast() - TreeSet의 마지막 요소(제일 큰 값의 객체) 반환
* 정렬
	* Comparator comparator() - TreeSet의 정렬기준(Comparator)을 반환
	* NavigableSet descendingSet() - TreeSet에 저장된 요소들을 역순으로 정렬해서 반환
* 복제
	* Object clone() - TreeSet을 복제하여 반환
* 그외
	* boolean isEmpty() - TreeSet이 비어있는지 확인
	* Iterator iterator() - TreeSet의 Iterator 반환
	* Spliterator spliterator() - TreeSet의 Spliterator 반환 
	* int size()
	* Object[] toArray() - 지정된 객체를 객체배열로 반환 
	* Object[] toArray(Object[] a) - 지정된 객체를 주어진 객체배열에 저장하여 반환 
 

## 43-45 TreeSet 예제1~3
* Ch11/src/Ex11_13.java
* Ch11/src/Ex11_14.java
* Ch11/src/Ex11_15.java
