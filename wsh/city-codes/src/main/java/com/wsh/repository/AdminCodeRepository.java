package com.wsh.repository;

import com.wsh.domain.AdminCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdminCodeRepository extends JpaRepository<AdminCode, Long> {
//    @Query("SELECT ac FROM AdminCode ac WHERE ac.code =: adminCode")
    AdminCode findAdminCodeByCode(final String adminCode);
    @Query("select a.code from AdminCode a")
    List<String> getAdminCodeByCode();
}
