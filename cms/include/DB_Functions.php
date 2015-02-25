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
    public function getTimetable($classid) {
           $result = mysql_query("SELECT * FROM time_table WHERE time_id = $classid");
            // return user details
            return mysql_fetch_array($result);
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
    
     public function getMarkstable($classid) {
        $response = array();
        $result = mysql_query("SELECT *FROM test1 WHERE class_id = $classid");
            // return user details
            //return mysql_fetch_array($result);
            $response["products"] = array();
    
    while ($row = mysql_fetch_array($result)) {
        // temp user array
        $product = array();
        $product["pid"] = $row["sub1"];
        $product["name"] = $row["sub2"];
        
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
