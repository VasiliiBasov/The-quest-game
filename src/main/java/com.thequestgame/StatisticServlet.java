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
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        try {
            printWriter.println("<form>");
            printWriter.println("<fieldset>");
            printWriter.println("<legend>Статистика</legend>");
            printWriter.println("<p><label for=\"IPadress\" id=\"ipAdress\">IP adress: </label>" + ipAdress + "</p>");
            printWriter.println("<p><label for=\"name\" id=\"name\">Имя в игре: </label>" + name + "</p>");
            printWriter.println("<p><label for=\"GameCount\" id=\"gameCount\">Игр сыграно: </label>" + 0 + "</p>");
            printWriter.println("</fieldset>");
            printWriter.println("</form>");
        } finally {
            printWriter.close();
        }
    }
}
