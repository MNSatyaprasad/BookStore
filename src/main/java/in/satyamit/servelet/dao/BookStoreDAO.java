package in.satyamit.servelet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import in.satyamit.dto.BookDTO;
import in.satyamit.servelet.utill.ConnectionFactory;

public class BookStoreDAO {
	
	private static final String QUERY = "insert into book values (?,?,?)";
	public boolean saveBook(BookDTO dto) throws Exception {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pstmt = con.prepareStatement(QUERY);
		pstmt.setInt(1, dto.getBookId());
		pstmt.setString(2, dto.getBookName());
		pstmt.setDouble(3, dto.getPrice());
		int count = pstmt.executeUpdate();
		return count>0;
		
	}

}
