package org.example.demobt2.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "resumes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resumeId;

    @OneToOne
    @JoinColumn(name = "application_id", unique = true)
    private Application application;

    private String resumeUrl;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}