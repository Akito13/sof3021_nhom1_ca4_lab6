package com.example.sof3021_nhom1_ca4_lab6.controller;

import com.example.sof3021_nhom1_ca4_lab6.model.Sach;
import com.example.sof3021_nhom1_ca4_lab6.repository.SachRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/product")
public class Bai2Controller{
    @Autowired
    private HttpSession session;
    @Autowired
    private SachRepository sachRepo;

    @RequestMapping("/search-and-page")
    public String searchAndPage(Model model,
                                @RequestParam("keywords") Optional<String> kw,
                                @RequestParam("p") Optional<Integer> p,
                                @RequestParam("order") Optional<String> order){
        String keywords = kw.orElse("");
        Sort sort = null;
        if(order.isEmpty()) {
            sort = Sort.by(Sort.Direction.ASC,  "tensach");
        } else {
            String by = order.get();
            if (by.equals("d")) {
                sort = Sort.by(Sort.Direction.DESC, "nxb");
            } else if (by.equals("a")){
                sort = Sort.by(Sort.Direction.ASC, "nxb");
            } else if (by.equals("pd")) {
                sort = Sort.by(Sort.Direction.DESC, "gia");
            } else if (by.equals("pa")) {
                sort = Sort.by(Sort.Direction.ASC, "gia");
            }
            model.addAttribute("order", by);
        }
        Pageable pageable = PageRequest.of(p.orElse(0), 5, sort);
        Page<Sach> page = sachRepo.findByTensach("%"+keywords+"%", pageable);
        model.addAttribute("page", page);
        model.addAttribute("kw", keywords);
        return "Bai2";
    }
}