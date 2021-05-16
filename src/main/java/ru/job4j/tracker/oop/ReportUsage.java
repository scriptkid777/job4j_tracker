package ru.job4j.tracker.oop;

public class ReportUsage {
    public static void main(String[] args) {
        TextReport report1 = new TextReport();
        String text1 = report1.generate("Report's name", "Report's body");
        System.out.println(text1);

        JSONReport report2 = new JSONReport();
        String text2 = report2.generate("report's name", "report's body");
        System.out.println(text2);
    }
}
