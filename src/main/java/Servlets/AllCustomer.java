package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connect.DBConnect;
import Pojo.Customer;

@WebServlet("/AllCustomer")
public class AllCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DBConnect obj = new DBConnect();
		Connection con = obj.connect();
		String ins = "Select custid,cname,mail_id,mob from customer where cname <> 'Admin';";
		ArrayList<Customer> ls = new ArrayList<Customer>();
		try {
			PreparedStatement st = con.prepareStatement(ins);
			ResultSet rs;
			rs = st.executeQuery();
			while (rs.next()) {
				ls.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		} catch (SQLException s) {
			System.out.println("Got an exception");
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("Arraylist", ls);
		RequestDispatcher rq = request.getRequestDispatcher("AllCust.jsp");
		rq.forward(request, response);
	}
}
