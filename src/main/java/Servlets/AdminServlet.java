package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Connect.DBConnect;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String s1 = " ";
		String s2 = " ";
		s1 = request.getParameter("uname");
		s2 = request.getParameter("password");
		DBConnect obj = new DBConnect();
		Connection con = obj.connect();
		try {
			PreparedStatement st = con.prepareStatement("Select cname,pass from customer where cname = ? and pass= ?");
			st.setString(1, s1);
			st.setString(2, s2);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				if (rs.getString("cname").equalsIgnoreCase(s1) && rs.getString("pass").equals(s2)) {
					HttpSession session = request.getSession();
					session.setAttribute("User_name", s1);
					RequestDispatcher rq = request.getRequestDispatcher("AdminHome.jsp");
					rq.forward(request, response);
				} else {
					System.out.println("You Entered Wrong Credentials");
				}
			}

		} catch (SQLException s) {
			s.printStackTrace();
			System.out.println("Got an exception");

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
