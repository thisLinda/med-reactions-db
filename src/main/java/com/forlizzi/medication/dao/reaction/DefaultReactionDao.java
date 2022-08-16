package com.forlizzi.medication.dao.reaction;

import com.forlizzi.medication.entity.reaction.Reaction;
import com.forlizzi.medication.entity.reaction.ReactionSeverity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class DefaultReactionDao implements ReactionDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Reaction> fetchReactions(ReactionSeverity reactionSeverity, String reaction) {
        log.debug("DAO: reactionSeverity={}, reaction={}", reactionSeverity, reaction);

        // @formatter:off
        String sql = ""
                + "SELECT * "
                + "FROM adverse_reactions "
                + "WHERE reaction_severity = :reaction_severity AND reaction = :reaction";
        // @formatter:on

        Map<String, Object> params = new HashMap<>();
        params.put("reaction_severity", reactionSeverity.toString());
        params.put("reaction", reaction);

        return jdbcTemplate.query(sql, params, (rs, rowNum) -> {
        // @formatter:off
        return Reaction.builder()
                .reactionSeverity(ReactionSeverity.valueOf(rs.getString("reaction_severity")))
                .reaction(rs.getString("reaction"))
                .build();
        // @formatter:on
        });
    }

}