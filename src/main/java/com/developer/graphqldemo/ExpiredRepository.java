package com.developer.graphqldemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface ExpiredRepository extends JpaRepository<Expired, UUID> {
}