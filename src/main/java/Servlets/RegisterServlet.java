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

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int acc_num = (int) (Math.random() * 10000);
		int cust_id = (int) (Math.random() * 10000);
		LocalDate date2 = LocalDate.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String dop = dtf.format(date2);
		double bal = 0.0;
		String status = "Active";
		String s1 = " ";
		String s2 = " ";
		String s3 = " ";
		String s4 = " ";
		String s5 = " ";
		String s6 = " ";
		String s7 = " ";
		s1 = request.getParameter("uname");
		s2 = request.getParameter("udob");
		s3 = request.getParameter("upass");
		s4 = request.getParameter("uemail");
		s5 = request.getParameter("umob");
		s6 = request.getParameter("acctype");
		s7 = request.getParameter("utype");

		DBConnect obj = new DBConnect();
		Connection con = obj.connect();
		String ins = "insert into customer values(?,?,?,?,?,?,?);";
		try {
			PreparedStatement st = con.prepareStatement(ins);
			st.setInt(1, cust_id);
			st.setString(2, s1);
			st.setString(3, s2);
			st.setString(4, s4);
			st.setString(5, s3);
			st.setString(6, s5);
			st.setString(7, s7);
			st.execute();
		} catch (SQLException s) {
			System.out.println("Got an exception");
			s.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String str = "insert into accounts values(?,?,?,?,?,?);";
		try {
			PreparedStatement st1 = con.prepareStatement(str);
			st1.setInt(1, acc_num);
			st1.setInt(2, cust_id);
			st1.setString(3, s6);
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
