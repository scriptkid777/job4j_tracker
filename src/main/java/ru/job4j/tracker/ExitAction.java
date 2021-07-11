package ru.job4j.tracker;

public class ExitAction implements UserAction {
    private final Output out;

    public ExitAction(Output out){
        this.out = out;
    }

    @Override
    public String name() {
        return "";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println();
        return false;
    }
}
