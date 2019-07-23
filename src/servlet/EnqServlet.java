package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EnqBeans;
import model.Vote;

/**
 * Servlet implementation class EnqServlet
 */
@WebServlet("/")
public class EnqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext application = this.getServletContext();
		EnqBeans Udon = (EnqBeans) application.getAttribute("Udon");
		EnqBeans Soba = (EnqBeans) application.getAttribute("Soba");
		EnqBeans Nodle = (EnqBeans) application.getAttribute("Nodle");

		System.out.println(Soba.getName() + Soba.getCount() + "  " + Soba.getComent());
		System.out.println(Udon.getName() + Udon.getCount() + "  " + Udon.getComent());
		System.out.println(Nodle.getName() + Nodle.getCount() + "  " + Nodle.getComent());

		/*
		//初回時のみ
		if (Udon == null && Soba == null && Nodle == null) {
			Udon = new EnqBeans();
			Udon.setName("うどん");
			Soba = new EnqBeans();
			Soba.setName("そば");
			Nodle = new EnqBeans();
			Nodle.setName("ラーメン");
		}*/

		String Men = request.getParameter("Men");
		String Coment = request.getParameter("Coment");
		Vote vote = new Vote();
		if (Men != null) {
			switch (Men) {
			case "Udon":
				vote.inCount(Udon);
				vote.inComent(Udon, Coment);
				break;

			case "Soba":
				vote.inCount(Soba);
				vote.inComent(Soba, Coment);
				break;
			case "Nodle":
				vote.inCount(Nodle);
				vote.inComent(Nodle, Coment);
				break;
			default:
				break;
			}
		}

		application.setAttribute("Udon", Udon);
		application.setAttribute("Soba", Soba);
		application.setAttribute("Nodle", Nodle);

		request.getRequestDispatcher("enquete.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
