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

@WebServlet("/Withdraw")
public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int tran_num = (int) (Math.random() * 10000);
		LocalDate date = LocalDate.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String dot = dtf.format(date);

		String s1 = " ";
		String s2 = " ";
		s1 = request.getParameter("accnum");
		int accnum = Integer.parseInt(s1);
		s2 = request.getParameter("amount");
		double amount = Double.parseDouble(s2);

		DBConnect obj = new DBConnect();
		Connection con = obj.connect();

		String ins = "update accounts set bal = bal-? where acct_num = ?";
		try {
			PreparedStatement st = con.prepareStatement(ins);
			st.setDouble(1, amount);
			st.setInt(2, accnum);
			st.executeUpdate();
		} catch (SQLException s) {
			System.out.println("Got an exception");
			s.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String str = "insert into banking values(?,?,?,?)";
		try {
			PreparedStatement st1 = con.prepareStatement(str);
			st1.setInt(1, tran_num);
			st1.setInt(2, accnum);
			st1.setString(3, dot);
			st1.setDouble(4, amount);
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
		RequestDispatcher rq = request.getRequestDispatcher("UserHome.jsp");
		rq.forward(request, response);
	}

}
