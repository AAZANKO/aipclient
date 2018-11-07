package by.aip.dao;

import by.aip.dao.model.Client;
import by.aip.dao.model.Officer;
import by.aip.dao.model.Person;
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
public class PersonDao {

    private static final PersonDao INSTANCE = new PersonDao();

    public Person PersonDao() {
        return Person.builder()
                .id(12L)
                .client(Client.builder().id(1L).build())
                .firstName("Ivanov")
                .lastName("Ivan")
                .middleName("Ivanovich")
                .officer(Officer.builder().id(1L).build())
                .comment("comment")
                .status(Status.OPEN)
                .personTypeId(1L)
                .personCodeId(1L)
                .personOpenDate(Instant.now())
                .personCloseDate(Instant.now())
                .build();
    }

    public static PersonDao getInstance() {
        return INSTANCE;
    }
}
