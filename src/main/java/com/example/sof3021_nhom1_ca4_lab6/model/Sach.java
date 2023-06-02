package com.example.sof3021_nhom1_ca4_lab6.model;

import com.example.sof3021_nhom1_ca4_lab6.custom.MySerializable;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Sach {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MASACH")
    private int masach;
    @Basic
    @Column(name = "TENSACH")
    private String tensach;
    @Basic
    @Column(name = "TACGIA")
    private String tacgia;
    @Basic
    @Column(name = "NXB")
    @Temporal(value = TemporalType.DATE)
    private Date nxb;
    @Basic
    @Column(name = "GIA")
    private Double gia;
    @Basic
    @Column(name = "IMG")
    private String img;
    @Basic
    @Column(name = "SOLUONG")
    private Integer soluong;
    @ManyToOne
    @JoinColumn(name = "MALOAI", referencedColumnName = "MALOAI")
    private Loai maloai;
    @OneToMany(mappedBy = "masach")
    private List<Donhangchitiet> billDetails;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sach sach = (Sach) o;
        return masach == sach.masach && Objects.equals(tensach, sach.tensach) && Objects.equals(tacgia, sach.tacgia) && Objects.equals(nxb, sach.nxb) && Objects.equals(gia, sach.gia) && Objects.equals(img, sach.img) && Objects.equals(soluong, sach.soluong);
    }

    @Override
    public int hashCode() {
        return Objects.hash(masach, tensach, tacgia, nxb, gia, img, soluong);
    }
}
