package databaseconnection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author srinivasan
 */
public class Sms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Started");
        try {
HttpResponse<JsonNode> response = Unirest.get("https://site2sms.p.mashape.com/index.php?msg=working&phone=9551854456&pwd=12345dls&uid=9551854456")
.header("X-Mashape-Key", "ulslyn2BgqmshA4QS0wmDN5nmdF6p13SZOVjsnGeQ1XwEVvL3o")
.header("Accept", "application/json")
.asJson();
        } catch (UnirestException ex) {
            Logger.getLogger(Sms.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println("Finished");

    }
  public void send(String msg){
        try {
HttpResponse<JsonNode> response = Unirest.get("https://site2sms.p.mashape.com/index.php?msg="+msg+"&phone=9551854456&pwd=12345dls&uid=9551854456")
.header("X-Mashape-Key", "ulslyn2BgqmshA4QS0wmDN5nmdF6p13SZOVjsnGeQ1XwEVvL3o")
.header("Accept", "application/json")
.asJson();
        } catch (UnirestException ex) {
            Logger.getLogger(Sms.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
