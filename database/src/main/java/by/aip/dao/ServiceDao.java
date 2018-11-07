package by.aip.dao;

import by.aip.dao.model.Service;
import by.aip.dao.model.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
// @AllArgsConstructor
@Builder
public class ServiceDao {

    private static final ServiceDao INSTANCE = new ServiceDao();

    public Service ServiceDao() {
        return Service.builder()
                .id(1L)
                .name("service")
                .shortName("service")
                .status(Status.OPEN)
                .serviceDateOpen(Instant.now())
                .serviceDateClose(Instant.now())
                .build();
    }
    public static ServiceDao getInstance() {
        return INSTANCE;
    }
}
