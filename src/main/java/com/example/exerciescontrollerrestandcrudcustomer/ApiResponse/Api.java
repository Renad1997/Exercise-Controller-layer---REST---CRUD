package com.example.exerciescontrollerrestandcrudcustomer.ApiResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Api {

    private  int statusCode;
    private String message;

   public Api(){
       statusCode = 200;
       message = "Success";
   }
}
