/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.controller;

import com.supinfo.entity.Customer;
import com.supinfo.service.CustomerService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 15729_000
 */
@ManagedBean
@RequestScoped
public class ProfileController {
    @EJB
    CustomerService customerService;
    private String username;
    private String password;
    private String phonenumber;
    private String firstname;
    private String lastname;
    private String email;
    private String credit;
    private Customer _customer;
    /**
     * Creates a new instance of ProfileController
     */
    public ProfileController() {
         HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
         Customer customer = (Customer) session.getAttribute("customer");
        this._customer = customer;
        this.username = customer.getUsername();
        this.phonenumber = customer.getPhonenumber();
        this.firstname = customer.getFirstname();
        this.lastname = customer.getLastname();
        this.email = customer.getEmail();
        this.credit = customer.getCreditCardNumber();
    }
    public String update(){
        this._customer.setCreditCardNumber(this.credit);
        this._customer.setEmail(this.email);
        this._customer.setFirstname(this.firstname);
        this._customer.setLastname(this.lastname);
        this._customer.setPassword(this.password);
        this._customer.setPhonenumber(this.phonenumber);
        customerService.updateCustomer(this._customer);
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.removeAttribute("customer");
        return "success";
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }
    
}
