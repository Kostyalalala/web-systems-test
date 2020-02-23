package web.systems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.systems.entity.EquationEntity;
import web.systems.service.EquationService;

@Controller
public class EquationController {

    @Autowired
    private EquationService equationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listEmployees(ModelMap map) {
        map.addAttribute("equation", new EquationEntity());

        return "equation";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute(value = "equation") EquationEntity equation, BindingResult result) {
        equationService.getRoot(equation.getA(), equation.getB(), equation.getC());
        return "redirect:/";
    }

    public void setEquationService(EquationService equationService) {
        this.equationService = equationService;
    }
}
