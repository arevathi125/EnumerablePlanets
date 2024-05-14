package org.launchcode.controllers;

import org.apache.tomcat.util.log.UserDataHelper;
import org.launchcode.models.Planets;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlanetController {

    @GetMapping
    public String displayIndex(Model model) {
        model.addAttribute("planets", Planets.values());
        return "index";
    }

    @GetMapping("/planet")
    public String displayPlanetInfo(@RequestParam("planet") String planet, Model model){
           try {
               Planets selectedPlanet = Planets.valueOf(planet.toUpperCase());
               model.addAttribute("planet", selectedPlanet);
               return "detail";
           }
           catch (IllegalArgumentException e){
               return "redirect:/";
        }

           }

    }

