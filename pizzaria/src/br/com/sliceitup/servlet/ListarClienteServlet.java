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

import br.com.sliceitup.dao.ClienteDAO;
import br.com.sliceitup.vo.ClienteVO;

@WebServlet("/listar-clientes")
public class ListarClienteServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");

		ClienteDAO daoCliente = new ClienteDAO();
		List<ClienteVO> listaClientes = daoCliente.listar(ClienteVO.class);

		PrintWriter pw = resp.getWriter();

		String gson = new Gson().toJson(listaClientes);
		pw.println(gson);
		pw.flush();

	}
}
