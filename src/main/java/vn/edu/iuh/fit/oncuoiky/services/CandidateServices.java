package vn.edu.iuh.fit.oncuoiky.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.oncuoiky.models.Candidate;
import vn.edu.iuh.fit.oncuoiky.repositories.CandidateRepository;

import java.util.List;

@Service
public class CandidateServices {
    @Autowired
    private CandidateRepository candidateRepository;

    public List<Candidate> findAll(){
        return candidateRepository.findAll();
    }

    public Candidate findById(Long id){
        return candidateRepository.findById(id).orElse(null);
    }

    public List<Candidate> findCandidateByRoleAndCompany(String company){
        return candidateRepository.findCandidateByRoleAndCompany(company);
    }

    public List<Candidate> findCandidateByYear(){
        return candidateRepository.findCandidateByYear();
    }
    public List<Candidate> findCandidateByRole(int role){
        return candidateRepository.findCandidateByRole(role);
    }

}
