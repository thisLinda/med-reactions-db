package com.forlizzi.medication.service.reaction;

import com.forlizzi.medication.dao.reaction.ReactionDao;
import com.forlizzi.medication.entity.reaction.Reaction;
import com.forlizzi.medication.entity.reaction.ReactionSeverity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class DefaultReactionService implements ReactionService {

    @Autowired
    private ReactionDao reactionDao;

    @Transactional(readOnly = true)
    @Override
    public List<Reaction> fetchReactions(ReactionSeverity reactionSeverity, String reaction) {
        log.info("The fetchReaction method was called with severity={} and reaction={}", reactionSeverity, reaction);
        
        List<Reaction> reactions = reactionDao.fetchReactions(reactionSeverity, reaction);

        if(reactions.isEmpty()) {
            String msg = String.format("No reactions found with severity=%s and reaction=%s", reactionSeverity,
                    reaction);

            throw new NoSuchElementException(msg);
        }
        Collections.sort(reactions);
        return reactions;
    }

}