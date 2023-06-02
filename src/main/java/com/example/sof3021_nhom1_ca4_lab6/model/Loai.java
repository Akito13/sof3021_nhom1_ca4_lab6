package com.example.sof3021_nhom1_ca4_lab6.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Entity
@Getter  @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Loai {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MALOAI")
    private int maloai;
    @Basic
    @Column(name = "TENLOAI")
    private String tenloai;
    @OneToMany(mappedBy = "maloai")
    private List<Sach> books;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loai loai = (Loai) o;
        return maloai == loai.maloai && Objects.equals(tenloai, loai.tenloai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maloai, tenloai);
    }
}
