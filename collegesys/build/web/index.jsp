<%@page import="databaseconnection.Sms"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="com.mashape.unirest.http.exceptions.UnirestException"%>
<%@page import="com.mashape.unirest.http.Unirest"%>
<%@page import="com.mashape.unirest.http.JsonNode"%>
<%@page import="com.mashape.unirest.http.HttpResponse"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.SQLException"%>
<%@page import="databaseconnection.databasecon"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<!DOCTYPE html>


<% 
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String sql = "select * from department";
    try {
        con = databasecon.getconnection();
        st = con.createStatement();
        rs = st.executeQuery(sql);
    
%><html>

    <head>

        <meta charset="UTF-8">

        <title>Secure Cloud Photo Storage</title>
        <script type="text/javascript">
            function fun()
            {
                var role = document.getElementById("role").value;
                if (role == "Student")
                {
                    document.getElementById("year").style.visibility = "visible"
                }else{
                    document.getElementById("year").style.visibility = "hidden"
                }
            }
            function hide()
            {
                document.getElementById("year").style.visibility = "hidden"
            }
        </script>

        <link rel="stylesheet" href="css/normalize_login.css">

        <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />

    </head>

    <body onload="hide()">
        <div class="form">

            <ul class="tab-group">
                <li class="tab active"><a href="#login">Log In</a></li>
                <li class="tab"><a href="#signup">Sign Up</a></li>
            </ul>

            <div class="tab-content">

                <div id="login">   
                    <h1>Welcome Back!</h1>

                    <form action="validateuser.jsp" method="post">

                        <div class="field-wrap">
                            <label>
                                Email Address<span class="req">*</span>
                            </label>
                            <input type="text" required autocomplete="off" id="user" name="user"/>
                        </div>

                        <div class="field-wrap">
                            <label>
                                Password<span class="req">*</span>
                            </label>
                            <input type="password" required autocomplete="off" id="password" name="password"/>
                        </div>



                        <button class="button button-block"/>Log In</button>

                    </form>

                </div>
                <div id="signup">   
                    <h1>Sign Up for Free</h1>

                    <form action="userregiter.jsp" method="post">

                        <div class="top-row">
                            <div class="field-wrap">
                                <label>
                                    First Name<span class="req">*</span>
                                </label>
                                <input type="text" required autocomplete="off" id="fname" name="fname"/>
                            </div>

                            <div class="field-wrap">
                                <label>
                                    Last Name<span class="req">*</span>
                                </label>
                                <input type="text" required autocomplete="off" id="lname" name="lname"/>
                            </div>
                        </div>
                        <div class="field-wrap">
                            <label>
                                Blood Group<span class="req">*</span>
                            </label>
                            <input type="text" required autocomplete="off" id="bl" name="bl"/>
                        </div>
                        <div class="field-wrap">
                            <label>
                                Mobile<span class="req">*</span>
                            </label>
                            <input type="tel" required autocomplete="off" id="mobile" name="mobile"/>
                        </div>
                        <div class="field-wrap">
                            <label>
                                Address<span class="req">*</span>
                            </label>
                            <input type="text" required autocomplete="off" id="address" name="address"/>
                        </div>
                        <div class="field-wrap">
                            <label>
                                Email Address<span class="req">*</span>
                            </label>
                            <input type="text" required autocomplete="off" id="email" name="email"/>
                        </div>
                        <div class="field-wrap">
                            <label>
                                D.O.B<span class="req">*</span>
                            </label>
                            <input type="text" required autocomplete="off" id="email" name="date"/>
                        </div>

                        <div class="field-wrap">
                            <label>
                                Set A Password<span class="req">*</span>
                            </label>

                            <input type="password" required autocomplete="off" id="password" name="password"/>
                        </div>
                        <div class="field-wrap">
                            <select name="department" id="department" >
                                <option>Department</option>
                             
                             <% while (rs.next()) {
                %>
                                <option><%=rs.getString(2)%></option>
<!--                                <option>CSE</option>
                                <option>MEC</option>
                                <option>EC</option>
                                <option>EEE</option>
                                <option>CIVIL</option>-->
                                <%
                                              }%>
                                                  <% } catch (SQLException e1) {

            System.out.println(e1);

        } finally {
            st.close();
            con.close();
        }


    %>
                        </select> 
                        </div>
                        <div class="field-wrap">
                            <select name="role" onchange="fun()" id="role">
                                <option>Role</option>
                                <option>Student</option>
                                <option>Faculty</option>
                            </select>
                            <select name="year" id="year">
                                <option>Year</option>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                            </select>
                        </div>
                        <button type="submit" class="button button-block"/>Register</button>

                    </form>

                </div>

            </div><!-- tab-content -->

        </div> <!-- /form -->

        <script src="js/index.js"></script>

    </body>

</html>