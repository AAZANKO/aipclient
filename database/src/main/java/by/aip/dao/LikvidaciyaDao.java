package by.aip.dao;

import by.aip.dao.model.Client;
import by.aip.dao.model.Likvidaciya;
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
public class LikvidaciyaDao {

    private static final LikvidaciyaDao INSTANCE = new LikvidaciyaDao();

    public Likvidaciya LikvidaciyaDao() {
        return Likvidaciya.builder()
                .id(1L)
                .number(34L)
                .client(Client.builder().id(1L).build())
                .dateOpen(Instant.now())
                .dateClose(Instant.now())
                .status(Status.OPEN)
                .officer(Officer.builder().id(1L).build())
                .build();
    }

    public static LikvidaciyaDao getInstance() {
        return INSTANCE;
    }

}
