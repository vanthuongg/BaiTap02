package org.example.demobt2.Controller;

import org.example.demobt2.Model.Company;
import org.example.demobt2.Model.Job;
import org.example.demobt2.Service.CompanyService;
import org.example.demobt2.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JobPortalController {
    @Autowired
    private JobService jobService;

    @Autowired
    private CompanyService companyService;

    // Hiển thị tất cả danh mục (Company)
    @GetMapping("/companies")
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    // Hiển thị tất cả sản phẩm (Job) theo từng danh mục (Company)
    @GetMapping("/companies/{companyId}/jobs")
    public List<Job> getJobsByCompany(@PathVariable Long companyId) {
        return jobService.getJobsByCompany(companyId);
    }

    // Hiển thị 10 sản phẩm (Job) có số lượng ứng tuyển nhiều nhất
    @GetMapping("/jobs/top")
    public List<Job> getTopJobs() {
        return jobService.getTopJobs();
    }

    // Hiển thị 10 sản phẩm (Job) được tạo trong vòng 7 ngày gần đây
    @GetMapping("/jobs/recent")
    public List<Job> getRecentJobs() {
        return jobService.getRecentJobs();
    }
}
