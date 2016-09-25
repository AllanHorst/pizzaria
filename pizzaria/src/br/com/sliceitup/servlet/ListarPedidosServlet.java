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

import br.com.sliceitup.dao.PedidoDAO;
import br.com.sliceitup.vo.PedidoVO;

@WebServlet("/listar-pedidos")
public class ListarPedidosServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		
		PedidoDAO daoPedido = new PedidoDAO();
		List<PedidoVO> listaPedido = daoPedido.listar(PedidoVO.class);

		PrintWriter pw = resp.getWriter();

		String gson = new Gson().toJson(listaPedido);
		pw.println(gson);
		pw.flush();
	}
}
