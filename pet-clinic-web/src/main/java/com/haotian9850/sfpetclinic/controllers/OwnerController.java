package com.haotian9850.sfpetclinic.controllers;

import com.haotian9850.sfpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;   //inject through constructor
    }

    @RequestMapping({"/owners", "owners/index", "owners/index.html"})
    public String listOnwers(Model model){
        //inject model
        model.addAttribute("owners", ownerService.findAll());   //return a set to be iterated over

        return "owners/index";
    }


    /*TODO: find out why this is not redirecting to notimplemented page*/
    @RequestMapping("/find")
    public String findOwners(){
        return "notimplemented";
    }
}
