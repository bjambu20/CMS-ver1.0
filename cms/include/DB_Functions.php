<?php

class DB_Functions {

    private $db;

    //put your code here
    // constructor
    function __construct() {
        require_once 'DB_Connect.php';
        // connecting to database
        $this->db = new DB_Connect();
        $this->db->connect();
    }

    // destructor
    function __destruct() {
        
    }

    /**
     * Storing new user
     * returns user details
     */
    public function storeUser($name, $lname, $mobile, $department, $bloodgroup, $role, $address, $email, $password) {

        $result = mysql_query("INSERT INTO sec_user(first_name,  last_name, mobile, cd_id, bloodgroup, role, address, login_name, password) VALUES('$name', '$lname', '$mobile', '$department', '$bloodgroup', '$role', '$address', '$email', '$password')");
        // check for successful store
        if ($result) {
            // get user details 
            $uid = mysql_insert_id(); // last inserted id
            $result = mysql_query("SELECT * FROM sec_user WHERE login_name = '$email'");
            // return user details
            return mysql_fetch_array($result);
        } else {
            return false;
        }
    }

    public function getTimetable($classid, $day) {
        $result = mysql_query("SELECT * FROM time_table WHERE classid = '$classid' AND day='$day'");
        // return user details
        return mysql_fetch_array($result);
    }
    
        public function getbus() {
        $response = array();
        $result = mysql_query("SELECT * FROM bus_details");
        // return user details
        $response["products"] = array();

        while ($row = mysql_fetch_array($result)) {
            // temp user array
            $product = array();
            $product["pid"] = $row["bus_id"];
            $product["name"] = $row["route"];
            array_push($response["products"], $product);
        }
        return $response;
    }
    public function getAttendancetable($classid) {
        $response = array();
        $result = mysql_query("SELECT * FROM attendance WHERE student_id = $classid");
        // return user details
        //return mysql_fetch_array($result);
        $response["products"] = array();

        while ($row = mysql_fetch_array($result)) {
            // temp user array
            $product = array();
            $product["pid"] = $row["date"];
            $product["name"] = $row["value"];
            array_push($response["products"], $product);
        }
        return $response;
    }
    
        public function getfacultyAttendancetable($classid, $date) {
        $response = array();
        $result = mysql_query("SELECT * FROM attendance WHERE class_id = '$classid' AND date='$date'");
        // return user details
        //return mysql_fetch_array($result);
        $response["products"] = array();

        while ($row = mysql_fetch_array($result)) {
            // temp user array
            $product = array();
            $product["pid"] = $row["student_id"];
            $product["name"] = $row["value"];
            array_push($response["products"], $product);
        }
        return $response;
    }

    public function getMarkstable($classid, $test, $sub, $depid) {
        $response = array();
        $result = mysql_query("SELECT *FROM $test WHERE student_id = $classid");
        $response["products"] = array();

        while ($row = mysql_fetch_array($result)) {
            // temp user array
            $product = array();
            $product["pid"] = $sub;
            $product["name"] = $row[$sub];

            array_push($response["products"], $product);
        }
       //attaching legent at end of marks for classid=1 (it-1st year)
        if($depid=="1"){
            $product = array();
            $product["pid"] = "sub-1";
            $product["name"] = "MATHS";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-2";
            $product["name"] = "EG";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-3";
            $product["name"] = "EEFA";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-4";
            $product["name"] = "SEQA";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-5";
            $product["name"] = "SOA";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-6";
            $product["name"] = "MC";
        array_push($response["products"], $product);
        }
    //attaching legent at end of marks for classid=1 (it-2nd year)
        if($depid=="2"){
            $product = array();
            $product["pid"] = "sub-1";
            $product["name"] = "MATHS";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-2";
            $product["name"] = "EG";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-3";
            $product["name"] = "EEFA";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-4";
            $product["name"] = "SEQA";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-5";
            $product["name"] = "SOA";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-6";
            $product["name"] = "MC";
        array_push($response["products"], $product);
        }
    //attaching legent at end of marks for classid=1 (it-3rd year)
        if($depid=="3"){
            $product = array();
            $product["pid"] = "sub-1";
            $product["name"] = "MATHS";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-2";
            $product["name"] = "EG";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-3";
            $product["name"] = "EEFA";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-4";
            $product["name"] = "SEQA";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-5";
            $product["name"] = "SOA";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-6";
            $product["name"] = "MC";
        array_push($response["products"], $product);
        }
    //attaching legent at end of marks for classid=1 (it-4th year)
        if($depid=="4"){
            $product = array();
            $product["pid"] = "sub-1";
            $product["name"] = "MATHS";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-2";
            $product["name"] = "EG";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-3";
            $product["name"] = "EEFA";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-4";
            $product["name"] = "SEQA";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-5";
            $product["name"] = "SOA";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-6";
            $product["name"] = "MC";
        array_push($response["products"], $product);
        }
        return $response;
    }
       public function getMarkstablefaculty($classid, $test, $sub) {
        $response = array();
        $result = mysql_query("SELECT *FROM $test WHERE class_id = $classid");
        $response["products"] = array();

        while ($row = mysql_fetch_array($result)) {
            // temp user array
            $product = array();
            $product["pid"] = $row["student_id"];
            $product["name"] = $row[$sub];

            array_push($response["products"], $product);
        }
        //attaching legent at end of marks for classid=1 (it-1st year)
             if($classid=="1"){
            $product = array();
            $product["pid"] = "sub-1";
            $product["name"] = "MATHS";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-2";
            $product["name"] = "EG";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-3";
            $product["name"] = "EEFA";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-4";
            $product["name"] = "SEQA";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-5";
            $product["name"] = "SOA";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-6";
            $product["name"] = "MC";
        array_push($response["products"], $product);
        }
    //attaching legent at end of marks for classid=1 (it-2nd year)
        if($classid=="2"){
            $product = array();
            $product["pid"] = "sub-1";
            $product["name"] = "MATHS";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-2";
            $product["name"] = "EG";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-3";
            $product["name"] = "EEFA";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-4";
            $product["name"] = "SEQA";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-5";
            $product["name"] = "SOA";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-6";
            $product["name"] = "MC";
        array_push($response["products"], $product);
        }
    //attaching legent at end of marks for classid=1 (it-3rd year)
        if($classid=="3"){
            $product = array();
            $product["pid"] = "sub-1";
            $product["name"] = "MATHS";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-2";
            $product["name"] = "EG";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-3";
            $product["name"] = "EEFA";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-4";
            $product["name"] = "SEQA";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-5";
            $product["name"] = "SOA";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-6";
            $product["name"] = "MC";
        array_push($response["products"], $product);
        }
    //attaching legent at end of marks for classid=1 (it-4th year)
        if($classid=="4"){
            $product = array();
            $product["pid"] = "sub-1";
            $product["name"] = "MATHS";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-2";
            $product["name"] = "EG";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-3";
            $product["name"] = "EEFA";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-4";
            $product["name"] = "SEQA";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-5";
            $product["name"] = "SOA";
        array_push($response["products"], $product);
            $product = array();
            $product["pid"] = "sub-6";
            $product["name"] = "MC";
        array_push($response["products"], $product);
        }
        return $response;
    }

    /**
     * Get user by email and password
     */
    public function getUserByEmailAndPassword($email, $password) {
        $result = mysql_query("SELECT * FROM sec_user WHERE login_name = '$email'") or die(mysql_error());
        // check for result 
        $no_of_rows = mysql_num_rows($result);
        if ($no_of_rows > 0) {
            $result = mysql_fetch_array($result);
            $encrypted_password = $result['password'];
            // check for password equality
            if ($encrypted_password == $password) {
                // user authentication details are correct
                return $result;
            }
        } else {
            // user not found
            return false;
        }
    }

    public function getloginbyId($uid) {
        $result = mysql_query("SELECT * FROM sec_user WHERE user_id = '$uid'") or die(mysql_error());
        // check for result 
        $no_of_rows = mysql_num_rows($result);
        if ($no_of_rows > 0) {
            $result = mysql_fetch_array($result);
            return $result;
        } else {
            // user not found
            return false;
        }
    }

    /**
     * Check user is existed or not
     */
    public function isUserExisted($email) {
        $result = mysql_query("SELECT login_name from sec_user WHERE login_name = '$email'");
        $no_of_rows = mysql_num_rows($result);
        if ($no_of_rows > 0) {
            // user existed 
            return true;
        } else {
            // user not existed
            return false;
        }
    }

    /**
     * Encrypting password
     * @param password
     * returns salt and encrypted password
     */
    public function hashSSHA($password) {

        $salt = sha1(rand());
        $salt = substr($salt, 0, 10);
        $encrypted = base64_encode(sha1($password . $salt, true) . $salt);
        $hash = array("salt" => $salt, "encrypted" => $encrypted);
        return $hash;
    }

    /**
     * Decrypting password
     * @param salt, password
     * returns hash string
     */
    public function checkhashSSHA($salt, $password) {

        $hash = base64_encode(sha1($password . $salt, true) . $salt);

        return $hash;
    }

}

?>
