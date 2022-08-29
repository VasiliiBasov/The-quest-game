package com.thequestgame;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "LogicServlet", value = "/logic")
public class LogicServlet extends HttpServlet {
    private static final ArrayList<Question> questions = new ArrayList<>();
    private static final Question firstQuestion;

    static {
        Question q3 = new Question("Ты поднялся на мостик. \nКто ты?");
        q3.putAnswer("Сказать правду о себе.", Question.setEndAnswer("Тебя вернули домой. Победа!"));
        q3.putAnswer("Солгать о себе.", Question.setEndAnswer("Твою ложь разоблачили. Поражение."));
        Question q2 = new Question("Ты принял вызов. \nПоднимаешься на мостик к капитану?");
        q2.putAnswer("Подняться на мостик.", q3);
        q2.putAnswer("Отказаться подниматься на мостик.", Question.setEndAnswer("Ты не пошел на переговоры. Поражение."));
        Question q1 = new Question("Ты потерял память.\nПринять вызов НЛО?");
        q1.putAnswer("Принять вызов.", q2);
        q1.putAnswer("Отклонить вызов.", Question.setEndAnswer("Ты отклонил вызов. Поражение."));
        questions.add(q1);
        questions.add(q2);
        questions.add(q3);
        firstQuestion = q1;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession currentSession = req.getSession();
        resp.setContentType("text/html;charset=UTF-8");

        try (PrintWriter printWriter = resp.getWriter()) {
            printWriter.println("<h1><b>" + firstQuestion.getNAME() + "</b></h1>");
            currentSession.setAttribute("lastQuestion", firstQuestion);
            printWriter.println("<img src=\"static/UFO.jpg\" style=\"height: 300px; width: 500px;left: 100px\" >");
            printWriter.println("<br>");
            for (String answer : firstQuestion.getAnswers()) {
                printWriter.println("<INPUT TYPE=\"RADIO\" NAME=\"Answer\" VALUE =\"" + answer + "\">" + answer + "<br>");
            }
            printWriter.println("<br>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession currentSession = req.getSession();
        resp.setContentType("text/html;charset=UTF-8");
        BufferedReader reader = new BufferedReader(req.getReader());
        String quest = reader.readLine();
        try (PrintWriter printWriter = resp.getWriter()) {
            Question question = (Question) currentSession.getAttribute("lastQuestion");
            question = question.getQuestionByAnswer(quest);
            printWriter.println("<h1><b>" + question.getNAME() + "</b></h1>");
            currentSession.setAttribute("lastQuestion", question);
            if (question.getAnswers().isEmpty()) {

                resp.setStatus(250);
            } else for (String answer : question.getAnswers()) {
                printWriter.println("<INPUT TYPE=\"RADIO\" NAME=\"Answer\" VALUE =\"" + answer + "\">" + answer + "<br>");
            }
        }
    }
}
