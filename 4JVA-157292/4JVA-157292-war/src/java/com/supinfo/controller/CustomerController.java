/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.controller;

import com.supinfo.entity.Customer;
import com.supinfo.service.CustomerService;
import java.util.List;
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
public class CustomerController {

    @EJB
    private CustomerService customerService;
    private String username;
    private String password;
    private String phonenumber;
    private String firstname;
    private String lastname;
    private String email;
    private String credit;

    /**
     * Creates a new instance of CustomerControllwe
     */
    public CustomerController() {
    }

    public String register() {
        Customer customer = new Customer();
        customer.setUsername(username);
        customer.setPassword(customerService.SHA1(password));
        customer.setPhonenumber(phonenumber);
        customer.setFirstname(firstname);
        customer.setLastname(lastname);
        customer.setEmail(email);
        customer.setCreditCardNumber(credit);
        try {
            customerService.addNewCustomer(customer);
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            session.setAttribute("customer", customer);
            return "success";
        } catch (Exception e) {
            return "error";
        }
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
