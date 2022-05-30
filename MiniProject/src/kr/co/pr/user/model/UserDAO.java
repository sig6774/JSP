package kr.co.pr.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDAO implements IUserDAO {

	
	private DataSource ds; 
	
	public UserDAO() {
		InitialContext ct; 
		
		try {
			ct = new InitialContext();
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
	
	@Override
	public boolean checkId(String userId) {
		String sql = "SELECT * FROM pr_user WHERE user_id = ?";
		boolean flag = false;
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt  = conn.prepareStatement(sql)){
			ResultSet rs = null;
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			// 쿼리 실행 
			
			if (!rs.next()) {
				System.out.println("유효성 확인 완료");
				flag = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// flag가 true이면 동일한 아이디가 없다는 뜻이므로 true 바꿔줌 
		return flag;
	}

	@Override
	public boolean registUser(UserVO newuser) {
		String sql = "INSERT INTO pr_user VALUES(?,?,?,?,?,?)";

		boolean flag = false;
		int a = 0;
		try(Connection conn = ds.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			// ?순서에 맞게 값을 넣어줌 
			pstmt.setString(1, newuser.getUserId());
			pstmt.setString(2, newuser.getUserPw());
			pstmt.setString(3, newuser.getName());
			pstmt.setString(4, newuser.getNumber());
			pstmt.setString(5, newuser.getEmail());
			pstmt.setString(6, newuser.getAddress());
			
			a = pstmt.executeUpdate();
			// excute update는 insert, update, delete에 반영된 건수를 리턴 
			if (a > 0) {
				System.out.println("등록완료");
				flag = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				
		return flag;
	}
	@Override
	public boolean loginUser(String userId, String userPw) {
		
		String sql = "SELECT * FROM pr_user WHERE user_id = ?";
		boolean flag = false;
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			ResultSet rs = null;
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				if (rs.getString("user_pw").equals(userPw)) {
					System.out.println("로그인 완료");
					flag = true;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public boolean updatePw(String userId, String newPw) {
		
		String sql = "UPDATE PR_USER SET user_pw = ? WHERE user_id = ?";
		int a = 0;
		boolean flag = false;
		try(Connection conn = ds.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, newPw);
			pstmt.setString(2, userId);
			a = pstmt.executeUpdate();
			
			if (a>0) {
				System.out.println("비밀번호 업데이트 완료");
				flag = true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean updateUser(UserVO upuser) {
		String sql = "UPDATE PR_USER SET name = ?, telephone = ?, email = ?, address = ? WHERE user_id = ?";
		int a = 0;
		boolean flag = false;
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, upuser.getName());
			pstmt.setString(2, upuser.getNumber());
			pstmt.setString(3, upuser.getEmail());
			pstmt.setString(4, upuser.getAddress());
			pstmt.setString(5, upuser.getUserId());
			
			a = pstmt.executeUpdate();
			
			if (a > 0) {
				System.out.println("정보 업데이트 완료");
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean deleteUser(String userId) {
		String sql = "DELETE FROM PR_USER WHERE user_id = ?";
		boolean flag = false;
		int a = 0;
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, userId);
			a = pstmt.executeUpdate();
			
			if (a >0 ) {
				System.out.println("삭제 완료");
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
