package com.iotek.controller;

import com.iotek.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/product")
public class ProductController {


    @RequestMapping(value = "/operProduct/{id}/{oper}")
    public String operProduct(@PathVariable(value = "id") Integer id,@PathVariable(value = "oper") String oper){

        return "success";
    }
}