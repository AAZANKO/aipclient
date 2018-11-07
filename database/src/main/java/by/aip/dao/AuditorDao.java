package by.aip.dao;

import by.aip.dao.model.Auditor;
import by.aip.dao.model.Officer;
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
public class AuditorDao {

    private static final AuditorDao INSTANCE = new AuditorDao();

    public Auditor getAuditorDao() {
        return Auditor.builder()
                .id(1L)
                .firstName("Ivanonv")
                .lastName("Ivan")
                .middleName("Ivanovich")
                .auditorType(1)
                .auditorCode(1)
                .datePrinyat(Instant.now())
                .dateUvolen(Instant.now())
                .status(Status.OPEN)
                .officer(Officer.builder().id(1L).build())
                .build();
    }

    public static AuditorDao getInstance() {
        return INSTANCE;
    }
}
