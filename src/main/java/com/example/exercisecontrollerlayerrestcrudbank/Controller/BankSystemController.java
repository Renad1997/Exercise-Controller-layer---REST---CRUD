package com.example.exercisecontrollerlayerrestcrudbank.Controller;

import com.example.exercisecontrollerlayerrestcrudbank.Api.ApiResponse;
import com.example.exercisecontrollerlayerrestcrudbank.Model.BankSystem;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/BankSystem")
public class BankSystemController {

    ArrayList<BankSystem> bankSystems = new ArrayList<BankSystem>();

    @GetMapping("/get")
    public ArrayList<BankSystem> getBankSystems() {
        return bankSystems;
    }

    @PostMapping("/add")
    public ApiResponse addBankSystem(@RequestBody BankSystem bankSystem) {
        bankSystems.add(bankSystem);
        return new ApiResponse("1","user Added",0);
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateBankSystem(@PathVariable int index, @RequestBody BankSystem bankSystem) {
        bankSystems.set(index, bankSystem);
        return new ApiResponse("2","user Updated",0);
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteBankSystem(@PathVariable int index) {
        bankSystems.remove(index);
        return new ApiResponse("3","user Deleted",0);
    }

@PostMapping("/add1")
   public ApiResponse depositBankSystem(@PathVariable int balance ,@RequestBody BankSystem bankSystem) {
       bankSystems.add(balance,bankSystem);
       bankSystem.setBalance(balance);
        return new ApiResponse("4","user Deposit",0);
    }

@GetMapping("/get1")
    public ApiResponse withdrawBankSystem(@RequestBody int balance ) {
        bankSystems.get(balance);
        return new ApiResponse("5","user Withdraw",0);

    }


}
