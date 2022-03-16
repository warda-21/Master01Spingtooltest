package com.repositories;


import com.entities.Filiere_Langue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiliereRepository extends JpaRepository<Filiere_Langue, Long> {
}
