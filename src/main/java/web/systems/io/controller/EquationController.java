package web.systems.io.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.systems.engine.dto.EquationDTO;
import web.systems.engine.service.EquationService;

@Controller
public class EquationController {

    private static final String EQUATION = "equation";
    @Autowired
    private EquationService equationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listEmployees(ModelMap map) {
        map.addAttribute(EQUATION, EquationDTO.builder().build());

        return EQUATION;
    }

    @RequestMapping("/{id}")
    public String deleteEmplyee(@PathVariable("id") Integer id, ModelMap map) {
        EquationDTO equationDTO = equationService.getById(id);
        map.addAttribute("result", equationService.createEquationString(equationDTO));
        return "result";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute(value = EQUATION) EquationDTO equation, BindingResult result,
            ModelMap map) {
        Integer id = equationService.getRoot(equation);

        return "redirect:/" + id;
    }
}
