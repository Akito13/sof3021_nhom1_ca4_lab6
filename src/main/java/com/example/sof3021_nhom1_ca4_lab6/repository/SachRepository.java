package com.example.sof3021_nhom1_ca4_lab6.repository;

import com.example.sof3021_nhom1_ca4_lab6.model.Sach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SachRepository extends JpaRepository<Sach, Integer> {
    @Query("select s from Sach s where s.gia between ?1 and ?2 order by s.gia")
    List<Sach> findByGia(double giaMin,double giaMax);
}