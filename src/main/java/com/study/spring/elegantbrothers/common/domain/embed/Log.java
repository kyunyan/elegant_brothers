package com.study.spring.elegantbrothers.common.domain.embed;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    @PrePersist
    public void prePersist(){
        LocalDateTime now = LocalDateTime.now();
        regDt = now;

    }

    @PreUpdate
    public void preUpdate(){
        LocalDateTime now = LocalDateTime.now();

        updDt = now;
    }

    @PreRemove
    public void preRemove(){
        LocalDateTime now = LocalDateTime.now();

        updDt = now;
    }

    @Builder
    public Log(String regId, String regIp) {
        this.regId = regId;
        this.regIp = regIp;
    }

    @Builder
    public Log(String regId, String regIp, String updId, String updIp) {
        this.regId = regId;
        this.regIp = regIp;
        this.updId = updId;
        this.updIp = updIp;
    }
}
