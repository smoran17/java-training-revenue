package com.accenture.tagtrainingspring.screening;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScreeningDaoImpl implements ScreeningDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Screening get(int patientId) {
        String sql = "select * from screening_results where id = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{patientId}, new ScreeningRowMapper());
    }

    @Override
    public List<Screening> get() {
        String sql = "select * from screening_results";

        return jdbcTemplate.query(sql, new ScreeningRowMapper());
    }

}
