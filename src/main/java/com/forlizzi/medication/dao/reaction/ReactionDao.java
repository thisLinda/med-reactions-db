package com.forlizzi.medication.dao.reaction;

import com.forlizzi.medication.entity.reaction.Reaction;
import com.forlizzi.medication.entity.reaction.ReactionSeverity;
import java.util.List;

public interface ReactionDao {

    List<Reaction> fetchReactions(ReactionSeverity reactionSeverity, String reaction);

}