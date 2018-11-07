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
@Table(name = "likvidaciya", schema = "opday")
public class Likvidaciya {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private Long number;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
//    @Column(name = "client_id")
//    private Long clientId;

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

    public Likvidaciya(Long number, Client client, Instant dateOpen, Instant dateClose, Status status, Officer officer) {
        this.number = number;
        this.client = client;
        this.dateOpen = dateOpen;
        this.dateClose = dateClose;
        this.status = status;
        this.officer = officer;
    }
}
