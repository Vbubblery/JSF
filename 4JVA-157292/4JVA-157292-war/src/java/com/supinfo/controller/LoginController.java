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
public class LoginController {
    @EJB
    private CustomerService customerService;
    private String username;
    private String password;
    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
    }
     public String login() {
        List<Customer> customers = customerService.retrieveAllCustomers();
        for (Customer item : customers) {
            if (item.getUsername().equals(this.username) && item.getPassword().equals(customerService.SHA1(this.password))) {
                HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                session.setAttribute("customer", item);
                return "success";
            }
        }
        return "error";
    }
         public void logout()
    {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.removeAttribute("customer");
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
         
}
