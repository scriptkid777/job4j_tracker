package ru.job4j.tracker;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
           run = action.execute(input, tracker);
        }
    }

        private void showMenu(UserAction[] actions) {

        System.out.println("Menu.");
            for (int i = 0; i < actions.length; i++) {
                System.out.println(i + ". " + actions[i].name());
            }
        }

        public static void main(String[]args) {
        Output output = new StubOutput();
            Input input = new ConsoleInput();
            Tracker tracker = new Tracker();
            UserAction[] actions = {
                    new CreateAction(output),
                    new DeleteAction(),
                    new EditAction(),
                    new FindIdAction(),
                    new FindNameAction(),
                    new FindAllAction(),
                    new ExitAction(output)
            };
            new StartUI(output).init(input, tracker, actions);
        }


    }

