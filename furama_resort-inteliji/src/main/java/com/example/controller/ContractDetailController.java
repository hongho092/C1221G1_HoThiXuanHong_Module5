package com.example.controller;

import com.example.dto.ContractDetailDto;
import com.example.dto.ContractDto;
import com.example.dto.ServiceDto;
import com.example.model.contract.AttachService;
import com.example.model.contract.Contract;
import com.example.model.contract.ContractDetail;
import com.example.service.contract.IAttachServiceService;
import com.example.service.contract.IContractDetailService;
import com.example.service.contract.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(value = "/contract_detail")
public class ContractDetailController {

    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private IContractService contractService;

    @Autowired
    private IAttachServiceService attachServiceService;

    @GetMapping(value = "/list")
    public String goListContract(@PageableDefault(value = 3) Pageable pageable, Model model) {
        Page<ContractDetail> contractDetailPage = contractDetailService.findAll(pageable);
        model.addAttribute("contractDetailPage", contractDetailPage);
        return "contract_detail/list";
    }

    @GetMapping(value = "/create")
    public String showCreateContract(Model model) {
        model.addAttribute("contractDetailDto", new ContractDetailDto());
        model.addAttribute("contractList", contractService.findList());
        model.addAttribute("attachServiceList", attachServiceService.findAll());
        return "contract_detail/create";
    }

    @PostMapping(value = "/save")
    public String saveService(@ModelAttribute @Validated ContractDetailDto contractDetailDto,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes,
                              Model model) {
        new ServiceDto().validate(contractDetailDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("contractList", contractService.findList());
            model.addAttribute("attachServiceList", attachServiceService.findAll());
            return "contract_detail/create";
        } else {
            ContractDetail contractDetail = new ContractDetail();
            BeanUtils.copyProperties(contractDetailDto, contractDetail);
            contractDetailService.save(contractDetail);
            redirectAttributes.addFlashAttribute("mess", "Create Contract Detail Success");
            return "redirect:/contract_detail/list";
        }
    }
}
