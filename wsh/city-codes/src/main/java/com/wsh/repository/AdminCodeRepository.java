package com.wsh.repository;

import com.wsh.domain.AdminCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminCodeRepository extends JpaRepository<AdminCode, Long> {
    @Query("SELECT ac FROM AdminCode ac WHERE ac.code =: adminCode")
    AdminCode findAdminCode(final String adminCode);
}
