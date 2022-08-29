package com.thequestgame;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@WebServlet(name = "LogicServlet", value = "/logic")
public class LogicServlet extends HttpServlet {
    private String name = "anonym";
    private String ipAdress = "0.0.0.0";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession();
        name = (String) currentSession.getAttribute("name");
        ipAdress = (String) currentSession.getAttribute("ipAdress");
        System.out.println("Статистика:");
        System.out.println("IP adress: " + ipAdress);
        System.out.println("Имя в игре: " + name);
        System.out.println("Количество игр: ");
    }
}
