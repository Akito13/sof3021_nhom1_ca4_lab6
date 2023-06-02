package com.example.sof3021_nhom1_ca4_lab6.controller;

import com.example.sof3021_nhom1_ca4_lab6.model.BaoCao;
import com.example.sof3021_nhom1_ca4_lab6.repository.BaoCaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/report")
public class Bai3Controller {

    @Autowired
    BaoCaoRepository dao;

    @RequestMapping("/inventory-by-category")
    public String report(Model model){
        List<BaoCao> items = dao.getBaoCaoByLoai();
        model.addAttribute("items",items);
        return "Bai3";
    }
}
