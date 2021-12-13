package data.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/")
public class StrangerController {

    @GetMapping("/stranger")
    public String printBye(ModelMap model) {
        return "stranger";
    }
}
