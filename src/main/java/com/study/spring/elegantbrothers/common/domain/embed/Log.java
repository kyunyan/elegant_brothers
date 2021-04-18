package com.study.spring.elegantbrothers.common.domain.embed;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Log {

    @Column(name = "REG_ID")
    private String regId;

    @Column(name = "REG_IP")
    private String regIp;

    @Column(name = "REG_DT")
    private LocalDateTime regDt;

    @Column(name = "UPD_ID")
    private String updId;

    @Column(name = "UPD_IP")
    private String updIp;

    @Column(name = "UPD_DT")
    private LocalDateTime updDt;

    @Builder
    public Log(String regId, String regIp, LocalDateTime regDt) {
        this.regId = regId;
        this.regIp = regIp;
        this.regDt = regDt;
    }

    @Builder
    public Log(String regId, String regIp, LocalDateTime regDt, String updId, String updIp, LocalDateTime updDt) {
        this.regId = regId;
        this.regIp = regIp;
        this.regDt = regDt;
        this.updId = updId;
        this.updIp = updIp;
        this.updDt = updDt;
    }
}
