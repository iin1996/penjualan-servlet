<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Users</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>Kode Barang</th>
                <th>Nama Barang</th>
                <th>Harga Jual</th>
                <th>Harga Beli</th>
                <th>Satuan</th>
                <th>Kategori</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${barangs}" var="barang">
                <tr>
                    <td><c:out value="${barang.kodeBarang}" /></td>
                    <td><c:out value="${barang.namaBarang}" /></td>
                    <td><c:out value="${barang.hargaJual}" /></td>
                    <td><c:out value="${barang.hargaBeli}" /></td>
                    <td><c:out value="${barang.satuan}" /></td>
                    <td><c:out value="${barang.kategori}" /></td>
                    
                    <td><a href="BarangController?action=edit&kodeBarang=<c:out value="${barang.kodeBarang}"/>">Update</a></td>
                    <td><a href="BarangController?action=delete&kodeBarang=<c:out value="${barang.kodeBarang}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="BarangController?action=insert">Add Barang</a></p>
</body>
</html>