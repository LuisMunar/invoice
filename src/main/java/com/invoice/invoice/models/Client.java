package com.invoice.invoice.models;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Value;

@Component
@SessionScope
@JsonIgnoreProperties(value = { "targetSource", "advisors", "frozen", "targetClass", "proxiedInterfaces", "advisorCount", "proxyTargetClass", "exposeProxy", "preFiltered", "targetObject" })
public class Client {
  @Value("${client.name}")
  private String name;
  
  @Value("${client.lastname}")
  private String lastname;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }
}
