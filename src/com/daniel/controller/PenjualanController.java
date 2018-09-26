package com.daniel.controller;

import com.daniel.dao.BarangDao;
import com.daniel.dao.PenjualanDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.daniel.model.Barang;
import com.daniel.model.Penjualan;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PenjualanController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/penjualan.jsp";
    private static String LIST_PENJUALAN = "/listPenjualan.jsp";
    private PenjualanDao dao;

    public PenjualanController() {
        super();
        dao = new PenjualanDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Penjualan penjualan = new Penjualan();
          try {
            Date tglFaktur = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("tgl_faktur"));
            penjualan.setTglFaktur(tglFaktur);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        penjualan.setNamaKonsumen(request.getParameter("namaKonsumen"));
        penjualan.setJumlah(Integer.parseInt(request.getParameter("jumlah")));
        penjualan.setHargaSatuan(Integer.parseInt(request.getParameter("hargaSatuan")));
        penjualan.setHargaTotal(Integer.parseInt(request.getParameter("hargaTotal")));
        penjualan.setKodeBarang(Integer.parseInt(request.getParameter("kodeBarang")));

        String kodeFaktur = request.getParameter("kodeFaktur");
        if(kodeFaktur == null || kodeFaktur.isEmpty()) {
            dao.addPenjualan(penjualan);
        } else {
            penjualan.setKodeFaktur(Integer.parseInt(kodeFaktur));
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_PENJUALAN);
        view.forward(request, response);
    }
}