<%-- 
    Document   : getattendence
    Created on : Feb 13, 2015, 10:01:51 AM
    Author     : srinivasan
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="databaseconnection.databasecon"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    int n;
%>
<%
    String busno=request.getParameter("busno");
    String route = request.getParameter("route");

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    try {
        con = databasecon.getconnection();
        st = con.createStatement();
        int j=0;
        String sql1 = "insert into bus_details (`route`) values('" + route + "')";
        j = st.executeUpdate(sql1);
        if (j > 1) {
            out.println("failed");
        } else {
            out.println("success");

        }
      response.sendRedirect("Bus.jsp");
    } catch (SQLException e1) {
        out.println("<div id=\"error\">");
        e1.printStackTrace(new java.io.PrintWriter(out));
        out.println("</div>");

    } finally {
        st.close();
        con.close();
    }

%>
