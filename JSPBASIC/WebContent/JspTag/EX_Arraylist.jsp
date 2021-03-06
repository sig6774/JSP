<%@page import="java.util.Collections"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- 
    Arraylist
    - 배열과 다르게 크기가 자동으로 조절 
    - 배열과 유사한 형태이기 때문에 순차적으로 데이터에 접근하기 좋음 
    - 인덱스를 활용하며 객체의 중복 저장을 허용
    - 대부분 List라는 인터페이스로 생성 
    --%>
<% 
    List<String> nick = new ArrayList<> ();
    
    /*
    배열 -> 인덱스로 해당 영역에 바로 접근. 
    리스트 -> 메서드로 접근. (인덱스를 사용하긴 함 )
    */
    // add(객체) : 리스트에 객체를 추가하는 메서드
    
    String str = "야옹이";
    nick.add("멍멍이");
    nick.add(str);
    nick.add(new String("개구리"));
	System.out.println(nick);
	// 리스트 이름만 적어도 가능 
	
	// add(인덱스, 객체) : 특정 인덱스에 객체를 삽입하는 메서드
	nick.add(3, "어흥이");
	System.out.println(nick);
	
	// get(인덱스) : 리스트 내부의 객체를 참조하는 메서드
	String name = nick.get(3);
	System.out.println("3번 인덱스의 값: " + name);
	
	// size() : 리스트의 크기를 반환
	System.out.println("nick의 크기 : " + nick.size());
	
	// set(인덱스, 수정할 객체) : 리스트 내부의 객체를 수정 
	nick.set(2, "삐약이");
	System.out.println(nick.get(2));
	
	
	
	// remove(인덱스), remove(객체) : 값을 삭제 
//	nick.remove(5);
	
//	nick.remove(str);
	System.out.println(nick);
	// index번호가 5인 값이 삭제된 것을 확인
	
	// 리스트의 반복문 처리 
	for (int i = 0; i < nick.size(); i++){
		System.out.println(nick.get(i));
	}
	System.out.println("==============================");
	
	// 향상for문(forEach) : 값을 직접 가져올 수 있음
	for(String n : nick){
		System.out.println(n);
	}
	
	// contains(객체) : 리스트 내의 객체의 존재 유무를 파악하는 메서드
	System.out.println(nick.contains("삐약이"));
	System.out.println(nick.contains("개구리"));
	
	
	// clear() : 리스트 내부 요소 전체 삭제
	nick.clear();
	System.out.println(nick);
	
	// isEmpty() : 리스트가 비어있는지 여부를 확인하는 메서드
	System.out.println(nick.isEmpty());
	
	/*
	Collections 
	- 컬렉션 객체들의 부가 기능들을 지원
	*/
	
	List<Integer> score = new ArrayList<>();
	// List는 객체들의 모음이므로 int이렇게 적으면 에러가 남 
	
	// 한번에 객체 많이 추가하기 
	Collections.addAll(score, 78,100,61,68,67,62,70,73);
	// addALL(넣고 싶은 객체, 넣고자 하는 값들)
	System.out.println(score);
	
	// Collection 내 등장 횟수 구하기 
	System.out.println("100점 학생 수 : " + Collections.frequency(score, 100));
	// collection안에 특정 값이 몇개 등장하는지 출력
	
	// 최대값, 최소값 구하기 
	System.out.println("최대값 : " + Collections.max(score));
	System.out.println("최대값 : " + Collections.min(score));
	
	// 오름차순 정렬
	Collections.sort(score);
	System.out.println("오름차순 정렬 : " + score);
	
	// 내림차순 정렬 
	Collections.reverse(score);
	
	// 처음부터 내림차순 정렬 
	Collections.sort(score, Collections.reverseOrder());
	System.out.println("내림차순 정렬 : " + score);
	
	// swap(리스트, i, j) : 두 요소의 위치를 교체
	Collections.swap(score, 0, 5);
	System.out.println("swap 결과 : " + score);
	
	// shuffle(리스트) : 리스트 내부 요소를 무작위로 섞는 함수
	Collections.shuffle(score);
	System.out.println("shuffle 결과 : " + score);
	
	// fill(리스트, 원하는 값) : 원하는 값으로 컬렉션 초기화
	Collections.fill(score, 100);
	System.out.println("fill 결과 : " + score);
    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>