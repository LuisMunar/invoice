package com.invoice.invoice.models;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import java.util.List;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@RequestScope
@JsonIgnoreProperties(value = { "targetSource", "advisors", "frozen", "targetClass", "proxiedInterfaces", "advisorCount", "proxyTargetClass", "exposeProxy", "preFiltered", "targetObject" })
public class Invoice {
  @Autowired
  private Client client;

  @Value("${invoice.description}")
  private String description;

  @Autowired
  @Qualifier("itemsInvoiceII")
  private List<Item> items;

  public Invoice() {
    System.out.println("ONE");
  }

  @PostConstruct
  public void init() {
    System.out.println("INVOICE_CREATED");
  }

  @PreDestroy
  public void destroy() {
    System.out.println("INVOICE_DESTROYED");
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  public Double getTotal() {
    return items.stream().mapToDouble(item -> item.getTotal()).sum();
  }
}
