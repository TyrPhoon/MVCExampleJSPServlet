package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Bean.Nhanvien;
import Model.Bean.Phongban;
import Model.Bo.BO_NV;
import Model.Bo.BO_PB;

@WebServlet("/Controller_NV")
public class Controller_NV extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// View All NV
		if (req.getParameter("Mod0") != null) {
			BO_NV bo = new BO_NV();
			ArrayList<Nhanvien> nvArray = null;
			nvArray = bo.GetAllNV();
			req.setAttribute("AllNV", nvArray);
			String destination = "/ViewAllNV.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(req, resp);
		}
		// View Detail
		if (req.getParameter("IDNV") != null) {
			BO_NV bo = new BO_NV();
			// System.out.println(req.getParameter("IDNV"));
			Nhanvien nv = new Nhanvien();
			nv = bo.GetNVByID(req.getParameter("IDNV"));
			req.setAttribute("NV", nv);
			String destination = "/ViewDetailNV.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(req, resp);
		}

		// Xem thong tin nhan vien trong 1 PB
		if (req.getParameter("IDPB") != null) {
			BO_NV bo = new BO_NV();
			// System.out.println(req.getParameter("IDNV"));
			ArrayList<Nhanvien> nvArray = null;
			nvArray = bo.GetNVByIDPB(req.getParameter("IDPB"));
			req.setAttribute("AllNV", nvArray);
			String destination = "/ViewAllNV.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(req, resp);
		}

		// TK
		if (req.getParameter("Mod2") != null) {
			String destination = "/FormTK.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(req, resp);
		}
		// Add
		if (req.getParameter("Mod3") != null) {
			BO_PB bo = new BO_PB();
			ArrayList<Phongban> pbArray = null;
			pbArray = bo.GetAllPB();
			req.setAttribute("AllPB", pbArray);
			String destination = "/FormAdd.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(req, resp);
		}

		// Update
		if (req.getParameter("Mod4") != null) {
			BO_NV bo = new BO_NV();
			ArrayList<Nhanvien> nvArray = null;
			nvArray = bo.GetAllNV();
			req.setAttribute("AllNV", nvArray);
			String destination = "/NVUpdate.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(req, resp);
		}
		if (req.getParameter("IDNVUD") != null) {
			BO_NV bo = new BO_NV();
			// System.out.println(req.getParameter("IDNV"));
			Nhanvien nv = new Nhanvien();
			nv = bo.GetNVByID(req.getParameter("IDNVUD"));
			req.setAttribute("NV", nv);
			BO_PB bo1 = new BO_PB();
			ArrayList<Phongban> pbArray = null;
			pbArray = bo1.GetAllPB();
			req.setAttribute("AllPB", pbArray);
			String destination = "/FormUpdate.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(req, resp);
		}
		// delete 1 nv
		if (req.getParameter("Mod5") != null) {
			BO_NV bo = new BO_NV();
			ArrayList<Nhanvien> nvArray = null;
			nvArray = bo.GetAllNV();
			req.setAttribute("AllNV", nvArray);
			String destination = "/NVDelete.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(req, resp);
		}
		if (req.getParameter("IDNVDELETE") != null) {
			BO_NV bo = new BO_NV();
			// System.out.println(req.getParameter("IDNV"));
			bo.DeleteNV(req.getParameter("IDNVDELETE"));
			ArrayList<Nhanvien> nvArray = null;
			nvArray = bo.GetAllNV();
			req.setAttribute("AllNV", nvArray);
			String destination = "/NVDelete.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(req, resp);
		}

		// delete nhieu` nv
		if (req.getParameter("Mod6") != null) {
			BO_NV bo = new BO_NV();
			ArrayList<Nhanvien> nvArray = null;
			nvArray = bo.GetAllNV();
			req.setAttribute("AllNV", nvArray);
			String destination = "/NVDeletemulti.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("insert") != null) {
			BO_NV bo = new BO_NV();
			Nhanvien nv = new Nhanvien(req.getParameter("IDNV"), req.getParameter("Name"), req.getParameter("IDPB"),
					req.getParameter("DC"));
			bo.AddNV(nv);

			ArrayList<Nhanvien> nvArray = null;
			nvArray = bo.GetAllNV();
			req.setAttribute("AllNV", nvArray);
			String destination = "/ViewAllNV.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(req, resp);
		}
		if (req.getParameter("update") != null) {
			BO_NV bo = new BO_NV();
			Nhanvien nv = new Nhanvien(req.getParameter("IDNV"), req.getParameter("Name"), req.getParameter("IDPB"),
					req.getParameter("DC"));
			bo.UpdateNV(nv);

			ArrayList<Nhanvien> nvArray = null;
			nvArray = bo.GetAllNV();
			req.setAttribute("AllNV", nvArray);
			String destination = "/NVUpdate.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(req, resp);
		}
		if (req.getParameter("search") != null) {
			String TC = req.getParameter("TC");
			String input = req.getParameter("Input");
			String query;
			switch (TC) {
			case "IDNV":
				query = "select * from nhanvien where " + TC + " ='" + input + "'";
				break;
			case "IDPB":
				query = "select * from nhanvien where " + TC + " ='" + input + "'";
				break;
			case "Name":
				query = "select * from nhanvien where Hoten like '%" + input + "%'";
				break;
			case "DC":
				query = "select * from nhanvien where DiaChi like '%" + input + "%'";
				break;
			default:
				query = "select * from nhanvien";
			}
			BO_NV bo = new BO_NV();
			ArrayList<Nhanvien> nvArray = null;
			nvArray = bo.SearchNV(query);
			req.setAttribute("TKNV", nvArray);
			String destination = "/NVTK.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(req, resp);
		}

		if (req.getParameter("Xoanhieu") != null) {
			BO_NV bo = new BO_NV();
			String[] hehe = (String[]) req.getParameterValues("MaNV");
			bo.DeleteNVMulti(hehe);
			ArrayList<Nhanvien> nvArray = null;
			nvArray = bo.GetAllNV();
			req.setAttribute("AllNV", nvArray);
			String destination = "/NVDeletemulti.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(req, resp);

		}

	}

}
