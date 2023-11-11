package com.tourism.tourismtechnology.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RewardRequest {

    private String title;
    private Integer points;
    public boolean disabled;

}
