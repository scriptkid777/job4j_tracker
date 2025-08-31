package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.*;

public class FindByIdActionTest {
    @Test
    public void whenItemWasFindByIdSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Item"));
        FindIdAction findIdAction = new FindIdAction(output);
        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(item.getId());
        findIdAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find item by id ===" + ln
                        + item + ln
        );
    }

    @Test
    public void whenItemWasFindByIdNotSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        FindIdAction findByIdAction = new FindIdAction(output);
        Input input = mock(Input.class);
        int testId = 5;

        when(input.askInt(any(String.class))).thenReturn(testId);
        findByIdAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find item by id ===" + ln
                        + "Заявка с введенным id: "
                        + testId + " не найдена."
                        + ln
        );
    }
}
