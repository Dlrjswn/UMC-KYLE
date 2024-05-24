package com.example.demo.domain.mapping;


import com.example.demo.domain.BaseEntity;
import com.example.demo.domain.FoodType;
import com.example.demo.domain.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberPrefer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private FoodType foodType;

    public void setMember(Member member) {
        if(this.member != null) member.getMemberPreferList().remove(this);
        this.member = member;
        member.getMemberPreferList().add(this);
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

}
