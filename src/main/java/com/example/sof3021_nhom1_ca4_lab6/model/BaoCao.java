package com.example.sof3021_nhom1_ca4_lab6.model;

import com.example.sof3021_nhom1_ca4_lab6.custom.MySerializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter @Setter
@ToString
@NoArgsConstructor
public class BaoCao implements MySerializable {
    @Id
    private String tenLoai;
    private Double tongGia;
    private Long tongSoLuong;

    public BaoCao(String tenLoai, Double tongGia, Long tongSoLuong) {
        this.tenLoai = tenLoai;
        this.tongGia = tongGia;
        this.tongSoLuong = tongSoLuong;
    }
}
