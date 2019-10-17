package com.sun.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sun.entity.AuditLog;

public interface IAuditLogDao extends JpaRepository<AuditLog, Long> {
	
}
