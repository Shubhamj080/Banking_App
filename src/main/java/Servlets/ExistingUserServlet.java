package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connect.DBConnect;

@WebServlet("/ExistingUserServlet")
public class ExistingUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int acc_num = (int) (Math.random() * 10000);
		LocalDate date2 = LocalDate.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String dop = dtf.format(date2);
		double bal = 0.0;
		String status = "Active";
		String s1 = " ";
		String s2 = " ";
		s1 = request.getParameter("uid");
		int a = Integer.parseInt(s1);
		s2 = request.getParameter("acctype");

		DBConnect obj = new DBConnect();
		Connection con = obj.connect();

		String str = "insert into accounts values(?,?,?,?,?,?);";
		try {
			PreparedStatement st1 = con.prepareStatement(str);
			st1.setInt(1, acc_num);
			st1.setInt(2, a);
			st1.setString(3, s2);
			st1.setString(4, dop);
			st1.setDouble(5, bal);
			st1.setString(6, status);
			st1.execute();
		} catch (SQLException s) {
			System.out.println("Got an exception");
			s.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rq = request.getRequestDispatcher("AdminHome.jsp");
		rq.forward(request, response);
	}

}
