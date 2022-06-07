package kr.co.pr.user.model;

public interface IUserDAO {
	
	// 유저 아이디가 있는지 확인 
	boolean checkId(String userId);
	
	// 유저 정보 등록 
	boolean registUser(UserVO newuser);
	
	// 유저 로그인 
	boolean loginUser(String userId, String userPw);
	
	// 유저 pw 수정 
//	boolean updatePw(String userId, String newPw);
	
	// 유저 다른 정보 수정 
	boolean updateUser(UserVO upuser);
	
	// 유저 삭제 
	boolean deleteUser(String userPw);
	
	// 유저 정보 가져오기 
	UserVO userInfo(String userId, String userPw);
	
}
