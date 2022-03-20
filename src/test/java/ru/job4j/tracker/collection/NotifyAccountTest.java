package ru.job4j.tracker.collection;

import org.junit.Test;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NotifyAccountTest {

    @Test
    public void sent() {
        List<Account> accounts = List.of(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001")
        );
        HashSet<Account> expect = new HashSet<>(
                List.of(
                        new Account("123", "Petr Arsentev", "eDer3432f"),
                        new Account("142", "Petr Arsentev", "000001")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expect));
    }

    @Test
    public void deleteDuplicat() {
        List<Account> accounts = List.of(
                new Account("123", "Petr Arsentev", "binbvvc?"),
                new Account("123", "Petr Arsentev", "binbvvc?"),
                new Account("125", "Petr Arsentev", "q0w9er")
        );
        HashSet<Account> expected = new HashSet<>(
                List.of(
                        new Account("123", "Petr Arsentev", "binbvvc?"),
                        new Account("125", "Petr Arsentev", "q0w9er")
                )
        );
        assertThat(NotifyAccount.sent(accounts), is(expected));
    }

}