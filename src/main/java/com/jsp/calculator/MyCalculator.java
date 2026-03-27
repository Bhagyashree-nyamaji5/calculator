package com.jsp.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MyCalculator {

    @GetMapping("/")
    public String loadCalc() {
        return "calculator.html";
    }

//    @GetMapping("/add")
//    public String add(ModelMap map, @RequestParam("num1") int x, @RequestParam("num2") int y) {
//        map.put("x", x);
//        map.put("y", y);
//        map.put("result", x + y);
//        return "calculator.html";
//    }
//
//    @GetMapping("/subtract")
//    public String subtract(ModelMap map, @RequestParam("num1") int x, @RequestParam("num2") int y) {
//        map.put("x", x);
//        map.put("y", y);
//        map.put("result", x - y);
//        return "calculator.html";
//    }
//
//    @GetMapping("/multiply")
//    public String multiply(ModelMap map, @RequestParam("num1") int x, @RequestParam("num2") int y) {
//        map.put("x", x);
//        map.put("y", y);
//        map.put("result", x * y);
//        return "calculator.html";
//    }
//
//    @GetMapping("/divide")
//    public String divide(ModelMap map, @RequestParam("num1") int x, @RequestParam("num2") int y) {
//        map.put("x", x);
//        map.put("y", y);
//        if (y == 0) {
//            map.put("result", "Cannot divide by zero");
//        } else {
//            map.put("result", x /(double) y);
//        }
//        return "calculator.html";
//    }
    
 
//============================or=============================================
    @GetMapping("/{op}")
    public String calculate (@PathVariable String op, @RequestParam("num1") int x, @RequestParam("num2") int y , RedirectAttributes attributes) {
    	System.err.println("calculator - logic performed");
    	attributes.addFlashAttribute("x", x);
    	attributes.addFlashAttribute("y", y);
    	attributes.addFlashAttribute("result", op.equals("add")?(x+y):op.equals("subtract")?(x-y):op.equals("multiplication")?(x*y):(x/(double)y));
    	return "redirect:/";
    	
    }
    	
    
}
