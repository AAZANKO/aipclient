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
@Table(name = "manager", schema = "opday")
@PrimaryKeyJoinColumn(name = "officer_id")
public class Manager extends Officer {

    @Column(name = "phone")
    private String phone;

    @Column(name = "pass")
    private String pass;

    @Column(name = "address")
    private String address;

    @Column(name = "e_mail")
    private String eMail;

    @Column(name = "commment")
    private String commment;
}
