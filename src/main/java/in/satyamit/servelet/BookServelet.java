package in.satyamit.servelet;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.satyamit.dto.BookDTO;
import in.satyamit.servelet.dao.BookStoreDAO;

@WebServlet("/bookstore")
public class BookServelet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		try {
			// capture fromdata
			String bookName = req.getParameter("bookName");
//call dao method by giving form data
			BookStoreDAO dao = new BookStoreDAO();
			int id = Integer.parseInt(req.getParameter("bookId"));
			double prie = Double.parseDouble(req.getParameter("price"));
			
			BookDTO dto = new BookDTO();
			dto.setBookId(id);
			dto.setBookName(bookName);
			dto.setPrice(prie);
			boolean status = dao.saveBook(dto);
//send response to client 
			PrintWriter pw = res.getWriter();
			String response = null;
			if (status) {
				response = "Record Instreted";
			} else {
				response = "Record Insertion Failed";
			}
			pw.write(response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
