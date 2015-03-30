  
<html>
    <%@page import="java.sql.SQLException"%>
    <%@page import="databaseconnection.databasecon"%>
    <%@page import="java.sql.Statement"%>
    <%@page import="java.sql.ResultSet"%>
    <%@page import="java.sql.Connection"%>

    <%

        String pupilname = request.getParameter("user");
        String pupilpass = request.getParameter("password");

        /*text.decrypt(pupilname);
         pupilname=NewClass.getEncryptedString();

         text.decrypt(pupilpass);
         pupilpass=NewClass.getEncryptedString();
         */
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "select * from sec_user where login_name='" + pupilname + "' AND password='" + pupilpass + "'";
        try {
            con = databasecon.getconnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            if (rs.next()) {
                
                sql = "select * from sec_user where login_name='" + pupilname + "'";

            rs = st.executeQuery(sql);

            if (rs.next()) {
                String role=rs.getString(4);
                session.setAttribute("id", rs.getString(1));
                 if(role.equalsIgnoreCase("Faculty"))
                response.sendRedirect("faculty/dashboard.jsp");
                 else
                response.sendRedirect("student/dashboard.jsp");
               // out.println("success");
            }
        
               
    
    } else {
    %> <%
//                               response.sendRedirect("Message.jsp");
out.println("failed");
            }
        } catch (SQLException e1) {

            System.out.println(e1);

        } finally {
            st.close();
            con.close();
        }


    %>
</html>