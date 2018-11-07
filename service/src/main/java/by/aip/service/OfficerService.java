package by.aip.service;

import by.aip.dao.OfficerDao;
import by.aip.dao.model.Officer;
import lombok.*;

import java.util.List;

@Data
//@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class OfficerService {

    private static final OfficerService INSTANCE = new OfficerService();

    public List<Officer> getOfficerService(){
        return OfficerDao.getInstance().getOfficerDao();
    }

    public static OfficerService getInstance(){
        return INSTANCE;
    }
}
