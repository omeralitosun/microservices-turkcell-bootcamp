package com.kodlamaio.invoiceservice.controller;

import com.kodlamaio.invoiceservice.entities.Invoice;
import com.kodlamaio.invoiceservice.repository.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/invoice")
public class InvoiceController {

    public final InvoiceRepository repository;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice add(@RequestBody Invoice request) {
        return repository.save(request);
    }
}
