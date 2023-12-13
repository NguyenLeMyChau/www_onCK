package vn.edu.iuh.fit.oncuoiky.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.oncuoiky.services.CandidateServices;

@Controller
public class CandidateController {
    @Autowired
    private CandidateServices candidateServices;

    @GetMapping("/")
    public String showHome(){
        return "/index";
    }

    @GetMapping("/candidates")
    public String showCandidates(Model model){
        model.addAttribute("candidates", candidateServices.findAll());
        return "/candidates";
    }

    @GetMapping("/view/{id}")
    public String showInformationCandidate(Model model, @PathVariable Long id){
        model.addAttribute("candidate", candidateServices.findById(id));
        return "/cand_details";
    }

    @GetMapping("/report1")
    public String showReport1(){
        return "/report1";
    }

    @PostMapping("/report1")
    public String getListCandidateByCompany(Model model, @RequestParam("company") String company){
        model.addAttribute("candidates", candidateServices.findCandidateByRoleAndCompany(company));
        return "/report1";
    }

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
