package com.example.sof3021_nhom1_ca4_lab6.controller;

import com.example.sof3021_nhom1_ca4_lab6.model.Sach;
import com.example.sof3021_nhom1_ca4_lab6.repository.SachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/book")
public class Bai1Controller {

    @Autowired
    private SachRepository sachRepo;

    @RequestMapping("/search")
    public String search(
            Model model,
            @RequestParam("min") Optional<Double> min,
            @RequestParam("max") Optional<Double> max){
        double minValue = min.orElse(0.0);
        double maxValue = max.orElse(Double.MAX_VALUE);
        List<Sach> list = sachRepo.findByGia(minValue,maxValue);
        model.addAttribute("books",list);
        return "Bai1";
    }
}
