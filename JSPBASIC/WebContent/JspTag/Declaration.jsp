<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%!
    /*
    declaration(클래스 블록)
    jsp 파일 내부에서 사용할 멤버 변수나 메서드 등을 선언할 때 사용하는 태그
        선언자에 작성한 코드는 jsp 파일이 클래스로 변환될 때 실제 클래스 블록에 선언 
        해당 클래스로 객체가 생성될 때 멤버변수(속성), 메서드(기능)로 동작하기 때문에 
        객체가 소멸하지 않는 이상 요청이 들어온다면 값을 계속 누적할 수 있고 
        메서드 호출 또한 가능
    */
    
    public int i;
    
    public int add(int n1, int n2){
    	return n1 + n2;
    }
    // declaration은 접근제한자와 메소드 선언도 가능함 
    %>
    
    <%
    /* Scriptlet(메서드 블록)
        지역변수 및 메서드 내부의 코드를 작성하는 태그 
    Scriptlet에 작성한 내용은 jsp 파일이 클래스로 변환될 때 jsp_service()라는 메서드 내부에 작성
        페이지 요청이 발생할 때마다 실행할 로직을 작성할 수 있음
    */
    
    int j = 1;
    // 선언할 때 public을 사용하면 에러가 남 즉, scriptlet에서는 접근제한자를 사용할 수 없음
    
    /* void hello() {
    	//out.print("안녕~");
     }
     Scriptlet은 접근제한자를 사용할 수 없고 메소드 선언도 불가능 */
    
    i++;
    j++;
    
    /* 클래스로 변환될 때 Scriptlet은 메서드 블록으로 가고 Declaration은 클래스 블록으로 가기 때문에 차이가 남
    	그래서 Scriptlet은 메서드 블록이기 때문에 접근 제한자가 못오고 메소드 선언도 안되는 구나
    	하지만 Declaration은 클래스 블록이기 때문에 다 가능한거네 
    	클래스 블록에 있는 변수들은 값을 지정하지 않아도 초기화(int는 0, String은 null)되는데 
    	메서드 블록에 있는 변수들은 값을 지정하지 않으면 초기화되지 않는 특징이 Scriptlet과 Declaration에 모두 나타남 
    */
    
    int result = add(7,8);
     double rn = Math.random();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Declaration</title>
</head>
<body>
	i의 값 : <%= i %> <br>
	j의 값 : <%= j %> <br>
	result 값 : <%= result %> <br>
	난수 값 <%= rn %>
	
</body>
</html>