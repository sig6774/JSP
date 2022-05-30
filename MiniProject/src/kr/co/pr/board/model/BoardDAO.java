package kr.co.pr.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO implements IBoardDAO {
	
	private DataSource ds;
	
	private BoardDAO() {
		try {
			InitialContext ct = new InitialContext();
			ds = (DataSource) ct.lookup("java:comp/env/jdbc/myOracle");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static BoardDAO dao = new BoardDAO();
	
	public static BoardDAO getInstance() {
		if (dao == null) {
			dao = new BoardDAO();
		}
		
		return dao;
	}

	@Override
	public void regist(String title, String writer, String content) {
		String sql = "INSERT INTO PR_BOARD VALUES(pr_board_id_seq.NEXTVAL, ?, ?, ?, sysdate)";
		try(Connection conn = ds.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			pstmt.setString(3, content);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<BoardVO> listBoard() {
		List<BoardVO> boards = new ArrayList<>();
		String sql = "SELECT * FROM PR_BOARD ORDER BY BOARD_ID asc";
		try(Connection conn = ds.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql); 
				ResultSet rs = pstmt.executeQuery()){
			while (rs.next()) {
				BoardVO board = new BoardVO(
						rs.getInt("board_id"),
						rs.getString("title"),
						rs.getString("writer"),
						rs.getString("content"),
						rs.getTimestamp("reg_date")
						);
				boards.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boards;
	}

	@Override
	public BoardVO contentBoard(int boardId) {
		BoardVO board = null;
		String sql = "SELECT * FROM PR_BOARD WHERE board_id = ?";
		try(Connection conn = ds.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, boardId);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				board = new BoardVO(
						rs.getInt("board_id"),
						rs.getString("title"),
						rs.getString("writer"),
						rs.getString("content"),
						rs.getTimestamp("reg_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return board;
	}

	@Override
	public void updateBoard(int boardId, String title, String content) {
		String sql = "UPDATE pr_board SET title = ?, content = ? WHERE board_id = ?";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, boardId);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBoard(int boardId) {
		String sql = "DELETE FROM pr_board WHERE board_id = ?";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, boardId);
			pstmt.executeUpdate();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
