package com.example.demo.domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length=10)
    private String name;

    @Column(nullable = false,length=40)
    private String address;

    private Float score;

    @OneToMany(mappedBy = "store",cascade = CascadeType.ALL)
    @Builder.Default
    private List<Review> reviewList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToOne(mappedBy = "store")
    private Mission mission;

    public void joinRegion(Region region){
        if(this.region != null){
            this.region.getStoreList().remove(this);
        }
        this.region = region;
        region.getStoreList().add(this);
    }

    public void setMission(Mission mission){
        this.mission = mission;
    }
}
