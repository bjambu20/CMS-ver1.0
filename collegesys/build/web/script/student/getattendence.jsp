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
    String dep[] = new String[13];
    String studentid[] = new String[13];
    String date = request.getParameter("date");
   // String id = request.getParameter("id");
    String classid = request.getParameter("classid");
    String strength = request.getParameter("strength");
    int total= Integer.parseInt(strength);
    //  String staus="status1"
    for (int i = 0; i < total; i++) {

        dep[i] = request.getParameter("status" + i);
        studentid[i] = request.getParameter("studentid" + i);
        
    }
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    try {
        con = databasecon.getconnection();
        st = con.createStatement();
     for (int i = 0; i < total; i++) {
         if(dep[i]!=null){
        String sql = "insert into attendance (`date`, `value`, `student_id`, `class_id`) values('" + date + "','" + dep[i] + "','" + studentid[i] + "','" + classid + "')";
         
        int j = st.executeUpdate(sql);
         
        if (j > 1) {
            out.println("failed");
        } else {
            out.println("success");
            
        }}}
    //  session.setAttribute("id", id);
      response.sendRedirect("dashboard.jsp");
    } catch (SQLException e1) {
        out.println("<div id=\"error\">");
        e1.printStackTrace(new java.io.PrintWriter(out));
        out.println("</div>");

    } finally {
        st.close();
        con.close();
    }

%>

