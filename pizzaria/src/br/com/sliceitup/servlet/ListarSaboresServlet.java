package br.com.sliceitup.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.sliceitup.dao.SaborDAO;
import br.com.sliceitup.vo.SaborVO;

@WebServlet("/listar-sabores")
public class ListarSaboresServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");

		SaborDAO daoSabor = new SaborDAO();
		List<SaborVO> listaSabores = daoSabor.listar(SaborVO.class);

		PrintWriter pw = resp.getWriter();

		String gson = new Gson().toJson(listaSabores);
		pw.println(gson);
		pw.flush();
	}
}
