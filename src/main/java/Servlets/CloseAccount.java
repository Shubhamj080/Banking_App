package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connect.DBConnect;

@WebServlet("/CloseAccount")
public class CloseAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String s1 = request.getParameter("cusid");
		int a = Integer.parseInt(s1);
		String s2 = request.getParameter("accnum");
		int b = Integer.parseInt(s2);
		DBConnect obj = new DBConnect();
		Connection con = obj.connect();
		String bandel = "delete from banking where acc_num = ?;";
		try {
			PreparedStatement st2 = con.prepareStatement(bandel);
			st2.setInt(1, b);
			st2.executeUpdate();
		} catch (SQLException s) {
			s.printStackTrace();
			System.out.println("Got an exception");

		} catch (Exception e) {
			e.printStackTrace();
		}

		String accdel = "delete from accounts where cust_id = ?;";
		try {
			PreparedStatement st = con.prepareStatement(accdel);
			st.setInt(1, a);
			st.executeUpdate();
		} catch (SQLException s) {
			s.printStackTrace();
			System.out.println("Got an exception");

		} catch (Exception e) {
			e.printStackTrace();
		}

		String cusdel = "delete from customer where custid = ?;";
		try {
			PreparedStatement st1 = con.prepareStatement(cusdel);
			st1.setInt(1, a);
			st1.executeUpdate();
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
		RequestDispatcher rq = request.getRequestDispatcher("AdminHome.jsp");
		rq.forward(request, response);
	}

}
