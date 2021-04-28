package com.study.spring.elegantbrothers.order.domain.entity;

import com.study.spring.elegantbrothers.common.domain.embed.Log;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 생성자
@Table(name = "REFUND", uniqueConstraints = {@UniqueConstraint(name="PK_REFUND" , columnNames = {"GOODS_REFND_ID"})})
public class Refund {

    @Id
    @GeneratedValue
    @Column(name = "GOODS_REFND_ID", length = 20 )
    private long goodsRefndId;              // 상품 환불 ID

    @Column(name = "GOODS_ID", length = 20, nullable = false )
    private long goodsId;                   // 상품 ID

    @Column(name = "ORDER_ID", length = 20, nullable = false )
    private long orderId;                   // 주문 ID

    @Column(name = "GOODS_ORDER_REPR", length = 7, nullable = false )
    private int goodsOrderRepr;             // 상품 주문 개수

    @Embedded
    private Log log;

    @Builder
    public Refund(long goodsRefndId, long goodsId, long orderId, int goodsOrderRepr, Log log) {
        Assert.hasText(String.valueOf(goodsRefndId), "goodsRefndId must not be empty");
        Assert.hasText(String.valueOf(goodsId), "goodsId must not be empty");
        Assert.hasText(String.valueOf(orderId), "orderId must not be empty");
        this.goodsRefndId = goodsRefndId;
        this.goodsId = goodsId;
        this.orderId = orderId;
        this.goodsOrderRepr = goodsOrderRepr;
        this.log = log;
    }
}
