package by.aip.dao;

import by.aip.dao.model.Client;
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
public class ClientDao {

    private static final ClientDao INSTANCE = new ClientDao();

    public Client getClientDao() {
        return Client.builder()
                .id(1L)
                .clientNumber("12-4mc/8")
                .clientNumber("Ivan company")
                .shortName("Ivanovich")
                .analytikTypeId(1)
                .analytikCodeId(1)
                .dateOpen(Instant.now())
                .dateClose(Instant.now())
                .unp(206941123)
                .account("BY23BSBB301212312345010040")
                .legalCity("Minsk")
                .legalStreet("Pobedy")
                .legalHouse("20")
                .territoryCity("Minsk")
                .territoryStreet("Pobedy")
                .territoryHouse("20")
                .designationType(2)
                .designationCode(3)
                .countPerson(2000)
                .status(Status.OPEN)
                .officer(Officer.builder().id(1L).build())
                .build();
    }

    public static ClientDao getInstance() {
        return INSTANCE;
    }


}
