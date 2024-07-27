package com.example.exerciescontrollerrestandcrudcustomer.ApiResponse;

import com.example.exerciescontrollerrestandcrudcustomer.Model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
@AllArgsConstructor
@Data
public class CustomerResponse extends Api {

   private ArrayList<Customer> data;

    public CustomerResponse(int statusCode, String message) {
        super(statusCode, message);
    }
    public CustomerResponse(int statusCode, String message ,ArrayList<Customer> data ) {
        super(statusCode, message);
        this.data = data;
    }
}
