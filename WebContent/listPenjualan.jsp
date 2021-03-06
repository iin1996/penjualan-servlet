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
                <th>Kode Futur/th>
                <th>Tanggal Futur</th>
                <th>Nama KOnsumen</th>
                <th>Kode Barang</th>
                <th>JUmlah</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${penjualans}" var="penjualan">
                <tr>
                    <td><c:out value="${penjualan.kodeFutur}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${penjualan.tglFutur}" /></td>
                    <td><c:out value="${penjualan.namaKonsumen}" /></td>
                    <td><c:out value="${penjualan.kodeBarang}" /></td>
                    <td><c:out value="${penjualan.jumlah}" /></td>
                    <td><c:out value="${penjualan.satuan}" /></td>       
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="PenjualanController?action=insert">Add Penjualan</a></p>
</body>
</html>