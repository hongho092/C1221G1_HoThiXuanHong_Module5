package com.example.controller;

import com.example.dto.EmployeeDto;
import com.example.model.employee.Division;
import com.example.model.employee.EducationDegree;
import com.example.model.employee.Employee;
import com.example.model.employee.Position;
import com.example.service.employee.IDivisionService;
import com.example.service.employee.IEducationDegreeService;
import com.example.service.employee.IEmployeeService;
import com.example.service.employee.IPositionService;
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
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IDivisionService divisionService;

    @Autowired
    private IEducationDegreeService educationDegreeService;

    @Autowired
    private IPositionService positionService;

    @GetMapping(value = "/list")
    public String goListEmployee(@PageableDefault(value = 3) Pageable pageable,
                                 @RequestParam Optional<String> search_name,
                                 @RequestParam Optional<String> search_address,
                                 @RequestParam Optional<Integer> search_category,
                                 Model model) {
        String searchName = search_name.orElse("");
        String searchAddress = search_address.orElse("");
        int searchCategory = search_category.orElse(-1);
        Page<Employee> employeePage = null;
        if (searchCategory == -1) {
            employeePage = employeeService.findAll1(searchName, searchAddress, pageable);
        } else {
            employeePage = employeeService.findAll2(searchName, searchAddress, searchCategory, pageable);
        }
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("employeePage", employeePage);
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchAddress", searchAddress);
        model.addAttribute("searchCategory", searchCategory);
        return "employee/list";
    }

    @GetMapping(value = "/create")
    public String showCreateEmployee(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("educationDegreeList", educationDegreeService.findAll());
        model.addAttribute("positionList", positionService.findAll());
        return "employee/create";
    }

    @PostMapping(value = "/save")
    public String saveEmployee(@ModelAttribute @Validated EmployeeDto employeeDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               Model model) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("divisionList", divisionService.findAll());
            model.addAttribute("educationDegreeList", educationDegreeService.findAll());
            model.addAttribute("positionList", positionService.findAll());
            return "employee/create";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("mess", "Create Employee Success");
            return "redirect:/employee/list";
        }
    }

    @GetMapping(value = "/delete")
    public String deleteEmployee(@RequestParam int id, RedirectAttributes redirectAttributes) {
        employeeService.deleteById(id);
        redirectAttributes.addFlashAttribute("mess", "Delete Employee Success");
        return "redirect:/employee/list";
    }

    @GetMapping(value = "/edit")
    public String showEditEmployee(@RequestParam int id, Model model) {
        Employee employee = employeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        model.addAttribute("employeeDto", employeeDto);
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("educationDegreeList", educationDegreeService.findAll());
        model.addAttribute("positionList", positionService.findAll());
        return "employee/edit";
    }

    @PostMapping(value = "/save_edit")
    public String editEmployee(@ModelAttribute @Validated EmployeeDto employeeDto,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               Model model) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("divisionList", divisionService.findAll());
            model.addAttribute("educationDegreeList", educationDegreeService.findAll());
            model.addAttribute("positionList", positionService.findAll());
            return "employee/edit";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("mess", "Edit Employee Success");
            return "redirect:/employee/list";
        }
    }

    @GetMapping(value = "/detail")
    public String detailEmployee(@RequestParam int id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "employee/detail";
    }

    @GetMapping(value = "/list_division")
    public String goListDivision(Model model) {
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("division", new Division());
        return "employee/division";
    }

    @PostMapping(value = "/save_division")
    public String saveDivision(@ModelAttribute Division division, RedirectAttributes redirectAttributes) {
        divisionService.save(division);
        redirectAttributes.addFlashAttribute("mess", "Create Division Success");
        return "redirect:/employee/list_division";
    }

    @GetMapping(value = "/list_education_degree")
    public String goListEducationDegree(Model model) {
        model.addAttribute("educationDegreeList", educationDegreeService.findAll());
        model.addAttribute("educationDegree", new EducationDegree());
        return "employee/education_degree";
    }

    @PostMapping(value = "/save_education_degree")
    public String saveEducationDegree(@ModelAttribute EducationDegree educationDegree, RedirectAttributes redirectAttributes) {
        educationDegreeService.save(educationDegree);
        redirectAttributes.addFlashAttribute("mess", "Create Education Degree Success");
        return "redirect:/employee/list_education_degree";
    }

    @GetMapping(value = "/list_position")
    public String goListPosition(Model model) {
        model.addAttribute("positionList", positionService.findAll());
        model.addAttribute("position", new Position());
        return "employee/position";
    }

    @PostMapping(value = "/save_position")
    public String savePosition(@ModelAttribute Position position, RedirectAttributes redirectAttributes) {
        positionService.save(position);
        redirectAttributes.addFlashAttribute("mess", "Create Position Success");
        return "redirect:/employee/list_position";
    }

}
