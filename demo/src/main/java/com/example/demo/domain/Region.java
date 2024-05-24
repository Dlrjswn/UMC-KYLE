package com.example.demo.domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Region extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length=10)
    private String name;

    @OneToMany(mappedBy = "region",cascade = CascadeType.ALL)
    @Builder.Default
    private List<Store> storeList = new ArrayList<>();

}
