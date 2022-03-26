package ru.job4j.tracker.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(subj -> subj.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0);

    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.
                map(pupil -> new Tuple(pupil.getName(), pupil.getSubjects()
                        .stream()
                        .mapToInt(Subject::getScore)
                        .average()
                        .orElse(0))).collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(subj -> subj.getSubjects().stream())
                        .collect(Collectors.groupingBy(Subject::getName, LinkedHashMap::new, Collectors.averagingDouble(Subject::getScore)))
                        .entrySet()
                        .stream()
                        .map(m -> new Tuple(m.getKey(), m.getValue()))
                        .collect(Collectors.toList());

    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.
                map(pupil -> new Tuple(pupil.getName(), pupil.getSubjects()
                        .stream()
                        .mapToInt(Subject::getScore)
                        .sum()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(subj -> subj.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(m -> new Tuple(m.getKey(), m.getValue()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }

}
