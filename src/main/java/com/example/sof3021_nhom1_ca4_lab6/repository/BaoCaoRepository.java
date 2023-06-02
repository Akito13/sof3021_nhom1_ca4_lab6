package com.example.sof3021_nhom1_ca4_lab6.repository;

import com.example.sof3021_nhom1_ca4_lab6.custom.MySerializable;
import com.example.sof3021_nhom1_ca4_lab6.model.BaoCao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BaoCaoRepository extends JpaRepository<BaoCao, Integer> {
    @Query("select new BaoCao(s.maloai.tenloai, sum(s.gia), count(s)) " +
            "from Sach s group by s.maloai order by sum(s.gia) DESC")
    List<BaoCao> getBaoCaoByLoai();
}
