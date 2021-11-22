package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Bean.Phongban;
import Model.Bo.BO_PB;

@WebServlet("/Controller_PB")
public class Controller_PB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// View All PB
		if (req.getParameter("Mod1") != null) {
			BO_PB bo = new BO_PB();
			ArrayList<Phongban> pbArray = null;
			pbArray = bo.GetAllPB();
			req.setAttribute("AllPB", pbArray);
			String destination = "/ViewAllPB.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(req, resp);
		}
		// Update PB
		// Update
		if (req.getParameter("Mod12") != null) {
			BO_PB bo = new BO_PB();
			ArrayList<Phongban> pbArray = null;
			pbArray = bo.GetAllPB();
			req.setAttribute("AllPB", pbArray);
			String destination = "/PBUpdate.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(req, resp);
		}
		if (req.getParameter("IDPBUD") != null) {
			BO_PB bo = new BO_PB();
			// System.out.println(req.getParameter("IDNV"));
			Phongban pb = new Phongban();
			pb = bo.GetPBbByIDPB(req.getParameter("IDPBUD"));
			req.setAttribute("PB", pb);
			String destination = "/FormUpdatePB.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("updatepb") != null) {
			BO_PB bo = new BO_PB();
			Phongban pb = new Phongban(req.getParameter("IDPB"), req.getParameter("Name"), req.getParameter("Mota"));
			bo.UpdatePB(pb);

			ArrayList<Phongban> pbArray = null;
			pbArray = bo.GetAllPB();
			req.setAttribute("AllPB", pbArray);
			String destination = "/PBUpdate.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(req, resp);
		}
	}
}
