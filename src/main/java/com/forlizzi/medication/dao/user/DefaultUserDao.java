package com.forlizzi.medication.dao.user;

import com.forlizzi.medication.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DefaultUserDao implements UserDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public int createUser(int userPK, String pseudoName, int age, String dateOfEval, String dateOfDischarge,
                          String medDxIcd, String txDxIcd) {
        SqlParams params = generateInsertSql(userPK, pseudoName, age, dateOfEval, dateOfDischarge, medDxIcd, txDxIcd);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        return jdbcTemplate.update(params.sql, params.source, keyHolder);
    }

    private SqlParams generateInsertSql(int userPK, String pseudoName, int age, String dateOfEval, String dateOfDischarge, String medDxIcd, String txDxIcd) {
        // @formatter:off
        String sql = ""
                + "INSERT INTO users ("
                + "user_pk, pseudo_name, age, date_of_eval, date_of_discharge, med_dx_icd, tx_dx_icd "
                + ") VALUES ("
                + ":user_pk, :pseudo_name, :age, :date_of_eval, :date_of_discharge, :med_dx_icd, :tx_dx_icd"
                + ")";
        // @formatter:on
        SqlParams params = new SqlParams();
        params.sql = sql;
        params.source.addValue("user_pk", userPK);
        params.source.addValue("pseudo_name", pseudoName);
        params.source.addValue("age", age);
        params.source.addValue("date_of_eval", dateOfEval);
        params.source.addValue("date_of_discharge", dateOfDischarge);
        params.source.addValue("med_dx_icd", medDxIcd);
        params.source.addValue("tx_dx_icd", txDxIcd);
        return params;
    }

    @Override
    public List<User> getUsers(int userPK) {
        // formatter:off
        String sql = ""
                + "SELECT * "
                + "FROM users "
                + "WHERE user_pk = :user_pk";
        Map<String, Object> params = new HashMap<>();
        params.put("user_pk", userPK);
        return jdbcTemplate.query(sql, params, (rs, rowNum) -> {
                // @formatter:off
                return User.builder()
                    .userPK(rs.getInt("user_pk"))
                    .pseudoName(rs.getString("pseudo_name"))
                    .age(rs.getInt("age"))
                    .dateOfEval(rs.getString("date_of_eval"))
                    .dateOfDischarge(rs.getString("date_of_discharge"))
                    .medDxIcd(rs.getString("med_dx_icd"))
                    .txDxIcd(rs.getString("tx_dx_icd"))
                    .build();
                // formatter:on
            });
    }

    @Override
    public void updateUser(String newPseudoName, int userPK) {
        SqlParams params = generateUpdateSql(newPseudoName, userPK);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(params.sql, params.source, keyHolder);
    }

    private SqlParams generateUpdateSql(String newPseudoName, int userPK) {
        //@formatter:off
        String sql = ""
                + ""
                + "UPDATE users "
                + "SET pseudo_name = :new_pseudo_name "
                + "WHERE user_pk = :user_pk";
        //@formatter:on
        SqlParams params = new SqlParams();
        params.sql = sql;
        params.source.addValue("new_pseudo_name", newPseudoName);
        params.source.addValue("user_pk", userPK);
        return params;
    }

    @Override
    public void deleteUser(int userPK) {
        //@formatter:off
        String sql = ""
                + "DELETE FROM users "
                + "WHERE user_pk = :user_pk";
        // @formatter:on
        Map<String, Object> params = new HashMap<>();
        params.put("user_pk", userPK);
        jdbcTemplate.update(sql, params);
    }

    class SqlParams {
        String sql;
        MapSqlParameterSource source = new MapSqlParameterSource();
    }

}