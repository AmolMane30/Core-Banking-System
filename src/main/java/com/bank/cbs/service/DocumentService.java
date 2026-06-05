package com.bank.cbs.service;

import com.bank.cbs.entity.Customer;
import com.bank.cbs.entity.Document;
import com.bank.cbs.repository.CustomerRepository;
import com.bank.cbs.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepo;

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private CloudinaryService cloudinaryService;

    public Document uploadDocument(Long customerId, String docType, MultipartFile file) throws IOException {

        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Map result = cloudinaryService.uploadFile(file);

        String fileUrl = result.get("secure_url").toString();
        String publicId = result.get("public_id").toString();

        Document doc = new Document();

        doc.setDocType(docType);
        doc.setFileName(file.getOriginalFilename());
        doc.setFileUrl(fileUrl);
        doc.setPublicId(publicId);
        doc.setCustomer(customer);

        return documentRepo.save(doc);
    }

    public List<Document> getDocumentsByCustomer(Long customerId) {
        return documentRepo.findByCustomerCustomerId(customerId);
    }
}