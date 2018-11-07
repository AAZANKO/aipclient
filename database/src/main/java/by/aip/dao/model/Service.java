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
@Table(name = "service", schema = "opday")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "shortname")
    private String shortName;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private Status status;

    @Column(name = "service_date_open")
    private Instant serviceDateOpen;

    @Column(name = "service_date_close")
    private Instant serviceDateClose;

    @OneToMany(mappedBy = "service")
    private Set<Contract> contractId = new HashSet<>();

    public Service(String name, String shortName, Status status, Instant serviceDateOpen, Instant serviceDateClose) {
        this.name = name;
        this.shortName = shortName;
        this.status = status;
        this.serviceDateOpen = serviceDateOpen;
        this.serviceDateClose = serviceDateClose;
    }
}
