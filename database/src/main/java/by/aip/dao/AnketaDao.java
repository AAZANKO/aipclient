package by.aip.dao;

import by.aip.dao.model.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
// @AllArgsConstructor
@Builder
public class AnketaDao {

    private static final AnketaDao INSTANCE = new AnketaDao();

    public Anketa getAnketaDao() {
        return Anketa.builder()
                .id(1L)
                .contract(Contract.builder().id(1L).build())
                .client(Client.builder().id(1L).build())
                .anketaType(3)
                .anketaCode(3)
                .dateOpen(Instant.now())
                .dateClose(Instant.now())
                .status(Status.OPEN)
                .officer(Officer.builder().id(1L).build())
                .build();
    }

    public static AnketaDao getInstance() {
        return INSTANCE;
    }
}
