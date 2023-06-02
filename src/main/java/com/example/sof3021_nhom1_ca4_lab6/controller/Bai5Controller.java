package com.example.sof3021_nhom1_ca4_lab6.controller;

import com.example.sof3021_nhom1_ca4_lab6.model.Sach;
import com.example.sof3021_nhom1_ca4_lab6.repository.SachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/product")
public class Bai5Controller {

    @Autowired
    private SachRepository sachRepo;

    @RequestMapping("/search-and-page5")
    public String search(Model model,
                         @RequestParam("keywords") Optional<String> kw,
                         @RequestParam("p") Optional<Integer> p){
        String keywords = kw.orElse("");
        Pageable pageable = PageRequest.of(p.orElse(0),5);
        Page<Sach> page = sachRepo.findAllByTensachLike("%"+keywords+"%",pageable);
        model.addAttribute("kw",keywords);
        model.addAttribute("page", page);
        return "Bai5";
    }
}
