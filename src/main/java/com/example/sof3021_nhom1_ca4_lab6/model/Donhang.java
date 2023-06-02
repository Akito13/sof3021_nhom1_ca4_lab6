package com.example.sof3021_nhom1_ca4_lab6.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Donhang {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MADH")
    private int madh;
    @Basic
    @Column(name = "NGAYXUAT")
    @Temporal(value = TemporalType.DATE)
    private Date ngayxuat;
    @ManyToOne
    @JoinColumn(name = "MAKH", referencedColumnName = "MAKH")
    private User makh;
    @OneToMany(mappedBy = "madh")
    private List<Donhangchitiet> billDetails;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Donhang donhang = (Donhang) o;
        return madh == donhang.madh && Objects.equals(ngayxuat, donhang.ngayxuat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(madh, ngayxuat);
    }
}
