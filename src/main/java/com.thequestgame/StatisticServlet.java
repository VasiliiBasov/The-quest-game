package com.thequestgame;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StatisticsServlet", value = "/statistics")
public class StatisticServlet extends HttpServlet {
    private String name;
    private String ipAdress;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession();
        name = (String) currentSession.getAttribute("name");
        ipAdress = (String) currentSession.getAttribute("ipAdress");
        System.out.println("Статистика:");
        System.out.println("IP adress: " + ipAdress);
        System.out.println("Имя в игре: " + name);
        System.out.println("Количество игр: ");
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("Статисика: \n");
        printWriter.write("IP adress: " + ipAdress + "\n");
        printWriter.write("Имя в игре: " + name + "\n");
        printWriter.write("Количество игр: " + 0);
        printWriter.close();
    }
}
