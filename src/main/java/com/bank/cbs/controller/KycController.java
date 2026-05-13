package com.bank.cbs.controller;

import com.bank.cbs.service.KycService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kyc")
public class KycController {

    @Autowired
    private KycService service;

    @PostMapping("/verify/{customerId}")
    public String verifyKyc(@PathVariable Long customerId) {
        return service.verifyKyc(customerId);
    }
}