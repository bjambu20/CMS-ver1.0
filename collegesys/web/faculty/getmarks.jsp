<%-- 
    Document   : getattendence
    Created on : Feb 13, 2015, 10:01:51 AM
    Author     : srinivasan
--%>

<%@page import="databaseconnection.Sms"%>
<%@page import="java.sql.SQLException"%>
<%@page import="databaseconnection.databasecon"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Sms sms=new Sms();
    String dep[] = new String[100];
    String asub[] = new String[100];
    String bsub[] = new String[100];
    String csub[] = new String[100];
    String dsub[] = new String[100];
    String esub[] = new String[100];
    String fsub[] = new String[100];

    String studentid[] = new String[13];
    String date = request.getParameter("date");
   // String id = request.getParameter("id");
    String classid = request.getParameter("classid");
    String test = request.getParameter("test");
    String strength = request.getParameter("strength");
    int total= Integer.parseInt(strength);
    Connection con = null;
    Statement st = null;
    
    
    ResultSet rs = null;
    int j=0;
    //  String staus="status1"
     try {
        con = databasecon.getconnection();
        st = con.createStatement();
    for (int i = 1; i < total; i++) {

        asub[i] = request.getParameter("asub" + i);
        bsub[i] = request.getParameter("bsub" + i);
        csub[i] = request.getParameter("csub" + i);
        dsub[i] = request.getParameter("dsub" + i);
        esub[i] = request.getParameter("esub" + i);
        fsub[i] = request.getParameter("fsub" + i);
        studentid[i] = request.getParameter("studentid" + i);
        
        String sql = "insert into "+test+"  (`student_id`, `class_id`, `sub1`, `sub2`, `sub3`, `sub4`, `sub5`, `sub6`) values('" + studentid[i] + "','" + classid + "','" + asub[i] + "','" + bsub[i] + "','" + csub[i] + "','" + dsub[i] + "','" + esub[i] + "','" + fsub[i] + "')";
        j = st.executeUpdate(sql);
        
        
    }
 
        if (j > 1) {
            out.println("failed");
        } else {
            out.println("success");
            
        }
    //  session.setAttribute("id", id);
      response.sendRedirect("marksheet.jsp");
    } catch (SQLException e1) {
        out.println("<div id=\"error\">");
        e1.printStackTrace(new java.io.PrintWriter(out));
        out.println("</div>");

    } finally {
        st.close();
        con.close();
    }

%>

