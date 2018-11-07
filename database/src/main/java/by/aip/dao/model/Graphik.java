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
@Table(name = "graphik", schema = "opday")
public class Graphik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;
//    @Column(name = "contract_id")
//    private Long contractId;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
//    @Column(name = "client_id")
//    private Long clientId;

    @Column(name = "datebegin")
    private Instant dateBegin;

    @Column(name = "dateend")
    private Instant dateEnd;

    @Column(name = "satage")
    private Integer satage;

    @OneToOne
    @JoinColumn(name = "inspector_id")
    private Auditor inspector;
//    @Column(name = "inspector_id")
//    private Long inspectorId;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "officer_id")
    private Officer officer;
//    @Column(name = "officer_id")
//    private Long officerId;

    @OneToMany(mappedBy = "graphik")
    private Set<GraphikAuditor> graphikAuditorId = new HashSet<>();


    public Graphik(Contract contract, Client client, Instant dateBegin, Instant dateEnd, Integer satage, Auditor inspector, Status status, Officer officer) {
        this.contract = contract;
        this.client = client;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.satage = satage;
        this.inspector = inspector;
        this.status = status;
        this.officer = officer;
    }
}
