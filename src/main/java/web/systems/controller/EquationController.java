package web.systems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.systems.entity.EquationEntity;
import web.systems.service.EquationManager;

@Controller
public class EquationController {

    @Autowired
    private EquationManager employeeManager;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listEmployees(ModelMap map) {
        map.addAttribute("employee", new EquationEntity());

        return "editEmployeeList";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute(value = "employee") EquationEntity employee, BindingResult result) {
        employeeManager.addEmployee(employee);
        return "redirect:/";
    }

    public void setEmployeeManager(EquationManager employeeManager) {
        this.employeeManager = employeeManager;
    }
}
