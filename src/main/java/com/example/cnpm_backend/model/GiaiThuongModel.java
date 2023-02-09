package com.example.cnpm_backend.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "giaithuong")
public class GiaiThuongModel implements Serializable {
    private static final int serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tengiai")
    private String tenGiai;

    public GiaiThuongModel() {
        id = 0;
    }

    public GiaiThuongModel(int id, String tenGiai) {
        this.id = id;
        this.tenGiai = tenGiai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenGiai() {
        return tenGiai;
    }

    public void setTenGiai(String tenGiai) {
        this.tenGiai = tenGiai;
    }
}
