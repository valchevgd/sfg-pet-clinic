package com.github.valchevgd.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

    @RequestMapping("oups")
    public String getError() {
        return "notimplemented";
    }

}
