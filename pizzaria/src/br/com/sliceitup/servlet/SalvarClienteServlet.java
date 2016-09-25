package br.com.sliceitup.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.sliceitup.dao.ClienteDAO;
import br.com.sliceitup.vo.ClienteVO;

@WebServlet("/salvar-cliente")
public class SalvarClienteServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String strObj = (String) req.getParameter("cliente");

		ClienteVO cliente = new Gson().fromJson(strObj, ClienteVO.class);

		ClienteDAO daoCliente = new ClienteDAO();
		daoCliente.salvar(cliente);
	}
}
