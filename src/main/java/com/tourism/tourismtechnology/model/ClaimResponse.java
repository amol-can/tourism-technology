package com.tourism.tourismtechnology.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClaimResponse {

    private String claimMessage;
    private boolean isClaimed;
}
