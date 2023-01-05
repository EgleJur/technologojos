package com.baeldung.thymeleaf.expression;

import com.baeldung.thymeleaf.services.Warehouse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class NewController {

    ArrayList<Dino> dinos = new ArrayList<Dino>();
    private final Warehouse warehouse;

    public NewController(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @RequestMapping("/")
    public String dinoList(Model model) {
        Dino dinos = new Dino(1, "alpha", "red", "50kg");

//        model.addAttribute("dinos", new Dino());
//        model.addAttribute("dinos", dinos);
//        System.out.println(dinos);

        model.addAttribute("dinos", warehouse.getAll());
        return "index";

    }

    @RequestMapping("/create")
    public String dinoCreate(Model model) {

        model.addAttribute("dinos", new Dino());

        return "form";

    }

    @PostMapping("/dino")
    public String dinoSubmit(@ModelAttribute Dino dino, Model model) {

        warehouse.addDino(dino);
        //model.addAttribute("dino", dino);
        return "redirect:/";
    }

//    @PostMapping("/delete")
//    public String dinoDelete(@ModelAttribute Dino dino, Model model) {
//
//     //   warehouse.deleteDino(dino);
//        return "redirect:/";
//
//    }
    @RequestMapping("/delete")
    public String dinoDelete(Integer id) {
        warehouse.deleteDino(id);
        return "redirect:/";
    }

}
