package com.zegume.springbooth2jpa;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "WSX_DATA")
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_WSX_DATA_ID")
    @SequenceGenerator(name = "SEQ_WSX_DATA_ID", allocationSize = 0)
    @Column(precision = 19, scale = 0)
    private BigDecimal ID;
    @Column(length = 5)
    private String     GIRIS_KULLA_KOD;
    @Column(length = 10)
    private String     GIRIS_PROG_KOD;
    private Date       GIRIS_TAR;
    @Column(length = 10)
    private String     GUNC_KULLA_KOD;
    @Column(length = 10)
    private String     GUNC_PROG_KOD;
    private Date       GUNC_TAR;
    @Column(length = 2)
    private String     KAYIT_DURUM;
    @Column(precision = 4, scale = 0)
    private BigDecimal TIP;
    @Column(precision = 19, scale = 0)
    private BigDecimal RESPONSEID;

    public BigDecimal getID() {
        return ID;
    }

    public void setID(BigDecimal ID) {
        this.ID = ID;
    }

    public String getGIRIS_KULLA_KOD() {
        return GIRIS_KULLA_KOD;
    }

    public void setGIRIS_KULLA_KOD(String GIRIS_KULLA_KOD) {
        this.GIRIS_KULLA_KOD = GIRIS_KULLA_KOD;
    }
}
