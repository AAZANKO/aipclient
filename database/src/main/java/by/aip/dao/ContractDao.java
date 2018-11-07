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
public class ContractDao {

    private static final ContractDao INSTANCE = new ContractDao();

    public Contract getContractDao() {
        return Contract.builder()
                .contractNumber("234234 - 4 / 234")
                .contractDate(Instant.now())
                .client(Client.builder().id(1L).build())
                .service(Service.builder().id(1L).build())
                .officer(Officer.builder().id(1L).build())
                .stage(4)
                .contractAmount(5000)
                .sumstage1(2000)
                .sumstage2(1000)
                .sumstage3(1000)
                .sumstage4(1000)
                .status(Status.OPEN)
                .build();
    }

    public static ContractDao getInstance() {
        return INSTANCE;
    }
}
