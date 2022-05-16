package kr.com.jsp.user.model;

public interface IUserDAO {
	
	// 틀만 생성 
	
	// ID가 PK이므로 중복 ID 여부 검증
	boolean confirmID(String id);
	// select했을 때 있으면 중복 O없으면 중복 X 
	
	// 회원가입 처리 메서드 
	void insertUser(UserVO NEWUSER);
	
	// 로그인 유효성 검증 메서드
	int userCheck(String User_id, String User_pw);
	
	// 특정 회원의 모든 정보를 가져오는 로그인 유지 (세션)
	UserVO getUserInfo(String User_id);
	
	// 비밀번호를 변경하는 메서드 
	void changePassword(String User_id, String newPW);
	
	// 회원 정보를 수정하는 메서드 
	void updateUser(UserVO updateUser);
	
	// 회원 탈퇴를 처리하는 메서드
	void deleteUser(String User_id);
}
