package com.study.spring.elegantbrothers.product.domain.entity;

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
@Table(name = "COMMENTS", uniqueConstraints = {@UniqueConstraint(name="PK_COMMENTS" , columnNames = {"GOODS_COMMENT_ID"})})
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GOODS_COMMENT_ID", length = 20)
    private long goodsCommentsId;           // 상품 댓글 아이디

    @Column(name = "GOODS_COMMENT_SJ_NM", length = 100)
    private String goodsCommentsSjNm;       // 상품 댓글 제목명

    @Column(name = "GOODS_COMMENT_CN", length = 400)
    private String goodsCommentCn;          // 상품 댓글 내용

    @Column(name = "GOODS_COMMENT_DEPTH_CASES", length = 4)
    private int goodsCommentDepthCases;     // 상품댓글 DEPTH 건수

    @Column(name = "GOODS_COMMENT_LIKE", length = 10)
    private int goodsCommentLike;        // 상품 댓글 좋아요

    @Column(name = "GOODS_COMMENT_CSTMR_ID", length = 20, nullable = false)
    private String goodsCommentCstmrId;     // 상품 댓글 ID

    @Embedded
    private Log log;

    @Builder
    public Comments(String goodsCommentsSjNm, String goodsCommentCn, int goodsCommentDepthCases, int goodsCommentLike, String goodsCommentCstmrId, Log log) {
        this.goodsCommentsSjNm = goodsCommentsSjNm;
        this.goodsCommentCn = goodsCommentCn;
        this.goodsCommentDepthCases = goodsCommentDepthCases;
        this.goodsCommentLike = goodsCommentLike;
        this.goodsCommentCstmrId = goodsCommentCstmrId;
        this.log = log;
    }
}
