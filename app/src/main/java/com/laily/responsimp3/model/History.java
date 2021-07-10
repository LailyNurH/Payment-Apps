package com.laily.responsimp3.model;

import java.io.Serializable;

public class History implements Serializable {
    private Integer id;
    private String namapembayaran;
    private String tanggal;
    private String metodepembayaran;
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamapembayaran() {
        return namapembayaran;
    }

    public void setNamapembayaran(String namapembayaran) {
        this.namapembayaran = namapembayaran;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getMetodepembayaran() {
        return metodepembayaran;
    }

    public void setMetodepembayaran(String metodepembayaran) {
        this.metodepembayaran = metodepembayaran;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
