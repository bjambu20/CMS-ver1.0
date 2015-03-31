<!DOCTYPE html>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="databaseconnection.databasecon"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<html lang="en" class="no-js">
<head>
    <title>Time Tables</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="images/icons/favicon.ico">
    <link rel="apple-touch-icon" href="images/icons/favicon.png">
    <link rel="apple-touch-icon" sizes="72x72" href="images/icons/favicon-72x72.png">
    <link rel="apple-touch-icon" sizes="114x114" href="images/icons/favicon-114x114.png">
    <!--Loading bootstrap css-->
    <link type="text/css" rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,400,300,700">
    <link type="text/css" rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oswald:400,700,300">
    <link type="text/css" rel="stylesheet" href="styles/jquery-ui-1.10.4.custom.min.css">
    <link type="text/css" rel="stylesheet" href="styles/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="styles/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="styles/animate.css">
    <link type="text/css" rel="stylesheet" href="styles/all.css">
    <link type="text/css" rel="stylesheet" href="styles/main.css">
    <link type="text/css" rel="stylesheet" href="styles/style-responsive.css">
    <link type="text/css" rel="stylesheet" href="styles/zabuto_calendar.min.css">
    <link type="text/css" rel="stylesheet" href="styles/pace.css">
    <link type="text/css" rel="stylesheet" href="styles/jquery.news-ticker.css">
    
    	<link rel="stylesheet" type="text/css" href="css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="css/demo.css" />
		<link rel="stylesheet" type="text/css" href="css/component.css" />
</head>
<body>
    <div>
        
        <!--BEGIN THEME SETTING-->
        <div id="theme-setting">
            <a href="#" data-toggle="dropdown" data-step="1" data-intro="&lt;b&gt;Many styles&lt;/b&gt; and &lt;b&gt;colors&lt;/b&gt; be created for you. Let choose one and enjoy it!"
                data-position="left" class="btn-theme-setting"><i class="fa fa-cog"></i></a>
            <div class="content-theme-setting">
                <select id="list-style" class="form-control">
                    <option value="style1">Flat Squared style</option>
                    <option value="style2">Flat Rounded style</option>
                    <option value="style3" selected="selected">Flat Border style</option>
                </select>
            </div>
        </div>
        <!--END THEME SETTING-->
        <!--BEGIN BACK TO TOP-->
        <a id="totop" href="#"><i class="fa fa-angle-up"></i></a>
        <!--END BACK TO TOP-->
        <!--BEGIN TOPBAR-->
        <div id="header-topbar-option-demo" class="page-header-topbar">
            <nav id="topbar" role="navigation" style="margin-bottom: 0;" data-step="3" class="navbar navbar-default navbar-static-top">
            <div class="navbar-header">
                <button type="button" data-toggle="collapse" data-target=".sidebar-collapse" class="navbar-toggle"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
                <a id="logo" href="dashboard.jsp" class="navbar-brand"><span class="fa fa-rocket"></span><span class="logo-text">KAdmin</span><span style="display: none" class="logo-text-icon">�</span></a></div>
            <div class="topbar-main"><a id="menu-toggle" href="#" class="hidden-xs"><i class="fa fa-bars"></i></a>
                
                <form id="topbar-search" action="" method="" class="hidden-sm hidden-xs">
                    <div class="input-icon right text-white"><a href="#"><i class="fa fa-search"></i></a><input type="text" placeholder="Search here..." class="form-control text-white"/></div>
                </form>
                <div class="news-update-box hidden-xs"><span class="text-uppercase mrm pull-left text-white">News:</span>
                    <ul id="news-update" class="ticker list-unstyled">
                        <li>Welcome to KAdmin - Responsive Multi-Style Admin Template</li>
                        <li>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque.</li>
                    </ul>
                </div>
                <ul class="nav navbar navbar-top-links navbar-right mbn">
                    <li class="dropdown"><a data-hover="dropdown" href="#" class="dropdown-toggle"><i class="fa fa-bell fa-fw"></i><span class="badge badge-green">3</span></a>
                        
                    </li>
                    <li class="dropdown"><a data-hover="dropdown" href="#" class="dropdown-toggle"><i class="fa fa-envelope fa-fw"></i><span class="badge badge-orange">7</span></a>
                        
                    </li>
                    <li class="dropdown"><a data-hover="dropdown" href="#" class="dropdown-toggle"><i class="fa fa-tasks fa-fw"></i><span class="badge badge-yellow">8</span></a>
                        
                    </li>
                    <li class="dropdown topbar-user"><a data-hover="dropdown" href="#" class="dropdown-toggle"><img src="images/avatar/48.jpg" alt="" class="img-responsive img-circle"/>&nbsp;<span class="hidden-xs">Robert John</span>&nbsp;<span class="caret"></span></a>
                        <ul class="dropdown-menu dropdown-user pull-right">
                            <li><a href="#"><i class="fa fa-user"></i>My Profile</a></li>
                            <li><a href="#"><i class="fa fa-calendar"></i>My Calendar</a></li>
                            <li><a href="#"><i class="fa fa-envelope"></i>My Inbox<span class="badge badge-danger">3</span></a></li>
                            <li><a href="#"><i class="fa fa-tasks"></i>My Tasks<span class="badge badge-success">7</span></a></li>
                            <li class="divider"></li>
                            <li><a href="#"><i class="fa fa-lock"></i>Lock Screen</a></li>
                            <li><a href="../index.jsp"><i class="fa fa-key"></i>Log Out</a></li>
                        </ul>
                    </li>
                    <li id="topbar-chat" class="hidden-xs"><a href="javascript:void(0)" data-step="4" data-intro="&lt;b&gt;Form chat&lt;/b&gt; keep you connecting with other coworker" data-position="left" class="btn-chat"><i class="fa fa-comments"></i><span class="badge badge-info">3</span></a></li>
                </ul>
            </div>
        </nav>
            <!--BEGIN MODAL CONFIG PORTLET-->
            <div id="modal-config" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" data-dismiss="modal" aria-hidden="true" class="close">
                                &times;</button>
                            <h4 class="modal-title">
                                Modal title</h4>
                        </div>
                        <div class="modal-body">
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eleifend et nisl eget
                                porta. Curabitur elementum sem molestie nisl varius, eget tempus odio molestie.
                                Nunc vehicula sem arcu, eu pulvinar neque cursus ac. Aliquam ultricies lobortis
                                magna et aliquam. Vestibulum egestas eu urna sed ultricies. Nullam pulvinar dolor
                                vitae quam dictum condimentum. Integer a sodales elit, eu pulvinar leo. Nunc nec
                                aliquam nisi, a mollis neque. Ut vel felis quis tellus hendrerit placerat. Vivamus
                                vel nisl non magna feugiat dignissim sed ut nibh. Nulla elementum, est a pretium
                                hendrerit, arcu risus luctus augue, mattis aliquet orci ligula eget massa. Sed ut
                                ultricies felis.</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" data-dismiss="modal" class="btn btn-default">
                                Close</button>
                            <button type="button" class="btn btn-primary">
                                Save changes</button>
                        </div>
                    </div>
                </div>
            </div>
            <!--END MODAL CONFIG PORTLET-->
        </div>
        <!--END TOPBAR-->
        <div id="wrapper">
            <!--BEGIN SIDEBAR MENU-->
            <nav id="sidebar" role="navigation" data-step="2" data-intro="Template has &lt;b&gt;many navigation styles&lt;/b&gt;"
                data-position="right" class="navbar-default navbar-static-side">
            <div class="sidebar-collapse menu-scroll">
                   <ul id="side-menu" class="nav">
                    
                     <div class="clearfix"></div>
                    <li><a href="dashboard.jsp"><i class="fa fa-tachometer fa-fw">
                        <div class="icon-bg bg-orange"></div>
                    </i><span class="menu-title">Dashboard</span></a></li>
                    <li class="active"><a href="timetable.jsp"><i class="fa fa-desktop fa-fw">
                        <div class="icon-bg bg-pink"></div>
                    </i><span class="menu-title">Time Table</span></a>
                       
                    </li>
                       <li><a href="attendance.jsp"><i class="fa fa-edit fa-fw">
                        <div class="icon-bg bg-blue"></div>
                    </i><span class="menu-title">Attendance</span></a>
                          
                    </li>
                     <li><a href="marksheet.jsp"><i class="fa fa-edit fa-fw">
                       <div class="icon-bg bg-yellow"></div>
                    </i><span class="menu-title">Mark sheet</span></a>
                      
                    </li>
                    
                    <li><a href="Tables.html"><i class="fa fa-th-list fa-fw">
                        <div class="icon-bg bg-blue"></div>
                    </i><span class="menu-title">Tables</span></a>
                          
                    </li>
                
                    
                </ul>
            </div>
        </nav>
          
          
            <div id="page-wrapper">
                
                
                
                <!--BEGIN TITLE & BREADCRUMB PAGE-->
                <div id="title-breadcrumb-option-demo" class="page-title-breadcrumb">
                    <div class="page-header pull-left">
                        <div class="page-title">
                            Tables</div>
                    </div>
                    <ol class="breadcrumb page-breadcrumb pull-right">
                        <li><i class="fa fa-home"></i>&nbsp;<a href="dashboard.jsp">Home</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                        <li class="hidden"><a href="#">Tables</a>&nbsp;&nbsp;<i class="fa fa-angle-right"></i>&nbsp;&nbsp;</li>
                        <li class="active">Tables</li>
                    </ol>
                    <div class="clearfix">
                    </div>
                </div>
                <!--END TITLE & BREADCRUMB PAGE-->
                <!--BEGIN CONTENT-->
                <div class="page-content">
                    <div id="tab-general">
                        <div class="row mbl">
                            
                            <div class="col-lg-12">
                                
                                            <div class="col-md-12">
                                                <div id="area-chart-spline" style="width: 100%; height: 300px; display: none;">
                                                </div>
                                            </div>
                                
                            </div>

                            <div class="col-lg-12">
                            <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-yellow">
                            <div class="panel-heading">Simple Table</div>
                            <div class="panel-body">
                             <form name="f1">
                                    <h4>Choose</h4>
                                    <h4> Department   <select name="department" id="department">
                            <option>Select</option>
                            <option>IT</option>
                            <option>CSE</option>
                            <option>EC</option>
                            <option>MEC</option>
                            <option>EEE</option>
                            <option>CIVIL</option>
                        </select>
                        Year  <select name="year" id="year" onChange="document.f1.submit()" >
                            <option>Select</option>
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                        </select></h4>
</form>
                            </div>
                            
                        </div>
                        
                        <%
    String cdid = null;
        String year = request.getParameter("year");
      // later need tis  String id = request.getParameter("id");
        String department = request.getParameter("department");
        int d_id = 0;

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        String dep_id = "select * from department where dep_name='" + department + "'";
        
        try {
            con = databasecon.getconnection();
            st = con.createStatement();
 if(year !=null)
       {
            rs = st.executeQuery(dep_id);
            if (rs.next()) {
                department = rs.getString(1);
            }
            d_id = Integer.parseInt(department);
            String classid = "select * from class where year='" + year + "' AND department_id='" + d_id + "'";
            rs = st.executeQuery(classid);
            if (rs.next()) {
                cdid = rs.getString(1);
            }
           
%> 

  <%
    
   String studentid = "select * from sec_user where cd_id='" + cdid + "'";
            rs = st.executeQuery(studentid);
  %>

  
                      
   
                            <div class="panel-heading">  </div>
                             <form action="addtime.jsp">  
                            <div class="panel-body">
                                  <h4>  Department :<%=department%> Year :<%=year%>   </h4>

                    
                        <div><input type="hidden" name="classid" value="<%=cdid%>" /></div>
                                <table class="table table-hover table-bordered">
                                    <thead>
                                    <tr>
							  <th>Day</th><th>Period 1</th><th>Period 2</th><th>Period 3</th><th>Period 4</th><th>Period 5</th><th>Period 6</th><th>Period 7</th><th>Period 8</th>  
						</tr>
                                    </thead>
                                    <tbody>
 
                                    
    <tr>
     						<th>Monday</th>
							<td><input type="text" name="p11" value="mon 1"></td>
							<td><input type="text" name="p12" value="mon 1"></td>
                                                        <td><input type="text" name="p13" value="mon 1"></td>
							<td><input type="text" name="p14" value="mon 1"></td>
							<td><input type="text" name="p15" value="mon 1"></td>
                                                        <td><input type="text" name="p16" value="mon 1"></td>
                                                        <td><input type="text" name="p17" value="mon 1"></td>
                                                        <td><input type="text" name="p18" value="mon 1"></td>
						</tr>
						<tr>
							<th>Tuesday</th>
							<td><input type="text" name="p21" value="tue 1"></td>
							<td><input type="text" name="p22" value="tue 1"></td>
                                                        <td><input type="text" name="p23" value="tue 1"></td>
							<td><input type="text" name="p24" value="tue 1"></td>
							<td><input type="text" name="p25" value="tue 1"></td>
                                                        <td><input type="text" name="p26" value="tue 1"></td>
                                                        <td><input type="text" name="p27" value="tue 1"></td>
                                                        <td><input type="text" name="p28" value="tue 1"></td>
						</tr>
						<tr>
							<th>Wednesday</th>
							<td><input type="text" name="p31" value="wed 1"></td>
							<td><input type="text" name="p32" value="wed 1"></td>
                                                        <td><input type="text" name="p33" value="wed 1"></td>
							<td><input type="text" name="p34" value="wed 1"></td>
							<td><input type="text" name="p35" value="wed 1"></td>
                                                        <td><input type="text" name="p36" value="wed 1"></td>
                                                        <td><input type="text" name="p37" value="wed 1"></td>
                                                        <td><input type="text" name="p38" value="wed 1"></td>
						</tr>
						<tr>
							<th>Thursday</th>
							<td><input type="text" name="p41" value="thur 1"></td>
							<td><input type="text" name="p42" value="thur 1"></td>
                                                        <td><input type="text" name="p43" value="thur 1"></td>
							<td><input type="text" name="p44" value="thur 1"></td>
							<td><input type="text" name="p45" value="thur 1"></td>
                                                        <td><input type="text" name="p46" value="thur 1"></td>
                                                        <td><input type="text" name="p47" value="thur 1"></td>
                                                        <td><input type="text" name="p48" value="thur 1"></td>
						</tr>
                                                <tr>
							<th>Friday</th>
							<td><input type="text" name="p51" value="fri 1"></td>
							<td><input type="text" name="p52" value="fri 1"></td>
                                                        <td><input type="text" name="p53" value="fri 1"></td>
							<td><input type="text" name="p54" value="fri 1"></td>
							<td><input type="text" name="p55" value="fri 1"></td>
                                                        <td><input type="text" name="p56" value="fri 1"></td>
                                                        <td><input type="text" name="p57" value="fri 1"></td>
                                                        <td><input type="text" name="p58" value="fri 1"></td>
						</tr>
                                                <tr>
							<th>Saturday</th>
							<td><input type="text" name="p61" value="sat 1"></td>
							<td><input type="text" name="p62" value="sat 1"></td>
                                                        <td><input type="text" name="p63" value="sat 1"></td>
							<td><input type="text" name="p64" value="sat 1"></td>
							<td><input type="text" name="p65" value="sat 1"></td>
                                                        <td><input type="text" name="p66" value="sat 1"></td>
                                                        <td><input type="text" name="p67" value="sat 1"></td>
                                                        <td><input type="text" name="p68" value="sat 1"></td>
						</tr>
                                    </tbody>
                                    
                                </table>
                        <input type="submit" value="Submit" />
                            </div>
                                  </form>
                                                                  <%
   } //end of if
 %>
    <% } catch (SQLException e1) {

            System.out.println(e1);

        } finally {
            st.close();
            con.close();
        }


    %>
 
                    </div>

                </div>
                            
                            
                            </div>
                            
                        </div>
                    </div>
                </div>
                <!--END CONTENT-->
                <!--BEGIN FOOTER-->
                <div id="footer">
                    <div class="copyright">
                        <a href="http://themifycloud.com">2014 � KAdmin Responsive Multi-Purpose Template</a></div>
                </div>
                <!--END FOOTER-->
            </div>
            <!--END PAGE WRAPPER-->
        </div>
    </div>
    <script src="script/jquery-1.10.2.min.js"></script>
    <script src="script/jquery-migrate-1.2.1.min.js"></script>
    <script src="script/jquery-ui.js"></script>
    <script src="script/bootstrap.min.js"></script>
    <script src="script/bootstrap-hover-dropdown.js"></script>
    <script src="script/html5shiv.js"></script>
    <script src="script/respond.min.js"></script>
    <script src="script/jquery.metisMenu.js"></script>
    <script src="script/jquery.slimscroll.js"></script>
    <script src="script/jquery.cookie.js"></script>
    <script src="script/icheck.min.js"></script>
    <script src="script/custom.min.js"></script>
    <script src="script/jquery.news-ticker.js"></script>
    <script src="script/jquery.menu.js"></script>
    <script src="script/pace.min.js"></script>
    <script src="script/holder.js"></script>
    <script src="script/responsive-tabs.js"></script>
    <script src="script/jquery.flot.js"></script>
    <script src="script/jquery.flot.categories.js"></script>
    <script src="script/jquery.flot.pie.js"></script>
    <script src="script/jquery.flot.tooltip.js"></script>
    <script src="script/jquery.flot.resize.js"></script>
    <script src="script/jquery.flot.fillbetween.js"></script>
    <script src="script/jquery.flot.stack.js"></script>
    <script src="script/jquery.flot.spline.js"></script>
    <script src="script/zabuto_calendar.min.js"></script>
    <script src="script/index.js"></script>
    <!--LOADING SCRIPTS FOR CHARTS-->
    <script src="script/highcharts.js"></script>
    <script src="script/data.js"></script>
    <script src="script/drilldown.js"></script>
    <script src="script/exporting.js"></script>
    <script src="script/highcharts-more.js"></script>
    <script src="script/charts-highchart-pie.js"></script>
    <script src="script/charts-highchart-more.js"></script>
    <!--CORE JAVASCRIPT-->
    <script src="script/main.js"></script>
    <script>        (function (i, s, o, g, r, a, m) {
            i['GoogleAnalyticsObject'] = r;
            i[r] = i[r] || function () {
                (i[r].q = i[r].q || []).push(arguments)
            }, i[r].l = 1 * new Date();
            a = s.createElement(o),
            m = s.getElementsByTagName(o)[0];
            a.async = 1;
            a.src = g;
            m.parentNode.insertBefore(a, m)
        })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');
        ga('create', 'UA-145464-12', 'auto');
        ga('send', 'pageview');


</script>
</body>
</html>