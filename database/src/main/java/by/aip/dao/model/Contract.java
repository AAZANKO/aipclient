package by.aip.dao.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
@Entity
@Table(name = "contract", schema = "opday")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contract_number")
    private String contractNumber;

    @Column(name = "contractdate")
    private Instant contractDate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
//    @Column(name = "client_id")
//    private Long clientId;

    @ManyToOne
    @JoinColumn(name = "services_id")
    private Service service;
//    @Column(name = "services_id")
//    private Long servicesId;

    @ManyToOne
    @JoinColumn(name = "officer_id")
    private Officer officer;
//    @Column(name = "officer_id")
//    private Long officerId;

    @Column(name = "stage")
    private Integer stage;

    @Column(name = "contract_amount")
    private Integer contractAmount;

    @Column(name = "sumstage1")
    private Integer sumstage1;

    @Column(name = "sumstage2")
    private Integer sumstage2;

    @Column(name = "sumstage3")
    private Integer sumstage3;

    @Column(name = "sumstage4")
    private Integer sumstage4;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private Status status;

    @OneToMany(mappedBy = "contract")
    private Set<Anketa> anketaId = new HashSet<>();

    @OneToMany(mappedBy = "contract")
    private Set<Graphik> graphikId = new HashSet<>();


    public Contract(String contractNumber, Instant contractDate, Client client, Service service, Officer officer, Integer stage, Integer contractAmount, Integer sumstage1, Integer sumstage2, Integer sumstage3, Integer sumstage4, Status status) {
        this.contractNumber = contractNumber;
        this.contractDate = contractDate;
        this.client = client;
        this.service = service;
        this.officer = officer;
        this.stage = stage;
        this.contractAmount = contractAmount;
        this.sumstage1 = sumstage1;
        this.sumstage2 = sumstage2;
        this.sumstage3 = sumstage3;
        this.sumstage4 = sumstage4;
        this.status = status;
    }
}