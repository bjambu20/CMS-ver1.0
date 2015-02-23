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
            $response["success"] = 1;
            $response["user"]["uid"] = $user["user_id"];
            $response["user"]["name"] = $user["first_name"];
            $response["user"]["email"] = $user["login_name"];
            $response["user"]["created_at"] = "null";
            $response["user"]["updated_at"] = "null";
            echo json_encode($response);
        } else {
            // user not found
            // echo json with error = 1
            $response["error"] = 1;
            $response["error_msg"] = "Incorrect email or password!";
            echo json_encode($response);
        }
    } else if ($tag == 'register') {
        // Request type is Register new user
	/**
	 * function make Login Request
	 * @param name
	 * @param email
	 * @param password
	 * @param mobile 
	 * @param lname 
	 * @param department 
	 * @param bloodgroup 
	 * @param role 
	 * @param address 
	 * */
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
            $response["error"] = 2;
            $response["error_msg"] = "User already existed";
            echo json_encode($response);
        } else {
            // store user
            $user = $db->storeUser($name, $lname, $mobile, $department, $bloodgroup, $role, $address, $email, $password);
            if ($user) {
                // (KEY_NAME),(KEY_LNAME),(KEY_MOBILE),(KEY_DEPARTMENT),(KEY_ROLE),(KEY_ADDRESS),(KEY_EMAIL),(KEY_UID)
                /*	private static String KEY_UID = "uid";
                        private static String KEY_NAME = "name";
                        private static String KEY_LNAME = "lname";
                        private static String KEY_MOBILE = "mobile";
                        private static String KEY_DEPARTMENT = "department";
                        private static String KEY_ROLE = "role";
                        private static String KEY_ADDRESS = "address";
                        private static String KEY_EMAIL = "email"; */
                $response["success"] = 1;
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
                $response["error"] = 1;
                $response["error_msg"] = "Error occured in Registartion";
                echo json_encode($response);
            }
        }
    } else {
        echo "Invalid Request";
    }
} else {
    echo "Access Denied";
}
?>
