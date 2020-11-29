package kr.hs.emirim.s2019w04.sora;

public class SoraContext {
    public String questions;
    public String answer;

    public SoraContext() {

    }

    public SoraContext(String questions, String answer) {
        this.questions = questions;
        this.answer = answer;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
