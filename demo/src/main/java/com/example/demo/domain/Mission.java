package com.example.demo.domain;

import com.example.demo.domain.mapping.MemberMission;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length=255)
    private String content;

    private Integer reward;

    private LocalDate deadline;

@OneToMany(mappedBy = "mission",cascade = CascadeType.ALL)
@Builder.Default
private List<MemberMission> memberMissionList= new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="store_id")
    private Store store;

    public void setStore(Store store) {
        if(this.store != null){
            this.store.setMission(null);
        }
        this.store = store;
        store.setMission(this);
    }
}
