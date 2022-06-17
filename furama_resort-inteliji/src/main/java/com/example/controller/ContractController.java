package com.example.controller;

import com.example.dto.ContractDto;
import com.example.model.contract.AttachService;
import com.example.model.contract.Contract;
import com.example.model.contract.ContractDetail;
import com.example.service.contract.IAttachServiceService;
import com.example.service.contract.IContractDetailService;
import com.example.service.contract.IContractService;
import com.example.service.customer.ICustomerService;
import com.example.service.employee.IEmployeeService;
import com.example.service.service.IServiceService;
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

import java.util.Optional;

@Controller
@RequestMapping(value = "/contract")
public class ContractController {

    @Autowired
    private IContractService contractService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IServiceService serviceService;

    @Autowired
    private IAttachServiceService attachServiceService;

    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping(value = "/list")
    public String goListContract(@PageableDefault(value = 3) Pageable pageable, Model model) {
        Page<Contract> contractPage = contractService.findAll(pageable);
        model.addAttribute("contractPage", contractPage);
        return "contract/list";
    }

    @GetMapping(value = "/create")
    public String showCreateContract(Model model) {
        model.addAttribute("contractDto", new ContractDto());
        model.addAttribute("customerList", customerService.findAll());
        model.addAttribute("employeeList", employeeService.findAll());
        model.addAttribute("serviceList", serviceService.findAll());
        model.addAttribute("contractList", contractService.findList());
        model.addAttribute("attachServiceList", attachServiceService.findAll());
        return "contract/create";
    }

    @PostMapping(value = "/save")
    public String saveService(@ModelAttribute @Validated ContractDto contractDto,
                              @RequestParam Optional<Integer> attachService,
                              @RequestParam Optional<String> quantity,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,
                              Model model) {
        String quantityVal = quantity.orElse("");
        int attachServiceVal = attachService.orElse(-1);
        new ContractDto().validate(contractDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerList", customerService.findAll());
            model.addAttribute("employeeList", employeeService.findAll());
            model.addAttribute("serviceList", serviceService.findAll());
            model.addAttribute("contractList", contractService.findList());
            model.addAttribute("attachServiceList", attachServiceService.findAll());
            return "contract/create";
        } else {
            ContractDetail contractDetail = new ContractDetail();
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto, contract);
            if (attachServiceVal != -1 && quantityVal.equals("") == false) {
                AttachService attachService1 =  attachServiceService.findById(attachServiceVal);
                contractService.copy(contract, contractDetail, attachService1, quantityVal);
                contractService.save(contract);
                contractDetailService.save(contractDetail);
            } else {
                contractService.save1(contract);
            }
            redirectAttributes.addFlashAttribute("mess", "Create Contract Success");
            return "redirect:/contract/list";
        }
    }


//    @GetMapping(value = "/create")
//    public String showCreateContract(Model model) {
//        model.addAttribute("contractDto", new ContractDto());
//        model.addAttribute("customerList", customerService.findAll());
//        model.addAttribute("employeeList", employeeService.findAll());
//        model.addAttribute("serviceList", serviceService.findAll());
//        return "contract/create";
//    }

//    @PostMapping(value = "/save")
//    public String saveService(@ModelAttribute @Validated ContractDto contractDto,
//                              BindingResult bindingResult,
//                              RedirectAttributes redirectAttributes,
//                              Model model) {
//        new ContractDto().validate(contractDto, bindingResult);
//        if (bindingResult.hasFieldErrors()) {
//            model.addAttribute("customerList", customerService.findAll());
//            model.addAttribute("employeeList", employeeService.findAll());
//            model.addAttribute("serviceList", serviceService.findAll());
//            return "contract/create";
//        } else {
//            Contract contract = new Contract();
//            BeanUtils.copyProperties(contractDto, contract);
//            contractService.save(contract);
//            redirectAttributes.addFlashAttribute("mess", "Create Contract Success");
//            return "redirect:/contract/list";
//        }
//    }
}
