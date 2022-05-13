package kr.co.jsp.score.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;



// DAO는 웹 서버의 DB 연동 요청이 발생할 때 마다 
// DB의 CRUD(Create, Read, Update, Delete)작업을 전담하는 클래스 
public class ScoreDAO {
	// 싱글톤 디자인 패턴 (객체 생성을 단 하나로 제한하기 위한 코드 디자인 패턴)

	// 1. 클래스 외부에서 객체를 생성하지 못하게 생성자에 private 접근 제한을 붙임
	private ScoreDAO() {
		// DB와 객체를 전달할 수 있는 길 뚫어놓기
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 2. 이제 객체를 생성할 수 있는 영역은 해당 클래스 내부 뿐이므로 스스로 객체를 단 하나만 생성
	private static ScoreDAO dao = new ScoreDAO();
	// 만든 객체를 전역으로 사용하기 위해 static으로 설정
	// static이므로 외부에서 클래스의 객체에 바로 접근할 수 있는데 접근하지 못하도록 private로 해줌

	// 3. 외부에서 객체를 요구할 시 공개된 메서드를 통해 2번에서 미리 만들어 놓은 단 하나의 객체 주소값을 리턴
	// 만들어 놓은 객체만 돌려쓰기 위해 강제하는 작업
	public static ScoreDAO getInstance() {
		if (dao == null) {
			dao = new ScoreDAO();
		}
		// 호옥시나 dao가 null일때를 대비해서

		return dao;
		// dao라는 객체를 getInstance()에서만 접근할 수 있도록 하기 위해 객체 생성을 static과 private을 활용하여 생성
	}

	// ===================================================================================

	// DB관련 여러가지 작업 메서드가 들어가는 공간
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 모든 메서드에서 공용적으로 사용할 Connection 객체를 얻을 수 있는 유틸 메서드
	private Connection getConnection() throws Exception {
		// throw를 붙여서 각각의 메소드에 예외처리를 할 수 있도록 함
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "jsp";
		String upw = "jsp";

		return DriverManager.getConnection(url, uid, upw);
	}
	// DB 연결

	// 실제 데이터를 저장하는 메서드
	public boolean insert(ScoreVO vo) {
		boolean flag = false;
		String sql = "INSERT INTO scores VALUES (id_seq.NEXTVAL, ?, ?, ?, ?, ?, ?)";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMath());
			pstmt.setInt(5, vo.getTotal());
			pstmt.setDouble(6, vo.getAvg());
			// 값 넣어주기

			int rn = pstmt.executeUpdate();
			if (rn == 1) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	// 점수 목록 조회 메소드
	// 점수 목록을 모두 조회하기 때문에 특정 조건을 걸 매개변수가 존재하지 x
	public List<ScoreVO> selectAll() {
		List<ScoreVO> scoreList = new ArrayList<>();
		String sql = "SELECT * FROM scores ORDER BY id ASC";

		try {
			// 드라이버 연결
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// 쿼리 실행

			while (rs.next()) {
				ScoreVO vo = new ScoreVO(rs.getInt("id"), rs.getString("name"), rs.getInt("Kor"), rs.getInt("Eng"),
						rs.getInt("Math"), rs.getInt("Total"), rs.getDouble("Avg"));
				scoreList.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				rs.close();
				pstmt.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return scoreList;
	}
	
	// 삭제 연산수행 
	public boolean delete(int num) {
		boolean flag = false;
		String sql = "DELETE FROM scores WHERE id = ?";
		try {
			// 드라이버 연결
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			// 쿼리 실행
			
			// ?에 값을 넣어줌
			pstmt.setInt(1, num);
			
			
			// 실행 
			int rn = pstmt.executeUpdate();
			if (rn == 1) {
				flag = true;
			}
			// rn이 1이면 삭제 성공 했으므로 true로 바꿔줌
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public List<ScoreVO> search(String name) {
		List<ScoreVO> scoreList = new ArrayList<>();
		String sql = "SELECT * FROM scores WHERE name LIKE ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			// ?에 값을 넣어줌
			
			rs = pstmt.executeQuery();
			// 쿼리 실행 
			
			while (rs.next()) {
				ScoreVO vo = new ScoreVO(
						rs.getInt("id"), rs.getString("name"), rs.getInt("Kor"), rs.getInt("Eng"),
						rs.getInt("Math"), rs.getInt("Total"), rs.getDouble("Avg"));
				scoreList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				rs.close();
				pstmt.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
		return scoreList;
}
}