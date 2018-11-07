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
@Table(name = "person", schema = "opday")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @ManyToOne
    @JoinColumn(name = "officer_id")
    private Officer officer;
//    @Column(name = "officer_id")
//    private Long officerId;

    @Column(name = "comment")
    private String comment;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private Status status;

    @Column(name = "person_type_id")
    private Long personTypeId;

    @Column(name = "person_code_id")
    private Long personCodeId;

    @Column(name = "person_open_date")
    private Instant personOpenDate;

    @Column(name = "person_close_date")
    private Instant personCloseDate;


    public Person(Client client, String firstName, String lastName, String middleName, Officer officer, String comment, Status status, Long personTypeId, Long personCodeId, Instant personOpenDate, Instant personCloseDate) {
        this.client = client;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.officer = officer;
        this.comment = comment;
        this.status = status;
        this.personTypeId = personTypeId;
        this.personCodeId = personCodeId;
        this.personOpenDate = personOpenDate;
        this.personCloseDate = personCloseDate;
    }

}

