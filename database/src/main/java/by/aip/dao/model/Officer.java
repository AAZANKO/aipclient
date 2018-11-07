package by.aip.dao.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode(of = "id")
@Builder
@Entity
@Table(name = "officer", schema = "opday")
@Inheritance(strategy = InheritanceType.JOINED)
public class Officer {

    //public class Officer extends BaseEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "officertype")
    private Integer officerType;

    @Column(name = "officercode")
    private Integer officerCode;

    @Column(name = "date_prinyat")
    private Instant datePrinyat;

    @Column(name = "date_uvolen")
    private Instant dateUvolen;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private Status status ;

    @OneToMany(mappedBy = "officer")
    private Set<Anketa> anketaId = new HashSet<>();

    @OneToMany(mappedBy = "officer")
    private Set<Auditor> auditorId = new HashSet<>();

    @OneToMany(mappedBy = "officer")
    private Set<Client> clientId = new HashSet<>();

    @OneToMany(mappedBy = "officer")
    private Set<Contract> contractId = new HashSet<>();

    @OneToMany(mappedBy = "officer")
    private Set<Graphik> graphikId = new HashSet<>();

    @OneToMany(mappedBy = "officer")
    private Set<Graphik> graphikIdInspector = new HashSet<>();

    @OneToMany(mappedBy = "officer")
    private Set<GraphikAuditor> graphikAuditorId = new HashSet<>();

    @OneToMany(mappedBy = "officer")
    private Set<Likvidaciya> likvidaciyaId = new HashSet<>();

    @OneToMany(mappedBy = "officer")
    private Set<Person> personId = new HashSet<>();

//    @OneToMany(mappedBy = "officer")
//    private Set<Service> serviceId = new HashSet<>();

    public Officer(String firstName, String lastName, String middleName, Integer officerType, Integer officerCode, Instant datePrinyat, Instant dateUvolen, Status status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.officerType = officerType;
        this.officerCode = officerCode;
        this.datePrinyat = datePrinyat;
        this.dateUvolen = dateUvolen;
        this.status = status;
    }
}

