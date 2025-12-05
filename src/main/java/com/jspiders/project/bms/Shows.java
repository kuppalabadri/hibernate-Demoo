package com.jspiders.project.bms;
import jakarta.persistence.*;

import java.time.LocalDate;

    @Entity
    @Table(name = "shows")

    public class Shows {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto Inc.
        private Long id;
        @Column(name = "show_time")
        private LocalDate showTime;
        @Column(name = "end_time")
        private LocalDate endTime;
        @Column(name = "status")
        private String status;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public LocalDate getShowTime() {
            return showTime;
        }

        public void setShowTime(LocalDate showTime) {
            this.showTime = showTime;
        }

        public LocalDate getEndTime() {
            return endTime;
        }

        public void setEndTime(LocalDate endTime) {
            this.endTime = endTime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

    }

