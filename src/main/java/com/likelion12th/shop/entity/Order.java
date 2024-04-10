package com.likelion12th.shop.entity;

import com.likelion12th.shop.constant.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="orders")
@Getter
@Setter
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime OrderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus OrderStatus;

    private LocalDateTime createdBy;
    private LocalDateTime modifiedBy;

    // 주문 회원
    @ManyToOne
    @JoinColumn(name = "member_id") // member_id라는 컬럼으로 저 member랑 조인을 하겠다.
    private Member member;
}
