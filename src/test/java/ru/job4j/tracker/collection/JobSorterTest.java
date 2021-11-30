package ru.job4j.tracker.collection;

import org.junit.Test;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class JobSorterTest {

    @Test
    public void whenJobByNameUp() {
        List<Job> jobs = Arrays.asList(
                new Job("PHP", 1),
                new Job("Java", 2),
                new Job("C#", 3)
        );
        jobs.sort(new JobAscByName());

        List<Job> expect = Arrays.asList(
                new Job("C#", 3),
                new Job("Java", 2),
                new Job("PHP", 1)
        );
        assertThat(jobs, is(expect));
    }

    @Test
    public void whenJobByName() {
        List<Job> jobs = Arrays.asList(
                new Job("C#", 3),
                new Job("Java", 2),
                new Job("PHP", 1)
        );
        jobs.sort(new JobDescByName());

        List<Job> expect = Arrays.asList(
                new Job("PHP", 1),
                new Job("Java", 2),
                new Job("C#", 3)
        );
        assertThat(jobs, is(expect));
    }

    @Test
    public void whenJobSortPriorityUp() {
        List<Job> jobs = Arrays.asList(
                new Job("First", 1),
                new Job("Second", 3),
                new Job("Third", 2)
        );
        jobs.sort(new JobAscByPriority());

        List<Job> expect = Arrays.asList(
                new Job("First", 1),
                new Job("Third", 2),
                new Job("Second", 3)
        );

        assertThat(jobs, is(expect));
    }

    @Test
    public void whenJobSortPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("First", 1),
                new Job("Second", 3),
                new Job("Third", 2)
        );
        jobs.sort(new JobDescByPriority());

        List<Job> expect = Arrays.asList(
                new Job("Second", 3),
                new Job("Third", 2),
                new Job("First", 1)
        );
        assertThat(jobs, is(expect));
    }

    @Test
    public void whenComparatorDescByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorAscByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

}