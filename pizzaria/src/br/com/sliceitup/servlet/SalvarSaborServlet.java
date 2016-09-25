package br.com.sliceitup.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.sliceitup.dao.SaborDAO;
import br.com.sliceitup.vo.SaborVO;

@WebServlet("/salvar-sabor")
public class SalvarSaborServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String strObj = (String) req.getParameter("sabor");

		SaborVO sabor = new Gson().fromJson(strObj, SaborVO.class);

		SaborDAO daoCliente = new SaborDAO();
		daoCliente.salvar(sabor);
	}
}
