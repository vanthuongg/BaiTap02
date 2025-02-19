package org.example.demobt2.Service;

import org.example.demobt2.Model.Job;
import org.example.demobt2.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<Job> getJobsByCompany(Long companyId) {
        return jobRepository.findByCompanyCompanyId(companyId);
    }

    @Override
    public List<Job> getTopJobs() {
        Pageable pageable = PageRequest.of(0, 10);
        return jobRepository.findTopJobsByApplications((Pageable) pageable);
    }

    @Override
    public List<Job> getRecentJobs() {
        LocalDateTime sevenDaysAgo = LocalDateTime.now().minusDays(7);
        Pageable pageable = PageRequest.of(0, 10);
        return jobRepository.findRecentJobs(sevenDaysAgo, (Pageable) pageable);
    }
}
