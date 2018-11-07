package by.aip.dao.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
@Entity
@Table(name = "anketa", schema = "opday")
public class Anketa {

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

    @Column(name = "anketatype")
    private Integer anketaType;

    @Column(name = "anketacode")
    private Integer anketaCode;

    @Column(name = "dateopen")
    private Instant dateOpen;

    @Column(name = "dateclose")
    private Instant dateClose;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "officer_id")
    private Officer officer;
//    @Column(name = "officer_id")
//    private Long officerId;

    public Anketa(Contract contract, Client client, Integer anketaType, Integer anketaCode, Instant dateOpen, Instant dateClose, Status status, Officer officer) {
        this.contract = contract;
        this.client = client;
        this.anketaType = anketaType;
        this.anketaCode = anketaCode;
        this.dateOpen = dateOpen;
        this.dateClose = dateClose;
        this.status = status;
        this.officer = officer;
    }
}
