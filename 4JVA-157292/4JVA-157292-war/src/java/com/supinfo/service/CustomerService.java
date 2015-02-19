/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.service;

import com.supinfo.entity.Customer;
import com.supinfo.jva4.dao.CustomerDao;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 15729_000
 */
@Stateless
public class CustomerService {

    @EJB
    CustomerDao customerDao;

    public Customer addNewCustomer(Customer customer) {
        customerDao.addNewCustomer(customer);
        return customer;
    }
    public List<Customer> retrieveAllCustomers()
    {
        return customerDao.retrieveAllCustomers();
    }
    public Customer updateCustomer(Customer customer)
    {
        return customerDao.updateCustomer(customer);
    }
    public String SHA1(String inStr) {
        MessageDigest md = null;
        String outStr = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(inStr.getBytes());
            outStr = bytetoString(digest);
        } catch (NoSuchAlgorithmException nsae) {
        }
        return outStr;
    }

    public String bytetoString(byte[] digest) {
        String str = "";
        String tempStr = "";

        for (int i = 1; i < digest.length; i++) {
            tempStr = (Integer.toHexString(digest[i] & 0xff));
            if (tempStr.length() == 1) {
                str = str + "0" + tempStr;
            } else {
                str = str + tempStr;
            }
        }
        return str.toLowerCase();
    }
}
