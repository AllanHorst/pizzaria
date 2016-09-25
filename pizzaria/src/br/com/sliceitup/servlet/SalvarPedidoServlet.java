package br.com.sliceitup.servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.sliceitup.dao.PedidoDAO;
import br.com.sliceitup.vo.ItemPedidoVO;
import br.com.sliceitup.vo.PedidoVO;
import br.com.sliceitup.vo.SaborItemPedidoVO;

@WebServlet("/salvar-pedido")
public class SalvarPedidoServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String strObj = (String) req.getParameter("pedido");

		PedidoVO vo = new Gson().fromJson(strObj, PedidoVO.class);
		if (vo.getData() == null) {
			vo.setData(Calendar.getInstance());
		}
		vo.setStatus(alterarStatus(vo.getStatus()));
		if (vo.getStatus() == PedidoVO.STATUS_ENTREGANDO) {
			vo.setSaida(Calendar.getInstance());
		}
		for (ItemPedidoVO item : vo.getListaItens()) {
			item.setPedido(vo);
			for (SaborItemPedidoVO saborItem : item.getListaSabores()) {
				saborItem.setItemPedido(item);
			}
		}

		PedidoDAO daoPedido = new PedidoDAO();
		daoPedido.salvar(vo);

	}

	private String alterarStatus(String status) {
		if (status == null) {
			return PedidoVO.STATUS_AGUARDANDO;
		}
		if (status.equals(PedidoVO.STATUS_AGUARDANDO)) {
			return PedidoVO.STATUS_MONTANDO;
		}
		if (status.equals(PedidoVO.STATUS_MONTANDO)) {
			return PedidoVO.STATUS_ASSANDO;
		}
		if (status.equals(PedidoVO.STATUS_ASSANDO)) {
			return PedidoVO.STATUS_ENTREGANDO;
		}
		if (status.equals(PedidoVO.STATUS_ENTREGANDO)) {
			return PedidoVO.STATUS_ENTREGUE;
		}

		return PedidoVO.STATUS_CANCELADO;
	}
}
