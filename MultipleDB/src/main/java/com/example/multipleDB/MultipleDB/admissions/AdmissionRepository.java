package com.example.multipleDB.MultipleDB.admissions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AdmissionRepository extends JpaRepository<Admission,Integer> {

}
