package com.songpapeople.hashtagmap.place.domain.model;

import com.songpapeople.hashtagmap.config.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "KAKAO_ID", name = "UK_KAKAO_PLACE"))
@AttributeOverride(name = "id", column = @Column(name = "PLACE_ID"))
@Entity
public class Place extends BaseEntity {
    @Column(name = "KAKAO_ID")
    private String kakaoId;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Embedded
    private Location location;

    private String placeName;
    private String placeUrl;

    @Builder
    public Place(String kakaoId, Category category, Location location, String placeName, String placeUrl) {
        this.kakaoId = kakaoId;
        this.category = category;
        this.location = location;
        this.placeName = placeName;
        this.placeUrl = placeUrl;
    }
}
