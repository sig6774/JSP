package kr.co.jsp.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO implements IBoardDAO {
	
	// Connection pool
	private DataSource ds;
	
	// 객체를 생성할 때 connection pool 연결
	private BoardDAO() {
		try {
			InitialContext ct = new InitialContext();
			
			// connection pool 대입
			ds = (DataSource) ct.lookup("java:comp/env/jdbc/myOracle");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// Singleton
	private static BoardDAO dao = new BoardDAO();
	
	// 단 하나의 객체의 주소값만 반환 
	public static BoardDAO getInstance() {
		if (dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}

	///////////////////////////////////////////////
	
	@Override
	public void regist(String writer, String title, String content) {
		String sql = "INSERT INTO my_board(board_id, writer, title, content) VALUES(board_seq.NEXTVAL, ?, ?, ?)";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
		
	

	@Override
	public List<BoardVO> listBoard() {
		List<BoardVO> articles = new ArrayList<>();
		String sql = "SELECT * FROM my_board ORDER BY board_id DESC";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
						ResultSet rs = pstmt.executeQuery()){
			
			while (rs.next()) {
				BoardVO board = new BoardVO(
						rs.getInt("board_id"),
						rs.getString("writer"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getTimestamp("reg_date"),
						rs.getInt("hit")
						);
				articles.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return articles;
	}

	@Override
	public BoardVO contentBoard(int Boardid) {
		BoardVO board = null;
		String sql = "SELECT * FROM my_board WHERE board_id = ?";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			// DB 연결 
			pstmt.setInt(1, Boardid);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board = new BoardVO(
						rs.getInt("board_id"),
						rs.getString("writer"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getTimestamp("reg_date"),
						rs.getInt("hit"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return board;
	}

	@Override
	public void updateBoard(String title, String content, int Boardid) {
		String sql = "UPDATE my_board SET title = ?, content = ? WHERE board_id = ?";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, Boardid);
			pstmt.executeUpdate();
			// 쿼리 실행 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	}

	@Override
	public void deleteBoard(int Boardid) {
		String sql = "DELETE FROM my_board WHERE board_id = ?";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, Boardid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 
	@Override
	public List<BoardVO> searchBoard(String keyword, String category) {
		List<BoardVO> boards = new ArrayList<>();
		String sql = "SELECT * FROM my_board WHERE " + category + " LIKE ?";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, "%" + keyword + "%");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO board = new BoardVO(
						rs.getInt("BOARD_ID"),
						rs.getString("WRITER"),
						rs.getString("TITLE"),
						rs.getString("CONTENT"),
						rs.getTimestamp("REG_DATE"),
						rs.getInt("HIT")
						);	
				boards.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boards;
	}
	
	// hit를 올리기 위한 로직 
	@Override
	public void upHit(int Boardid) {
		String sql = "UPDATE my_board SET hit = hit+1 WHERE board_id = ?";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, Boardid);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
