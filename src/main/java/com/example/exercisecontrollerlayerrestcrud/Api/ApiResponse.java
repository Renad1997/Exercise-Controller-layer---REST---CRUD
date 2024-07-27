package com.example.exercisecontrollerlayerrestcrud.Api;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiResponse {

    private  int statusCode;
    private String message;



}
