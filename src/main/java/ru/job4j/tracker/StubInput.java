package ru.job4j.tracker;

import ru.job4j.tracker.Input;

import java.util.List;

public class StubInput implements Input {
    private List<String> answers;
    private int position = 0;

    public StubInput(List<String> answers) {
        this.answers = answers;
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(this.askStr(question));
    }

    @Override
    public String askStr(String question) {
        return answers.get(position++);
    }

}
