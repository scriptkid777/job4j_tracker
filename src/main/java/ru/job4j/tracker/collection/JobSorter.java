package ru.job4j.tracker.collection;


import java.util.Collections;
import java.util.List;

public class JobSorter {
public List<Job> jobBySortNameUp(List<Job> jobs) {
    Collections.sort(jobs, new JobDescByNameUp());
    return jobs;
}

    public List<Job> jobBySortPriorityUp(List<Job> jobs) {
        Collections.sort(jobs, new JobDescByPriorityUp());
        return jobs;
    }

    public List<Job> jobBySortName(List<Job> jobs) {
        Collections.sort(jobs, new JobDescByName());
        return jobs;
    }

    public List<Job> jobBySortPriority(List<Job> jobs) {
        Collections.sort(jobs, new JobDescByPriority());
        return jobs;
    }

    public List<Job> jobBySortPriorityAndName(List<Job> jobs) {
        Collections.sort(jobs, new JobDescByPriorityUp().thenComparing(new JobDescByNameUp()));
        return jobs;
    }

    public List<Job> jobBySortNameAndPriority(List<Job> jobs) {
        Collections.sort(jobs, new JobDescByNameUp().thenComparing(new JobDescByPriorityUp()));
        return jobs;
    }
}
