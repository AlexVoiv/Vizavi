package com.vizavi.application.models.dtos;
import com.vizavi.application.models.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public class OrderDTO {
        private long id;
        private String name;
        private double price;
        private User user;
    }

