package vn.edu.iuh.fit.oncuoiky.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import vn.edu.iuh.fit.oncuoiky.converters.RoleConverter;
import vn.edu.iuh.fit.oncuoiky.enums.Roles;

import java.time.LocalDate;

@Entity
@Table(name = "experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id", nullable = false)
    private Long id;

    @Column(name = "company", nullable = false, length = 120)
    private String companyName;

    @Column(name = "work_desc", nullable = false, length = 400)
    private String workDescription;

    @Column(name = "role", nullable = false, columnDefinition = "tinyint(4)")
    @Convert(converter = RoleConverter.class)
    private Roles role;

    @Column(name = "from_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fromDate;

    @Column(name = "to_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate toDate;

    @ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "can_id")
    private Candidate candidate;


    public Experience() {
    }

    public Experience(Long id, String companyName, String workDescription, Roles role, LocalDate fromDate, LocalDate toDate, Candidate candidate) {
        this.id = id;
        this.companyName = companyName;
        this.workDescription = workDescription;
        this.role = role;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.candidate = candidate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
}
