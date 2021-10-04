package ru.job4j.tracker.collection;
import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String origtext : origin) {
            check.add(origtext);
        }
            for (String str : text) {
                if (!check.contains(str)) {
                    rsl = false;
                    break;
                }
            }
        return rsl;
    }
}
