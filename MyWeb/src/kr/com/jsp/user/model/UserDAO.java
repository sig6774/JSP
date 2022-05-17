package kr.com.jsp.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDAO implements IUserDAO {

	
	// Connection pool의 정보를 담을 변수 선언 
	private DataSource ds;
	
	private UserDAO() {
		try {
			InitialContext ct = new InitialContext();
			ds = (DataSource) ct.lookup("java:comp/env/jdbc/myOracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static UserDAO dao = new UserDAO();
	
	public static UserDAO getInstance() {
		if (dao == null) {
			dao = new UserDAO();
		}
		return dao;
	}
	
	/////////////////////////////////////////////////
	
	
	
	
	
	
	
	
	@Override
	public boolean confirmID(String id) {
		boolean flag = false;
		String sql = "SELECT * FROM my_user WHERE USER_ID = ?";

		/* 
		 try with resource
		 - try문을 작성할 때 자원 객체를 소괄호 안에 전달하면 try 블록이 끝날 때 자동으로 자원을 해제해줌 
		 - 자동으로 종료되는 자원은 반드시 AutoCloseable 인터페이스가 구현체여야 함 		 
		 */
		try(Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, id);
			// 쿼리에 들어갈 값 지정 
			ResultSet rs = pstmt.executeQuery();
			// 쿼리 실행 
			
			if (rs.next()) {
				flag = true;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
		// flag가 true이면 아이디가 중복이고 false면 아이디가 중복이 아님
	}

	@Override
	public void insertUser(UserVO NEWUSER) {
		String sql = "INSERT INTO my_user VALUES(?,?,?,?,?)";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, NEWUSER.getUser_id());
				pstmt.setString(2, NEWUSER.getUser_pw());
				pstmt.setString(3, NEWUSER.getUser_name());
				pstmt.setString(4, NEWUSER.getUser_email());
				pstmt.setString(5, NEWUSER.getUser_address());
				// ?에 맞도록 값 넣어줌 
				
				pstmt.executeUpdate();
				// sql 실행 
				
				System.out.println("회원가입성공");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Override
	public int userCheck(String User_id, String User_pw) {
//		String sql = "SELECT USER_ID, USER_PW, CASE WHEN USER_ID = ? AND USER_PW = ? THEN 1" + 
//				"WHEN USER_ID = ? THEN 0 " + 
//				"ELSE -1 END AS USERCHECK " + 
//				"FROM my_user";
		// 오류 발생 https://nackwon.tistory.com/107 블로그 정리 
		// CASE WHEN THEN을 활용하여 값을 지정해줌
		
		String sql1 = "SELECT * FROM my_user WHERE USER_ID = ?";
		// 다른 방법 
			// 그냥 where에 id 비교해서 pw만 가져오는 sql 작성
				// 만약 없다면 -1 
				// db에서 가져온 pw와 매개변수로 받은 pw가 같다면 1 아니면 0으로 반환 
			
		int num = 10000000;
		// sql의 3가지 조건에 부합하지 않는다면 위의 숫자를 출력 
//		try(Connection conn = ds.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(sql)){
//				ResultSet rs = null;
//				// select를 실행하기 위해 resultset 설정 
//				
//				pstmt.setString(1, User_id);
//				pstmt.setString(2, User_pw);
//				pstmt.setString(3, User_id);
//				rs = pstmt.executeQuery();
//				// 쿼리 실행 
//				if(rs.next()) num = rs.getInt("USERCHECK");
//				// https://acua.tistory.com/72 오류발생 
//				// CASE WHEN THEN을 통해 만든 컬럼을 가져옴 
//				
//		}catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		// sql1을 적용하기 위한 코드 
		try(Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql1)){
				pstmt.setNString(1, User_id);
				ResultSet rs = pstmt.executeQuery();
				
				if (rs.next()) {
					// 조회가 되었다면
					String dbPw = rs.getString("USER_PW");
					if (dbPw.equals(User_pw)) {
						num = 1;
						// id와 pw가 같다면
					} else {
						num = 0;
						// id는 같지만 pw가 틀리다면 
					}
				}
				else {
					// 조회가 되지 않았다면
					num = -1;
				}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return num;
	}

	@Override
	public UserVO getUserInfo(String User_id) {
		// 아이디를 통해서 모든 값 가져오기 
		String sql = "SELECT * FROM my_user WHERE USER_ID = ?";
		
		UserVO user = null;
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
				ResultSet rs = null;
				pstmt.setNString(1, User_id);
				rs = pstmt.executeQuery();
				// Query 실행 
				
				if (rs.next()) {
					user = new UserVO(rs.getString("USER_ID"),
							rs.getString("USER_PW"),
							rs.getString("USER_NAME"),
							rs.getString("USER_EMAIL"),
							rs.getString("USER_ADDRESS"));
							System.out.println("유저 정보 입력 완료");
							// 값을 가져와서 UserVO객체에 넣어줌
				}
				
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void changePassword(String User_id, String newPW) {
		String sql = "UPDATE my_user SET USER_PW = ? WHERE USER_ID = ?";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, newPW);
				pstmt.setString(2, User_id);
				pstmt.executeUpdate();
				// 쿼리에 ?값을 넣고 실행 
				
				System.out.println("비밀번호 변경 성공");
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateUser(UserVO updateUser) {
		String sql = "UPDATE my_user SET USER_NAME = ?, USER_EMAIL = ?, USER_ADDRESS = ? WHERE USER_ID = ?";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, updateUser.getUser_name());
			pstmt.setString(2, updateUser.getUser_email());
			pstmt.setString(3, updateUser.getUser_address());
			pstmt.setString(4, updateUser.getUser_id());
			pstmt.executeUpdate();
			// ?에 값을 넣어주고 쿼리 실행 
			
			System.out.println("회원정보 수정 성공");
		}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	@Override
	public void deleteUser(String User_id) {
		String sql = "DELETE FROM my_user WHERE USER_ID = ?";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, User_id);
			pstmt.executeUpdate();
			// ?에 값을 넣고 쿼리 실행 
			
			System.out.println("회원정보 삭제 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

