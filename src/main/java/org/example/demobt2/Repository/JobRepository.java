package org.example.demobt2.Repository;

import org.example.demobt2.Model.Job;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByCompanyCompanyId(Long companyId);

    @Query("SELECT j FROM Job j LEFT JOIN j.applications a GROUP BY j ORDER BY COUNT(a) DESC")
    List<Job> findTopJobsByApplications(Pageable pageable);

    @Query("SELECT j FROM Job j WHERE j.postingDate >= :date ORDER BY j.postingDate DESC")
    List<Job> findRecentJobs(@Param("date") LocalDateTime date, Pageable pageable);
}
