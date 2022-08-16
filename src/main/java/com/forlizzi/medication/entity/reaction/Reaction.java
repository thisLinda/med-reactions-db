package com.forlizzi.medication.entity.reaction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import java.util.Comparator;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reaction implements Comparable<Reaction> {
    private int reactionPK;
    private ReactionSeverity reactionSeverity;
    private String reaction;

    @Override
    public int compareTo(Reaction that) {
        // @formatter:off
        return Comparator
                .comparing(Reaction::getReactionSeverity)
                .thenComparing(Reaction::getReaction)
                .compare(this, that);
        // @formatter:on
    }

    @JsonIgnore
    public int getReactionPK() {
        return reactionPK;
    }

}