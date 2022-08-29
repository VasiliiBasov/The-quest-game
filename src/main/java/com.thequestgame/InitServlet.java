package com.thequestgame;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@WebServlet(name = "InitServlet", value = "/start")
public class InitServlet extends HttpServlet {
    private String name = "anonymous";
    private String ipAdress = "0.0.0.0";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession();
        resp.setContentType("text/html;charset=UTF-8");
        BufferedReader reader = new BufferedReader(req.getReader());
        name = reader.readLine();
        currentSession.setAttribute("name", name);
        ipAdress = getIp();
        currentSession.setAttribute("ipAdress", ipAdress);
        resp.sendRedirect("game.jsp");
    }

    private String getIp() throws IOException {
        String urlString = "http://checkip.amazonaws.com/";
        URL url = new URL(urlString);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return br.readLine();
        }
    }
}
