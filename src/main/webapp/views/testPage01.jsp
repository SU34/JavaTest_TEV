<%--
  Created by IntelliJ IDEA.
  User: evg_uh
  Date: 03.11.17
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/datatables/1.10.15/media/css/dataTables.bootstrap.min.css">

    <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/jquery/3.2.1/dist/jquery.min.js" defer></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js" defer></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/datatables/1.10.15/media/js/jquery.dataTables.min.js" defer></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/datatables/1.10.15/media/js/dataTables.bootstrap.min.js" defer></script>


    <!-- my scripts-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/forTestPage01.js"
            defer></script>
    <!-- -->

    <title>testPage01</title>
</head>
<body>

<!--datatable table -->
<table id="testIntervalTable" class="compact table-bordered3" width="500" align="center">
    <thead>
    <tr>
        <th>id</th>
        <th>start_i</th>
        <th>end_i</th>
    </tr>
    </thead>
</table>
<!-- -->

</body>
</html>
