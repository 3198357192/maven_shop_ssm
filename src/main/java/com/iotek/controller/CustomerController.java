package com.iotek.controller;

import com.iotek.po.Customer;
import com.iotek.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/registerCustomer")
    public String registerCustomer(){
        return "success";
    }
    @RequestMapping(value = "/reg.view")
    public String regPage(){
        return "customer/register";
    }

    @RequestMapping(value = "/reg.do")
    public String customerRegister(@ModelAttribute Customer customer, HttpSession session, Model model){
        System.out.println("增加之前"+customer);
        boolean addFlag = customerService.addCustomer(customer);
        System.out.println("增加之后"+customer);
        if (addFlag){
            model.addAttribute("info","注册成功");
            session.setAttribute("customer",customer);
            return "success";
        }
            model.addAttribute("info","注册失败");
        return "customer/index";

    }
    @RequestMapping(value = "/login.view")
    public String loginPage(){
        return "customer/login";
    }
    @RequestMapping(value = "/login.do")
    public String customerLogin(@ModelAttribute Customer customer,HttpSession session,
                                Model model,
                                @RequestParam(value = "isremeber",required = false) String isremeber,
                                HttpServletResponse response
     ){
        System.out.println("登录之前"+customer);
       customer= customerService.queryCustomerByName(customer);
       if (customer==null){
           model.addAttribute("info","登录失败");
                   return "customer/index";
       }
       if ("on".equals(isremeber)){
           Cookie cookieName=new Cookie("customerName",customer.getCustomerName());
           cookieName.setMaxAge(60*60*24*7);
           cookieName.setPath("/");
           Cookie cookiePassword=new Cookie("customerPassword",customer.getCustomerPassword());
           cookiePassword.setMaxAge(60*60*24);
           cookiePassword.setPath("/");
           response.addCookie(cookieName);
           response.addCookie(cookiePassword);

       }
       session.setAttribute("customer",customer);
       model.addAttribute("info","登录成功");
       return "success";

    }




}