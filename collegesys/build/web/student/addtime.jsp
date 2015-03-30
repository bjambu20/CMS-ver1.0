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
    String sub[] = new String[80];
    String day = "day";
    String classid = request.getParameter("classid");
    n = 0;
    for (int i = 1; i < 7; i++) {
        for (int j = 1; j < 9; j++) {
            n++;
            sub[n] = request.getParameter("p" + i + j);
        }
    }
    int num = n;
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    try {
        con = databasecon.getconnection();
        st = con.createStatement();
        int j=0;
        int i = 0;day="monday";  
        String sql1 = "insert into time_table (`day`, `period1`, `period2`, `period3`, `period4`, `period5`, `period6`, `period7`, `period8`, `classid`) values('" + day + "','" + sub[i + 1] + "','" + sub[i + 2] + "','" + sub[i + 3] + "','" + sub[i + 4] + "','" + sub[i + 5] + "','" + sub[i + 6] + "','" + sub[i + 7] + "','" + sub[i + 8] + "','" + classid + "')";
        i = 8;day="tuesday";
        String sql2 = "insert into time_table (`day`, `period1`, `period2`, `period3`, `period4`, `period5`, `period6`, `period7`, `period8`, `classid`) values('" + day + "','" + sub[i + 1] + "','" + sub[i + 2] + "','" + sub[i + 3] + "','" + sub[i + 4] + "','" + sub[i + 5] + "','" + sub[i + 6] + "','" + sub[i + 7] + "','" + sub[i + 8] + "','" + classid + "')";
        i = 16;day="wednesday";
        String sql3 = "insert into time_table (`day`, `period1`, `period2`, `period3`, `period4`, `period5`, `period6`, `period7`, `period8`, `classid`) values('" + day + "','" + sub[i + 1] + "','" + sub[i + 2] + "','" + sub[i + 3] + "','" + sub[i + 4] + "','" + sub[i + 5] + "','" + sub[i + 6] + "','" + sub[i + 7] + "','" + sub[i + 8] + "','" + classid + "')";
        i = 24;day="thursday";
        String sql4 = "insert into time_table (`day`, `period1`, `period2`, `period3`, `period4`, `period5`, `period6`, `period7`, `period8`, `classid`) values('" + day + "','" + sub[i + 1] + "','" + sub[i + 2] + "','" + sub[i + 3] + "','" + sub[i + 4] + "','" + sub[i + 5] + "','" + sub[i + 6] + "','" + sub[i + 7] + "','" + sub[i + 8] + "','" + classid + "')";
        i = 32;day="friday";
        String sql5 = "insert into time_table (`day`, `period1`, `period2`, `period3`, `period4`, `period5`, `period6`, `period7`, `period8`, `classid`) values('" + day + "','" + sub[i + 1] + "','" + sub[i + 2] + "','" + sub[i + 3] + "','" + sub[i + 4] + "','" + sub[i + 5] + "','" + sub[i + 6] + "','" + sub[i + 7] + "','" + sub[i + 8] + "','" + classid + "')";
        i = 40;day="saturday";
        String sql6 = "insert into time_table (`day`, `period1`, `period2`, `period3`, `period4`, `period5`, `period6`, `period7`, `period8`, `classid`) values('" + day + "','" + sub[i + 1] + "','" + sub[i + 2] + "','" + sub[i + 3] + "','" + sub[i + 4] + "','" + sub[i + 5] + "','" + sub[i + 6] + "','" + sub[i + 7] + "','" + sub[i + 8] + "','" + classid + "')";
        j = st.executeUpdate(sql1);
        st.executeUpdate(sql2);
        st.executeUpdate(sql3);
        st.executeUpdate(sql4);
        st.executeUpdate(sql5);
        st.executeUpdate(sql6);
   
        if (j > 1) {
            out.println("failed");
        } else {
            out.println("success");

        }
      response.sendRedirect("timetable.jsp");
    } catch (SQLException e1) {
        out.println("<div id=\"error\">");
        e1.printStackTrace(new java.io.PrintWriter(out));
        out.println("</div>");

    } finally {
        st.close();
        con.close();
    }

%>
