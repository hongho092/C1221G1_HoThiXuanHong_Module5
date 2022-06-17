package com.example.controller;

import com.example.model.contract.AttachService;
import com.example.service.contract.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping(value = "/attach_service")
public class AttachServiceController {

    @Autowired
    private IAttachServiceService attachServiceService;

    @GetMapping(value = "/list")
    public String goListAttachService(@PageableDefault(value = 3) Pageable pageable, Model model) {
        Page<AttachService> attachServicePage = attachServiceService.findAllPage(pageable);
        model.addAttribute("attachServicePage", attachServicePage);
        return "attach_service/list";
    }
}
