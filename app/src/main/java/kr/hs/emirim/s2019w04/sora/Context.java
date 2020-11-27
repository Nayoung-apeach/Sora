package kr.hs.emirim.s2019w04.sora;

public class Context {
    public String Questions;
    public String Answer;

    public Context() {

    }

    public String getQuestions() {
        return Questions;
    }

    public void setQuestions(String questions) {
        Questions = questions;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public Context(String Questions, String Answer) {
        this.Questions = Questions;
        this.Answer = Answer;
    }
}