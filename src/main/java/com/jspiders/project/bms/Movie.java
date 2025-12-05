package com.jspiders.project.bms;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "movie")

    public class Movie extends Object {
        @Id//PK
        @GeneratedValue(strategy = GenerationType.IDENTITY)//Use AI
        private Long id;

        @Column(name = "title",nullable = false,length = 100)
        private String title;

        @Column(name = "language",nullable = false,length = 75)
        private String language;

        @Column(name = "duration",nullable = false)
        private Integer duration;

        @Column(name = "certification",nullable = false,length = 5)
        private String certification;

        @Column(name = "status")
        @Enumerated(EnumType.STRING)
        private MovieStatus status;

        @Column(name = "created_by")
        private Long createdBy;
        @Column(name = "updated_by")
        private Long updatedBy;
        @Column(name = "created_at",nullable = false)
        private LocalDate createdAt;
        @Column(name = "updated_at")
        private LocalDate updatedAt;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public Integer getDuration() {
            return duration;
        }

        public void setDuration(Integer duration) {
            this.duration = duration;
        }

        public String getCertification() {
            return certification;
        }

        public void setCertification(String certification) {
            this.certification = certification;
        }

        public MovieStatus getStatus() {
            return status;
        }

        public void setStatus(MovieStatus status) {
            this.status = status;
        }

        public Long getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(Long createdBy) {
            this.createdBy = createdBy;
        }

        public Long getUpdatedBy() {
            return updatedBy;
        }

        public void setUpdatedBy(Long updatedBy) {
            this.updatedBy = updatedBy;
        }

        public LocalDate getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDate createdAt) {
            this.createdAt = createdAt;
        }

        public LocalDate getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(LocalDate updatedAt) {
            this.updatedAt = updatedAt;
        }

        @Override
        public String toString() {
            return "Movie{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", language='" + language + '\'' +
                    ", duration=" + duration +
                    ", certification='" + certification + '\'' +
                    ", status=" + status +
                    ", createdBy=" + createdBy +
                    ", updatedBy=" + updatedBy +
                    ", createdAt=" + createdAt +
                    ", updatedAt=" + updatedAt +
                    '}';
        }
    }

