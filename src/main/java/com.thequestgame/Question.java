package com.thequestgame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Question {
    private final String NAME;
    private final Map<String, Question> answerAndQuestion = new HashMap<>();

    public Question(String name) {
        this.NAME = name;
    }

    public void putAnswer(String answer, Question question){
        answerAndQuestion.put(answer, question);
    }

    public String getNAME() {
        return NAME;
    }

    public Set<String> getAnswers() {
        return answerAndQuestion.keySet();
    }

    public Question getQuestionByAnswer(String answer) {
        return answerAndQuestion.get(answer);
    }

    public static Question setEndAnswer(String endAnswer) {
        return new Question(endAnswer);
    }
}
