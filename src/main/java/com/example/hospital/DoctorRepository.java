package com.example.hospital;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hospital.entity.DoctorEntity;



public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {

}
