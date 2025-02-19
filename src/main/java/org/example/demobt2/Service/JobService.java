package org.example.demobt2.Service;

import org.example.demobt2.Model.Job;

import java.util.List;

public interface JobService {
    List<Job> getJobsByCompany(Long companyId);
    List<Job> getTopJobs();
    List<Job> getRecentJobs();
}
