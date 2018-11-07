package by.aip.dao.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
// @Builder // наследуется от Officer
@Entity
@Table(name = "director", schema = "opday")
@PrimaryKeyJoinColumn(name = "officer_id")
public class Director extends Officer {

    @Column(name = "phone")
    private String phone;

    @Column(name = "unp")
    private String unp;

    @Column(name = "address")
    private String address;

    @Column(name = "e_mail")
    private String eMail;
}
