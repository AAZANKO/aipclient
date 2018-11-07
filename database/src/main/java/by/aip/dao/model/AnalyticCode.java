package by.aip.dao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
// @AllArgsConstructor
@Builder
@Entity
@Table(name = "analyticcode", schema = "opday")
public class AnalyticCode {

//    @id
//    private AnalyticCode analyticCode;
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EmbeddedId
    private AnalyticCodeDetail analyticCodeDetail;

//    @Column(name = "analytic_type")
//    private Long analyticType;
//
//    @Column(name = "analytic_code")
//    private Long analyticCode;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "name")
    private String name;

    @Column(name = "comment")
    private String comment;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private Status status;

    public AnalyticCode(AnalyticCodeDetail analyticCodeDetail, String shortName, String name, String comment, Status status) {
        this.analyticCodeDetail = analyticCodeDetail;
        this.shortName = shortName;
        this.name = name;
        this.comment = comment;
        this.status = status;
    }
}
