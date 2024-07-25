package com.example.exercisecontrollerlayerrestcrud.Api;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiResponse {

    private String id;
    private String title;
    private String description;
    private String status;

}
