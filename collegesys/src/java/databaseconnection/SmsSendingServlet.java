package databaseconnection;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A servlet that takes message details from user and send it as a new e-mail
 * through an SMTP server.
 *
 * @author www.codejava.net
 *
 */
//@WebServlet("/SmsSendingServlet")
@WebServlet(name = "/SmsSendingServlet", urlPatterns = {"/SmsSendingServlet"})
public class SmsSendingServlet extends HttpServlet {

    int i = 0;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // reads form fields
//		String recipient = request.getParameter("recipient");
//		String subject = request.getParameter("subject");
//		String content = request.getParameter("content");
        System.out.println("Strated Thread");
//        Thread t1 = new Thread();
//        t1.start();

//        RunnableDemo R1 = new RunnableDemo("Thread-a");
//        R1.start();
//
//        RunnableDemo R2 = new RunnableDemo("Thread-b");
//        R2.start();
//        RunnableDemo R3 = new RunnableDemo("Thread-c");
//        R3.start();
        
        Sms sms =new Sms();
        sms.send("msg1");
        sms.send("msg2");
        sms.send("msg3");
        sms.send("msg4");
        request.setAttribute("Message", "Message sent");
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

    }

}

class RunnableDemo implements Runnable {

    private Thread t;
    private String threadName;

    RunnableDemo(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    public void run() {
        System.out.println("Running " + threadName);
        Sms sms = new Sms();
        sms.send(threadName);

    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
            System.out.println("Stoping " + threadName);
        }
    }

}
