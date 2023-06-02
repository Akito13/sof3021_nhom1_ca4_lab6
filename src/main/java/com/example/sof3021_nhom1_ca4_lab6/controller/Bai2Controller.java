package com.example.sof3021_nhom1_ca4_lab6.controller;

import com.example.sof3021_nhom1_ca4_lab6.model.Sach;
import com.example.sof3021_nhom1_ca4_lab6.repository.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class Bai2Controller{

    @Autowired
    // câu này mới impport sai, tui mới import lại
    private SessionService session;

    @RequestMapping("/search-and-page")
    public String searchAndPage(Model model,
                                @RequestParam("keywords") Optional<String> kw,
                                @RequestParam("p") Optional<Integer> p){
        String kwords = kw.orElse(session.get());
        session.set();
        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<Sach> page = session.findByTensach("%"+kwords+"%", pageable);
        model.addAttribute("page", page);
        return "Bai2";
    }

}