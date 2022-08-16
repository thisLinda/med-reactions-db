package com.forlizzi.medication.dao.user;

import com.forlizzi.medication.entity.user.Medication;
import com.forlizzi.medication.entity.user.User;
import com.forlizzi.medication.entity.user.UserMedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Component
public class DefaultUserMedListDao implements UserMedListDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public UserMedList createUserMedList(User user, Medication medication) {
    SqlParams params = generateInsertSql(user, medication);
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    int userMedsListPK = Objects.requireNonNull(keyHolder.getKey()).intValue();
    // @formatter:off
    return UserMedList.builder()
            .pseudoName(user)
            .brandName(medication)
            .build();
    // @formatter:on
  }

  @Override
  public Optional<User> fetchUserByPseudoName(String pseudoName) {
    // @formatter:off
    String sql = ""
            + "SELECT * "
            + "FROM users "
            + "WHERE pseudo_name = :pseudo_name";
    // @formatter:on
    Map<String, Object> params = new HashMap<>();
    params.put("pseudo_name", pseudoName);

    return Optional.ofNullable(
            jdbcTemplate.query(sql, params, new UserResultSetExtractor()));
  }

  @Override
  public Optional<Medication> fetchMedicationByBrandName(String brandName) {
    // @formatter:off
    String sql = ""
            + "SELECT * "
            + "FROM medications "
            + "WHERE brand_name = :brand_name";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("brand_name", brandName);

    return Optional.ofNullable(
            jdbcTemplate.query(sql, params, new BrandNameResultSetExtractor()));
  }

  class UserResultSetExtractor implements ResultSetExtractor<User> {
    @Override
    public User extractData(ResultSet rs) throws SQLException {
      rs.next();
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
      // @formatter:on
    }
  }

  class BrandNameResultSetExtractor implements ResultSetExtractor<Medication> {
    @Override
    public Medication extractData(ResultSet rs) throws SQLException {
      rs.next();
      // @formatter:off
      return Medication.builder()
              .medPK(rs.getInt("med_pk"))
              .brandName(rs.getString("brand_name"))
              .hasReaction(rs.getBoolean("has_reaction"))
              .build();
      // @formatter:on
    }
  }

  private SqlParams generateInsertSql(User user, Medication medication) {
    // @formatter:off
    String sql = ""
            +"INSERT INTO user_meds_list ("
            + "user_fk , med_fk"
            + ") VALUES ("
            + ":user_fk, :med_fk"
            + ")";
    // @formatter:on
    SqlParams params = new SqlParams();
    params.sql = sql;
    params.source.addValue("user_fk", user.getUserPK());
    params.source.addValue("med_fk", medication.getMedPK());
    return params;
  }

  @Override
  public Optional<User> fetchUser(int userPK) {
    // @formatter:off
    String sql = ""
            + "SELECT * "
            + "FROM users "
            + "WHERE user_pk = :user_pk";
    // @formatter:on
    Map<String, Object> params = new HashMap<>();
    params.put("user_pk", userPK);

    return Optional.ofNullable(
            jdbcTemplate.query(sql, params, new UserResultSetExtractor()));
  }

  @Override
  public Optional<Medication> fetchMedication(int medPK) {
    // @formatter:off
    String sql = ""
            + "SELECT * "
            + "FROM medications "
            + "WHERE med_pk = :med_pk";
    // @formatter:on

    Map<String, Object> params = new HashMap<>();
    params.put("med_fk", medPK);

    return Optional.ofNullable(
            jdbcTemplate.query(sql, params, new BrandNameResultSetExtractor()));
  }


  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }

}