package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping("/dashboard")
    public String firstPage() {
        return "dashboard";
    }
    @RequestMapping("/reademployee")
    public String showReadEmployeePage(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "reademployee";
    }

    @RequestMapping("/createemployee")
    public String showCreateEmployeePage(Model model) {
        List<String> managerList = employeeRepository.findAllManager();
        List<String> dept = Arrays.asList("Dept1","Dept 2","Dept 3","Dept 4");
        model.addAttribute("command", new Employee());
        model.addAttribute("manager", managerList);
        model.addAttribute("departments", dept);
        return "createemployee";
    }

    @RequestMapping(value = "/createemployee", method = RequestMethod.POST)
    public String createEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/reademployee";
    }

    @RequestMapping(value = "/updateemployee/{id}")
    public String showUpdateEmployeePage(@PathVariable int id, Model model) {
        List<String> managerList = employeeRepository.findAllManager();
        List<String> dept = Arrays.asList("Dept 1","Dept 2","Dept 3","Dept 4");
        model.addAttribute("id", id);
        model.addAttribute("command", employeeService.findById(id).orElse(null));
        model.addAttribute("departments", dept);
        model.addAttribute("manager", managerList);
        return "updateemployee";
    }

    @RequestMapping(value = "/updateemployee/{id}", method = RequestMethod.POST)
    public String updateEmployee(@PathVariable int id, @ModelAttribute("employee") Employee employee) {
        employeeService.updateEmployee(id, employee);
        return "redirect:/reademployee";
    }

    @RequestMapping(value = "/deleteemployee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteById(id);
        return "redirect:/reademployee";
    }

}
