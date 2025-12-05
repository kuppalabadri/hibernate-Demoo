package com.jspiders.project.bms;

import java.time.LocalDate;
    public abstract class BaseEntity {
        private LocalDate createdAt;
        private Long createdBy;
        private LocalDate updatedAt;
        private Long updatedBy;

        public LocalDate getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDate createdAt) {
            this.createdAt = createdAt;
        }

        public Long getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(Long createdBy) {
            this.createdBy = createdBy;
        }

        public LocalDate getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(LocalDate updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Long getUpdatedBy() {

            return updatedBy;
        }

        public void setUpdatedBy(Long updatedBy) {
            this.updatedBy = updatedBy;
        }
    }

