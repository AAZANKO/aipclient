package by.aip.dao;

import by.aip.dao.model.AnalyticCodeDetail;
import by.aip.dao.model.AnalyticCode;
import by.aip.dao.model.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
// @AllArgsConstructor
@Builder
public class AnalyticCodeDao {

    private static final AnalyticCodeDao INSTANCE = new AnalyticCodeDao();

    public AnalyticCode getAnalyticCodeDao() {
        return AnalyticCode.builder()
                .analyticCodeDetail(AnalyticCodeDetail.of(1L, 1L))
                .shortName("det")
                .name("deteil")
                .comment("comment")
                .status(Status.OPEN)
                .build();
    }

    public static AnalyticCodeDao getInstance() {
        return INSTANCE;
    }

}
