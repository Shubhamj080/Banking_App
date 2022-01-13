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
import Pojo.Banking;

@WebServlet("/BankingServlet")
public class BankingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String s1 = request.getParameter("accnum");
		int accno = Integer.parseInt(s1);
		DBConnect obj = new DBConnect();
		Connection con = obj.connect();
		String ins = "Select * from banking where acc_num=?";
		ArrayList<Banking> ls = new ArrayList<Banking>();
		try {
			PreparedStatement st = con.prepareStatement(ins);
			st.setInt(1, accno);
			ResultSet rs;
			rs = st.executeQuery();
			while (rs.next()) {
				ls.add(new Banking(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4)));
			}
		} catch (SQLException s) {
			System.out.println("Got an exception");
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("Arraylist", ls);
		RequestDispatcher rq = request.getRequestDispatcher("Banking.jsp");
		rq.forward(request, response);
	}

}
