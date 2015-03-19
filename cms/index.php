<?php

/**
 * File to handle all API requests
 * Accepts GET and POST
 * 
 * Each request will be identified by TAG
 * Response will be JSON data

  /**
 * check for POST request 
 */


if (isset($_POST['tag']) && $_POST['tag'] != '') {
    // get tag
    $tag = $_POST['tag'];

    // include db handler
    require_once 'include/DB_Functions.php';
    $db = new DB_Functions();

    // response Array
    $response = array("tag" => $tag, "success" => 0, "error" => 0);

    // check for tag type
    if ($tag == 'login') {
        // Request type is check Login
        $email = $_POST['email'];
        $password = $_POST['password'];

        // check for user
        $user = $db->getUserByEmailAndPassword($email, $password);
        if ($user != false) {
            // user found
            // echo json with success = 1
            $response["user"]["success"] = "1";
           $response["user"]["uid"] = $user["user_id"];
            $response["user"]["name"] = $user["first_name"];
            $response["user"]["lname"] = $user["last_name"];
            $response["user"]["mobile"] = $user["mobile"];
            $response["user"]["department"] = $user["cd_id"];
            $response["user"]["role"] = $user["role"];
            $response["user"]["address"] = $user["address"];
            $response["user"]["email"] = $user["login_name"];
            echo json_encode($response);
        } else {
            // user not found
            // echo json with error = 1
            $response["error"] = "1";
            $response["error_msg"] = "Incorrect email or password!";
            echo json_encode($response);
        }
    } else if ($tag == 'register') {
        // Request type is Register new user

        $name = $_POST['name'];
        $lname = $_POST['lname'];
        $mobile = $_POST['mobile'];
        $department = $_POST['department'];
        $bloodgroup = $_POST['bloodgroup'];
        $role = $_POST['role'];
        $address = $_POST['address'];
        $email = $_POST['email'];
        $password = $_POST['password'];

        // check if user is already existed
        if ($db->isUserExisted($email)) {
            // user is already existed - error response
            $response["error"] = "2";
            $response["error_msg"] = "User already existed";
            echo json_encode($response);
        } else {
            // store user
            $user = $db->storeUser($name, $lname, $mobile, $department, $bloodgroup, $role, $address, $email, $password);
            if ($user) {
             
                $response["user"]["success"] = "1";
            $response["user"]["uid"] = $user["user_id"];
            $response["user"]["name"] = $user["first_name"];
            $response["user"]["lname"] = $user["last_name"];
            $response["user"]["mobile"] = $user["mobile"];
            $response["user"]["department"] = $user["cd_id"];
            $response["user"]["role"] = $user["role"];
            $response["user"]["address"] = $user["address"];
            $response["user"]["email"] = $user["login_name"];
            echo json_encode($response);
            } else {
                // user failed to store
                $response["error"] = "1";
                $response["error_msg"] = "Error occured in Registartion";
                echo json_encode($response);
            }
        }
    } else if ($tag == 'timetable') {
        $classid = $_POST['classid'];
        $day =$_POST['day'];
            $user = $db->getTimetable($classid, $day);
            $response["user"]["success"] = "1";
            $response["user"]["day"] = $user["day"];//"monday";
            $response["user"]["period1"] = $user["period1"];//"period1";//
            $response["user"]["period2"] = $user["period2"];//"period2";// $user["period2"];
            $response["user"]["period3"] = $user["period3"];//"period3";// $user["period3"];
            $response["user"]["period4"] =  $user["period4"];//"period4";//$user["period4"];
            $response["user"]["period5"] = $user["period5"];//"period5";// $user["period5"];
            $response["user"]["period6"] =  $user["period6"];//"period6";//$user["period6"];
            $response["user"]["period7"] =  $user["period7"];//"period7";//$user["period7"];
            $response["user"]["period8"] =  $user["period8"];//"period8";//$user["period8"];
            echo json_encode($response);
          
    }
    
    else if ($tag == 'attendance'){
         $classid = $_POST['classid'];
         $response["products"] = array();
         $responce = $db->getAttendancetable($classid);
         echo json_encode($responce);
    }else if($tag == 'busdetails'){
        $responce = $db->getbus();
        echo json_encode($responce);
    }else if ($tag == 'facultyattendance'){
         $classid = $_POST['classid'];
         $date = $_POST['date'];
           $response["products"] = array();
         $responce = $db->getfacultyAttendancetable($classid,$date);

         echo json_encode($responce);
    }else if ($tag == 'marks'){
         $classid = $_POST['classid'];
         $test = $_POST['test'];
         $sub = $_POST['sub'];
           $response["products"] = array();
         $responce = $db->getMarkstable($classid, $test, $sub);
         echo json_encode($responce);
    } else if ($tag == 'faculty_marks'){
         $classid = $_POST['classid'];
         $test = $_POST['test'];
         $sub = $_POST['sub'];
           $response["products"] = array();
         $responce = $db->getMarkstablefaculty($classid, $test, $sub);
         echo json_encode($responce);
    } else if ($tag == 'loginid'){
         $uid = $_POST['uid'];
         $user = $db->getloginbyId($uid);
             if ($user != false) {
            // user found
            // echo json with success = 1
            $response["user"]["success"] = "1";
           $response["user"]["uid"] = $user["user_id"];
            $response["user"]["name"] = $user["first_name"];
            $response["user"]["lname"] = $user["last_name"];
            $response["user"]["mobile"] = $user["mobile"];
            $response["user"]["department"] = $user["cd_id"];
            $response["user"]["role"] = $user["role"];
            $response["user"]["address"] = $user["address"];
            $response["user"]["email"] = $user["login_name"];
            echo json_encode($response);
        } else {
            // user not found
            // echo json with error = 1
            $response["error"] = "1";
            $response["error_msg"] = "Incorrect email or password!";
            echo json_encode($response);
        }
    } else  {
        
        echo "Invalid Request";
    }
} else {
    echo "Access Denied";
}
?>
