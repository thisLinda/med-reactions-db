package com.forlizzi.medication.service.reaction;

import com.forlizzi.medication.entity.reaction.Reaction;
import com.forlizzi.medication.entity.reaction.ReactionSeverity;
import java.util.List;

public interface ReactionService {

    /*
     * @param reactionSeverity
     * @param reaction
     * @return
     */
    List<Reaction> fetchReactions(ReactionSeverity reactionSeverity, String reaction);

}