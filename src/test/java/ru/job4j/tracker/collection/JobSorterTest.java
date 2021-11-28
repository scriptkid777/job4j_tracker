package ru.job4j.tracker.collection;

import org.junit.Test;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JobSorterTest {

    @Test
    public void whenJobByNameUp() {
        List<Job> jobs = Arrays.asList(
                new Job("C#", 3),
                new Job("Java", 2),
                new Job("PHP", 1)
        );
        List<Job> jobs1 = Arrays.asList(
                new Job("PHP", 1),
                new Job("Java", 2),
                new Job("C#", 3)
        );
        JobSorter jobSorter = new JobSorter();
        assertThat(jobSorter.jobBySortNameUp(jobs1), is(jobs));
    }

    @Test
    public void whenJobByName() {
        List<Job> jobs = Arrays.asList(
                new Job("PHP", 1),
                new Job("Java", 2),
                new Job("C#", 3)
        );
        List<Job> jobs1 = Arrays.asList(
                new Job("C#", 3),
                new Job("Java", 2),
                new Job("PHP", 1)
        );
        JobSorter jobSorter = new JobSorter();
        assertThat(jobSorter.jobBySortName(jobs1), is(jobs));
    }

    @Test
    public void whenJobSortPriorityUp() {
        List<Job> jobs = Arrays.asList(
                new Job("First", 1),
                new Job("Third", 2),
                new Job("Second", 3)
        );
        List<Job> jobs1 = Arrays.asList(
                new Job("First", 1),
                new Job("Second", 3),
                new Job("Third", 2)
        );
        JobSorter jobSorter = new JobSorter();
        assertThat(jobSorter.jobBySortPriorityUp(jobs1), is(jobs));
    }

    @Test
    public void whenJobSortPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Second", 3),
                new Job("Third", 2),
                new Job("First", 1)
        );
        List<Job> jobs1 = Arrays.asList(
                new Job("First", 1),
                new Job("Second", 3),
                new Job("Third", 2)
        );
        JobSorter jobSorter = new JobSorter();
        assertThat(jobSorter.jobBySortPriority(jobs1), is(jobs));
    }

    @Test
    public void whenJobSortPriorityAndName() {
        List<Job> jobs = Arrays.asList(
                new Job("A", 1),
                new Job("B", 1),
                new Job("C", 1)
        );
        List<Job> jobs1 = Arrays.asList(
                new Job("A", 1),
                new Job("C", 1),
                new Job("B", 1)
        );
        JobSorter jobSorter = new JobSorter();
        assertThat(jobSorter.jobBySortPriorityAndName(jobs1), is(jobs));
    }

    @Test
    public void whenJobSortNameAndPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("A", 1),
                new Job("A", 2),
                new Job("A", 3)
        );
        List<Job> jobs1 = Arrays.asList(
                new Job("A", 2),
                new Job("A", 1),
                new Job("A", 3)
        );
        JobSorter jobSorter = new JobSorter();
        assertThat(jobSorter.jobBySortNameAndPriority(jobs1), is(jobs));
    }
}