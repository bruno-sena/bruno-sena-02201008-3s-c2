package com.bandtec.continuada02.repositorio;

import com.bandtec.continuada02.dominio.Lutador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LutadorRepository extends JpaRepository<Lutador, Integer> {

    List<Lutador> findAllByVivoFalse();

    Integer countAllByVivoTrue();

    @Query("select  l from Lutador l order by l.forcaGolpe desc ")
    List<Lutador> findOrderByForca();
}