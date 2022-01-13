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

@WebServlet("/Transfer")
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int tran_num = (int) (Math.random() * 10000);
		LocalDate date = LocalDate.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String dot = dtf.format(date);
		String s1 = " ";
		String s2 = " ";
		String s3 = " ";
		s1 = request.getParameter("accnum1");
		s2 = request.getParameter("accnum2");
		s3 = request.getParameter("amount");
		int accno1 = Integer.parseInt(s1);
		int accno2 = Integer.parseInt(s2);
		double amount = Double.parseDouble(s3);

		DBConnect obj = new DBConnect();
		Connection con = obj.connect();

		String ins = "update accounts set bal = bal-? where acct_num = ?";
		try {
			PreparedStatement st = con.prepareStatement(ins);
			st.setDouble(1, amount);
			st.setInt(2, accno1);
			st.executeUpdate();
		} catch (SQLException s) {
			System.out.println("Got an exception");
			s.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String ins2 = "update accounts set bal = bal+? where acct_num = ?";
		try {
			PreparedStatement st = con.prepareStatement(ins2);
			st.setDouble(1, amount);
			st.setInt(2, accno2);
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
			st1.setInt(2, accno1);
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
