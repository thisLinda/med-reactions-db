package com.forlizzi.medication.controller.reaction;

import com.forlizzi.medication.entity.reaction.Reaction;
import com.forlizzi.medication.entity.reaction.ReactionSeverity;
import com.forlizzi.medication.service.reaction.ReactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class DefaultReactionController implements ReactionController {

    @Autowired
    private ReactionService reactionService;

    @Override
    public List<Reaction> fetchReactions(ReactionSeverity reactionSeverity, String reaction) {
        log.debug("reactionSeverity={}, reaction={}", reactionSeverity, reaction);
        return reactionService.fetchReactions(reactionSeverity, reaction);
    }

}