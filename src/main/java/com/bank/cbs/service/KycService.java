package com.bank.cbs.service;

import com.bank.cbs.entity.Customer;
import com.bank.cbs.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class KycService {

    @Autowired
    private CustomerRepository customerRepo;

    private final String PYTHON_KYC_URL = "http://localhost:5000/kyc"; // change later with ngrok

    public String verifyKyc(Long customerId) {

        Customer customer = customerRepo.findById(customerId).orElseThrow();

        // Dummy call (for now)
        // Later replace with actual Python API call

        boolean isVerified = true; // simulate response

        if (isVerified) {
            customer.setStatus("VERIFIED");
            customerRepo.save(customer);
            return "KYC VERIFIED";
        } else {
            customer.setStatus("REJECTED");
            customerRepo.save(customer);
            return "KYC REJECTED";
        }
    }
}