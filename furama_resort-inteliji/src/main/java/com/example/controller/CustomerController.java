package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.dto.CustomerUsingNow;
import com.example.model.customer.Customer;
import com.example.model.customer.CustomerType;
import com.example.service.customer.ICustomerService;
import com.example.service.customer.ICustomerTypeService;
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

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping(value = "/list")
    public String goListCustomer(@PageableDefault(value = 3) Pageable pageable,
                                 @RequestParam Optional<String> search_name,
                                 @RequestParam Optional<String> search_address,
                                 @RequestParam Optional<Integer> search_category,
                                 Model model) {
        String searchName = search_name.orElse("");
        String searchAddress = search_address.orElse("");
        int searchCategory = search_category.orElse(-1);
        Page<Customer> customerPage = null;
        if (searchCategory == -1) {
            customerPage = customerService.findAll1(searchName, searchAddress, pageable);
        } else {
            customerPage = customerService.findAll2(searchName, searchAddress, searchCategory, pageable);
        }
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        model.addAttribute("customerPage", customerPage);
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchAddress", searchAddress);
        model.addAttribute("searchCategory", searchCategory);
        return "customer/list";
    }

    @GetMapping(value = "/create")
    public String showCreateCustomer(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping(value = "/save")
    public String saveCustomer(@ModelAttribute @Validated CustomerDto customerDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               Model model) {
//        System.out.println(customerDto.getCustomerBirthday());
        List<Customer> customerList = customerService.findAll();
        CustomerDto customerDto1 = new CustomerDto();
        customerDto1.validate(customerDto, bindingResult);
//        customerDto1.validate1(customerDto, bindingResult, customerList);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerTypeList", customerTypeService.findAll());
            return "customer/create";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("mess", "Create Customer Success");
            return "redirect:/customer/list";
        }
    }

    @GetMapping(value = "/delete")
    public String deleteCustomer(@RequestParam int id, RedirectAttributes redirectAttributes) {
        customerService.deleteById(id);
//        customerService.updateFlag(id);
        redirectAttributes.addFlashAttribute("mess", "Delete Customer Success");
        return "redirect:/customer/list";
    }

    @GetMapping(value = "/edit")
    public String showEditEmployee(@RequestParam int id, Model model) {
        Customer customer = customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        model.addAttribute("customerDto", customerDto);
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        return "customer/edit";
    }

    @PostMapping(value = "/save_edit")
    public String editCustomer(@ModelAttribute @Validated CustomerDto customerDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               Model model) {
        List<Customer> customerList = customerService.findAll();
        CustomerDto customerDto1 = new CustomerDto();
        customerDto1.validate(customerDto, bindingResult);
//        customerDto1.validate1(customerDto, bindingResult, customerList);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerTypeList", customerTypeService.findAll());
            return "customer/edit";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save1(customer);
            redirectAttributes.addFlashAttribute("mess", "Edit Customer Success");
            return "redirect:/customer/list";
        }
    }

    @GetMapping(value = "/detail")
    public String detailCustomer(@RequestParam int id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "customer/detail";
    }

    @GetMapping(value = "/list_customer_type")
    public String goListCustomerType(Model model) {
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        model.addAttribute("customerType", new CustomerType());
        return "customer/customer_type";
    }

    @GetMapping(value = "/save_customer_type")
    public String saveCustomerType(@ModelAttribute CustomerType customerType, RedirectAttributes redirectAttributes) {
        customerTypeService.save(customerType);
        redirectAttributes.addFlashAttribute("mess", "Create Customer Type Success");
        return "redirect:/customer/list_customer_type";
    }

        @GetMapping(value = "/list_customer_service_now")
    public String get(@PageableDefault(value = 2) Pageable pageable, Model model) {
        Page<CustomerUsingNow> customerUsingNowPage = customerService.get(pageable);
        model.addAttribute("customerUsingNowPage", customerUsingNowPage);
        return "customer/list_customer_service";
    }
}
