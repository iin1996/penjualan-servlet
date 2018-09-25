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
        Kode Barang: <input type="number" readonly="readonly" name="kodeBarang"
            value="<c:out value="${barang.kodeBarang}" />" /> <br /> 
        Nama Barang : <input
            type="text" name="namaBarang"
            value="<c:out value="${barang.namaBarang}" />" /> <br /> 
        Harga Jual : <input
            type="number" name="hargaJual"
            value="<c:out value="${barang.hargaJual}" />" /> <br /> 
        Harga Beli : <input
            type="number" name="hargaBeli"
            value="<c:out value="${barang.hargaBeli}" />" /> <br /> 
        Satuan : <input
            type="number" name="satuan"
            value="<c:out value="${barang.satuan}" />" /> <br /> 
        Kategori : <input
            type="text" name="kategori"
            value="<c:out value="${barang.kategori}" />" /> <br /> 
        <br /> <input
            type="submit" value="Submit" />
    </form>
</body>
</html>