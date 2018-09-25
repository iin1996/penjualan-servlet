package com.daniel.controller;

import com.daniel.dao.BarangDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.daniel.model.Barang;

public class PenjualanController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/penjualan.jsp";
    private static String LIST_BARANG = "/listPenjualan.jsp";
    private BarangDao dao;

    public PenjualanController() {
        super();
        dao = new BarangDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        
        if (action.equalsIgnoreCase("delete")){
            int kodeBarang = Integer.parseInt(request.getParameter("kodeBarang"));
            dao.deleteBarang(kodeBarang);
            forward = LIST_BARANG;
            request.setAttribute("barangs", dao.getAllBarangs());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int kodeBarang  = Integer.parseInt(request.getParameter("kodeBarang"));
            Barang barang = dao.getBarangBykode_barang(kodeBarang);
            request.setAttribute("barang", barang);
        } else if (action.equalsIgnoreCase("listBarang")){
            forward = LIST_BARANG;
            request.setAttribute("barangs", dao.getAllBarangs());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Barang barang = new Barang();
        barang.setNamaBarang(request.getParameter("namaBarang"));
        barang.setHargaJual(Integer.parseInt(request.getParameter("hargaJual")));
        barang.setHargaBeli(Integer.parseInt(request.getParameter("hargaBeli")));
        barang.setSatuan(Integer.parseInt(request.getParameter("satuan")));
        barang.setKategori(request.getParameter("kategori"));

        String kodeBarang = request.getParameter("kodeBarang");
        if(kodeBarang == null || kodeBarang.isEmpty()) {
            dao.addBarang(barang);
        } else {
            barang.setKodeBarang(Integer.parseInt(kodeBarang));
            dao.updateBarang(barang);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_BARANG);
        request.setAttribute("barangs", dao.getAllBarangs());
        view.forward(request, response);
    }
}