package com.tourism.tourismtechnology.mapper;

import com.tourism.tourismtechnology.entity.Point;
import com.tourism.tourismtechnology.model.PointDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PointMapper {

    PointDto toDto(Point point);

    Point toEntity(PointDto pointDto);
}