<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Add new barang</title>
</head>
<body>

    <form method="POST" action='BarangController' name="frmAddBarang">
        Kode Futur <input type="number" readonly="readonly" name="kodeFutur"
            value="<c:out value="${penjualan.kodeBarang}" />" /> <br /> 
        Tanggal Futur : <input
            type="text" name="tglFutur"
            value="<fmt:formatDate pattern="MM/dd/yyyy" value="${penjualan.tglFutur}" />" /> <br /> 
        Nama Konsumen : <input
            type="text" name="namaKonsumen"
            value="<c:out value="${penjualan.namaKonsumen}" />" /> <br /> 
        Jumlah : <input
            type="number" name="jumlah"
            value="<c:out value="${penjualan.jumlah}" />" /> <br /> 
        Harga Satuan : <input
            type="number" name="hargaSatuan"
            value="<c:out value="${penjualan.hargaBeli}" />" /> <br /> 
        Harga Total : <input
            type="number" name="hargaTotal"
            value="<c:out value="${penjualan.hargaTotal}" />" /> <br /> 
        Kode Barang : <input
            type="text" name="kategori"
            value="<c:out value="${penjualan.kodeBarang}" />" /> <br /> 
        <br /> <input
            type="submit" value="Submit" />
    </form>
</body>
</html>