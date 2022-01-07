package ru.job4j.tracker.lambda;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        List<String> list = List.of("one", "two", "three",
                "four", "five", "six", "seven");

        BiConsumer<Integer, String> biCon = (i, s) -> map.put(i, s);

        for (int i = 0; i < list.size(); i++) {
            biCon.accept(i + 1, list.get(i));
        }
        System.out.println(map.toString());

        BiPredicate<Integer, String> biPred = (i, s) -> (i % 2 == 0 || s.length() == 4);
        for (Integer i : map.keySet()) {
            if (biPred.test(i, map.get(i))) {
                System.out.println("key: " + i + " value: " + map.get(i));
            }
        }

        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());

        Consumer<String> con = (s) -> System.out.println(s);

        Function<String, String> func = (fs) -> fs.toUpperCase();

        for (String str  : sup.get()) {
            con.accept(func.apply(str));
        }
    }
}
