package com.cordeiro.springProject.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cordeiro.springProject.domain.Estado;
@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

}
