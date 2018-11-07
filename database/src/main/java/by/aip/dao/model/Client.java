package by.aip.dao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "client", schema = "opday")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_number")
    private String clientNumber;

    // unique = true - значение поля уникально
    // nullable = false - значение поля не может быть NULL
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "shortname", unique = true, nullable = false)
    private String shortName;

    @Column(name = "analytik_type_id")
    private Integer analytikTypeId;

    @Column(name = "analytik_code_id")
    private Integer analytikCodeId;

    @Column(name = "dateopen")
    private Instant dateOpen;

    @Column(name = "dateclose")
    private Instant dateClose;

    @Column(name = "unp")
    private Integer unp;

    @Column(name = "account")
    private String account;

//    @Column(name = "address")
//    private String address;

//    @Embedded
//    private Addres addres;

    @Column(name = "legal_city")
    private String legalCity;

    @Column(name = "legal_street")
    private String legalStreet;

    @Column(name = "legal_house")
    private String legalHouse;

    @Column(name = "territory_city")
    private String territoryCity;

    @Column(name = "territory_street")
    private String territoryStreet;

    @Column(name = "territory_house")
    private String territoryHouse;

    @Column(name = "designation_type")
    private Integer designationType;

    @Column(name = "designation_code")
    private Integer designationCode;

    @Column(name = "countempl")
    private Integer countPerson;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "officer_id")
    private Officer officer;
//    @Column(name = "officer_id")
//    private Long officerId;

    @OneToMany(mappedBy = "client")
    private Set<Anketa> anketa = new HashSet<>();

    @OneToMany(mappedBy = "client")
    private Set<Contract> contract = new HashSet<>();

    @OneToMany(mappedBy = "client")
    private Set<Graphik> graphik = new HashSet<>();

    @OneToMany(mappedBy = "client")
    private Set<Likvidaciya> likvidaciya = new HashSet<>();

    @OneToMany(mappedBy = "client")
    private Set<Person> person = new HashSet<>();


    public Client(String clientNumber, String name, String shortName, Integer analytikTypeId, Integer analytikCodeId, Instant dateOpen, Instant dateClose, Integer unp, String account, String legalCity, String legalStreet, String legalHouse, String territoryCity, String territoryStreet, String territoryHouse, Integer designationType, Integer designationCode, Integer countPerson, Status status, Officer officerId) {
        this.clientNumber = clientNumber;
        this.name = name;
        this.shortName = shortName;
        this.analytikTypeId = analytikTypeId;
        this.analytikCodeId = analytikCodeId;
        this.dateOpen = dateOpen;
        this.dateClose = dateClose;
        this.unp = unp;
        this.account = account;
        this.legalCity = legalCity;
        this.legalStreet = legalStreet;
        this.legalHouse = legalHouse;
        this.territoryCity = territoryCity;
        this.territoryStreet = territoryStreet;
        this.territoryHouse = territoryHouse;
        this.designationType = designationType;
        this.designationCode = designationCode;
        this.countPerson = countPerson;
        this.status = status;
        this.officer = officerId;
    }

}

