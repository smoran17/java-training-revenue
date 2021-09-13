package com.accenture.tagtrainingspring.screening;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class ScreeningDaoImpl implements ScreeningDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Screening get(int patientId) {
        String sql = "SELECT * FROM SCREENING_RESULTS WHERE ID = ?";
        try {
            return (jdbcTemplate.queryForObject(sql, new Object[]{patientId}, new ScreeningRowMapper()));
        } catch(EmptyResultDataAccessException e) {
            System.out.println("No record found");
            log.info("No record found");
        }
        return null;
    }

    @Override
    public List<Screening> get() {
        String sql = "SELECT * FROM SCREENING_RESULTS";
        return (jdbcTemplate.query(sql, new ScreeningRowMapper()));
    }

    @Override
    public void save(Screening screening) {
        String sql = "INSERT INTO SCREENING_RESULTS (ID, DIAGNOSIS, SYMMETRY_MEAN, GROUP_ID) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, screening.getId(), screening.getDiagnosis(), screening.getSymmetryMean(), screening.getGroupId());
    }
}
