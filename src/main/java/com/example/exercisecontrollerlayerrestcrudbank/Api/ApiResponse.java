package com.example.exercisecontrollerlayerrestcrudbank.Api;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiResponse {
    private String id;
    private String Username;
    private int balance;
}
