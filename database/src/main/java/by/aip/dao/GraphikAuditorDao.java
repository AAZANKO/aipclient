package by.aip.dao;

import by.aip.dao.model.Auditor;
import by.aip.dao.model.Graphik;
import by.aip.dao.model.GraphikAuditor;
import by.aip.dao.model.Officer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
// @AllArgsConstructor
@Builder
public class GraphikAuditorDao {

    private static final GraphikAuditorDao INSTANCE = new GraphikAuditorDao();

    public GraphikAuditor GraphikAuditorDao() {
        return GraphikAuditor.builder()
                .id(1L)
                .graphik(Graphik.builder().id(1L).build())
                .auditor(Auditor.builder().id(1L).build())
                .date(Instant.now())
                .comment("comment")
                .officer(Officer.builder().id(1L).build())
                .build();
    }

    public static GraphikAuditorDao getInstance() {
        return INSTANCE;
    }

}
