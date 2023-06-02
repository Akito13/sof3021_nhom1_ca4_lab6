package com.example.sof3021_nhom1_ca4_lab6.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MAKH")
    private int makh;
    @Basic
    @Column(name = "TENKH")
    private String tenkh;
    @Basic
    @Column(name = "SDT")
    private String sdt;
    @Basic
    @Column(name = "DIACHI")
    private String diachi;
    @Basic
    @Column(name = "EMAIL")
    private String email;
    @Basic
    @Column(name = "ADMIN")
    private Boolean admin;
    @Basic
    @Column(name = "PASSWORD")
    private String password;
    @OneToMany(mappedBy = "makh")
    private List<Donhang> bills;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return makh == user.makh && Objects.equals(tenkh, user.tenkh) && Objects.equals(sdt, user.sdt) && Objects.equals(diachi, user.diachi) && Objects.equals(email, user.email) && Objects.equals(admin, user.admin) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(makh, tenkh, sdt, diachi, email, admin, password);
    }

}
