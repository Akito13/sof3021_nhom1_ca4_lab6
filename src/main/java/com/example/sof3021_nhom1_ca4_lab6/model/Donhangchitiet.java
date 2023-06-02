package com.example.sof3021_nhom1_ca4_lab6.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Donhangchitiet {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MADHCT")
    private int madhct;
    @Basic
    @Column(name = "SOLUONG")
    private Integer soluong;
    @Basic
    @Column(name = "TONGTIEN")
    private BigDecimal tongtien;
    @ManyToOne
    @JoinColumn(name = "MADH", referencedColumnName = "MADH")
    private Donhang madh;
    @ManyToOne
    @JoinColumn(name = "MASACH", referencedColumnName = "MASACH")
    private Sach masach;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Donhangchitiet that = (Donhangchitiet) o;
        return madhct == that.madhct && Objects.equals(soluong, that.soluong) && Objects.equals(tongtien, that.tongtien);
    }

    @Override
    public int hashCode() {
        return Objects.hash(madhct, soluong, tongtien);
    }

}
