package com.tourism.tourismtechnology.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PointDto {

    private Long id;
    private int points;
    private Date date;
}
