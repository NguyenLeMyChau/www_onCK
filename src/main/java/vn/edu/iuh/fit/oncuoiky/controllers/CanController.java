package vn.edu.iuh.fit.oncuoiky.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.oncuoiky.services.CandidateServices;

@Controller
@RequestMapping("/api")
public class CanController {
    @Autowired
    private CandidateServices candidateServices;
    @GetMapping("/report2")
    public String showReport2(Model model){
        model.addAttribute("candidates", candidateServices.findCandidateByYear());
        return "/report2";
    }

    @GetMapping("/report3")
    public String showReport3(){
        return "/report3";
    }

    @PostMapping("/report3")
    public String getListCandidateByRole(Model model, @RequestParam("role") int role){
        model.addAttribute("candidates", candidateServices.findCandidateByRole(role));
        return "/report3";
    }
}
