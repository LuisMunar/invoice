package com.invoice.invoice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.invoice.invoice.models.Invoice;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

  @Autowired
  private Invoice invoice;

  @GetMapping
  public Invoice getInvoice() {
    return invoice;
  }
}
