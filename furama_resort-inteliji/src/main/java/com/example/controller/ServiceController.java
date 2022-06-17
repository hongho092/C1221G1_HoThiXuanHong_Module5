package com.example.controller;

import com.example.dto.ServiceDto;
import com.example.model.customer.Customer;
import com.example.model.customer.CustomerType;
import com.example.model.service.RentType;
import com.example.model.service.Service;
import com.example.model.service.ServiceType;
import com.example.service.customer.ICustomerService;
import com.example.service.customer.ICustomerTypeService;
import com.example.service.service.IRentTypeService;
import com.example.service.service.IServiceService;
import com.example.service.service.IServiceTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/service")
public class ServiceController {

    @Autowired
    private IServiceService serviceService;

    @Autowired
    private IServiceTypeService serviceTypeService;

    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping(value = "/list")
    public String goListCustomer(@PageableDefault(value = 3) Pageable pageable,
                                 @RequestParam Optional<String> search_code,
                                 @RequestParam Optional<String> search_name,
                                 @RequestParam Optional<Integer> search_category,
                                 Model model) {
        String searchCode = search_code.orElse("");
        String searchName = search_name.orElse("");
        int searchCategory = search_category.orElse(-1);
        Page<Service> servicePage = null;
        if (searchCategory == -1) {
            servicePage = serviceService.findAll1(searchCode, searchName, pageable);
        } else {
            servicePage = serviceService.findAll2(searchCode, searchName, searchCategory, pageable);
        }
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        model.addAttribute("servicePage", servicePage);
        model.addAttribute("searchCode", searchCode);
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchCategory", searchCategory);
        return "service/list";
    }

    @GetMapping(value = "/create")
    public String showCreateService(Model model) {
        model.addAttribute("serviceDto", new ServiceDto());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        model.addAttribute("serviceTypeList", serviceTypeService.findAll());
        return "service/create";
    }

    @PostMapping(value = "/save")
    public String saveService(@ModelAttribute @Validated ServiceDto serviceDto,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,
                              Model model) {
        List<Service> serviceList = serviceService.findAll();
        new ServiceDto().validate(serviceDto, bindingResult);
        new ServiceDto().validate1(serviceDto, bindingResult, serviceList);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("rentTypeList", rentTypeService.findAll());
            model.addAttribute("serviceTypeList", serviceTypeService.findAll());
            return "service/create";
        } else {
            Service service = new Service();
            BeanUtils.copyProperties(serviceDto, service);
            serviceService.save(service);
            redirectAttributes.addFlashAttribute("mess", "Create Service Success");
            return "redirect:/service/list";
        }
    }

    @GetMapping(value = "/list_service_type")
    public String goListServiceType(Model model) {
        model.addAttribute("serviceTypeList", serviceTypeService.findAll());
        model.addAttribute("serviceType", new ServiceType());
        return "service/service_type";
    }

    @PostMapping(value = "/save_service_type")
    public String saveServiceType(@ModelAttribute ServiceType serviceType, RedirectAttributes redirectAttributes) {
        serviceTypeService.save(serviceType);
        redirectAttributes.addFlashAttribute("mess", "Create Service Type Success");
        return "redirect:/service/list_service_type";
    }

    @GetMapping(value = "/list_rent_type")
    public String goListRentType(Model model) {
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        model.addAttribute("rentType", new RentType());
        return "service/rent_type";
    }

    @PostMapping(value = "/save_rent_type")
    public String saveRentType(@ModelAttribute RentType rentType, RedirectAttributes redirectAttributes) {
        rentTypeService.save(rentType);
        redirectAttributes.addFlashAttribute("mess", "Create Rent Type Success");
        return "redirect:/service/list_rent_type";
    }
}
