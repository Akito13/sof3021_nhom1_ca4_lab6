package com.example.sof3021_nhom1_ca4_lab6.repository;

import com.example.sof3021_nhom1_ca4_lab6.model.Sach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface SessionService extends JpaRepository<Sach, String> {
    @Query("select s from Sach s where s.tensach like ?1")
    Page<Sach> findByTensach(String keywords, Pageable pageable);
}
