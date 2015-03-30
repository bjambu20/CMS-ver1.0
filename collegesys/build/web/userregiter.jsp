
<%@page import="java.sql.SQLException"%>
<%@page import="databaseconnection.databasecon"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
    String cdid=request.getParameter("department");;
    int d_id=0;
    String fname = request.getParameter("fname");
    String lname = request.getParameter("lname");
    String email = request.getParameter("email");
    String pass = request.getParameter("password");
    String blood = request.getParameter("bl");
    String mobile = request.getParameter("mobile");
    String role = request.getParameter("role");
    String address = request.getParameter("address");
    String date = request.getParameter("date");
    String year =request.getParameter("year");
    String department =request.getParameter("department");
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String dep_id = "select * from department where dep_name='" + department + "'";
    try {
        con = databasecon.getconnection();
        st = con.createStatement();
       if(role!="Student")
       {
        rs = st.executeQuery(dep_id);
         if (rs.next()) {
         department=rs.getString(1);
         }
    d_id=Integer.parseInt(department);
    String classid = "select * from class where year='" + year + "' AND department_id='" + d_id + "'";     
         rs = st.executeQuery(classid);
         if (rs.next()) {
         cdid=rs.getString(1);
         }
       }
           String sql = "insert into sec_user (`first_name`, `last_name`, `login_name`, `password`, `mobile`, `bloodgroup`, `role`, `address`, `cd_id`) values('" + fname + "','" + lname + "','" + email + "','" + pass + "','" + mobile + "','" + blood + "','" + role + "','" + address + "','" + cdid + "')";
  
        int i = st.executeUpdate(sql);
        if (i > 1) {
            out.println("failed");
        } else {
            out.println("success");
        sql = "select * from sec_user where login_name='" + email + "'";

            rs = st.executeQuery(sql);

            if (rs.next()) {
                String id=rs.getString(1);
                session.setAttribute("id", rs.getString(1));
                response.sendRedirect("student/dashboard.jsp");
            }
        }
    } catch (SQLException e1) {
        out.println("<div id=\"error\">");
        e1.printStackTrace(new java.io.PrintWriter(out));
        out.println("</div>");

    } finally {
        st.close();
        con.close();
    }
%>
