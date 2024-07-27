package com.example.exerciescontrollerrestandcrudcustomer.Controller;

import com.example.exerciescontrollerrestandcrudcustomer.ApiResponse.Api;
import com.example.exerciescontrollerrestandcrudcustomer.ApiResponse.CustomerResponse;
import com.example.exerciescontrollerrestandcrudcustomer.Model.Customer;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/Customer")
public class CustomerController {

    ArrayList<Customer> customers = new ArrayList<Customer>();

    @GetMapping("/get")
    public CustomerResponse getCustomer() {
        return new CustomerResponse(200," Data Return Successful" ,customers);

    }

    @PostMapping("/add")
    public Api addCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return new Api(200," Customer Added Successful");
    }

    @PutMapping("/update/{index}")
    public Api updateCustomer(@PathVariable int index, @RequestBody Customer customer) {
        customers.set(index,customer);
        return new Api(200," Customer Updated Successful");
    }

    @DeleteMapping("/delete/{index}")
    public Api deleteCustomer(@PathVariable int index) {
        customers.remove(index);
        return new Api(200," Customer Deleted Successful");
    }

    @PostMapping("/deposit/{id}/{amount}")
    public Api depositCustomer(@PathVariable int id , @PathVariable int amount) {

       for(Customer customer : customers)
       {
           if(customer.getId() == id) {
               int total = customer.getBalance() + amount;
               customer.setBalance(total);
               return new Api(200," Balance Deposit Successful");
           }
       }
        return new Api(404," Customer Not Found!");

    }


@PostMapping("/withdraw/{id}/{amount}")
    public Api withdrawCustomer(@PathVariable int id , @PathVariable int amount) {

        for(Customer customer : customers)
        {
            if(customer.getId() == id) {
                if(amount > customer.getBalance()) {
                    return new Api(400," Balance Not Enough! ");
                }
                int total = customer.getBalance() - amount;
                customer.setBalance(total);
                return new Api(200," Balance is Updated");
            }
        }
        return new Api(404," Customer Not Found!");

    }

}
