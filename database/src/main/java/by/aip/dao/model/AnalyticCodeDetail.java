package by.aip.dao.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Builder
// @Entity
// @Table(name = "analyticcode", schema = "opday")
@Embeddable
public class AnalyticCodeDetail implements Serializable /*extends BaseEntity<Long> implements Serializable*/ {

    @Column(name = "analytic_type")
    private Long analyticType;

    @Column(name = "analytic_code")
    private Long analyticCode;

}
