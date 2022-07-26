package com.perpus.repo;

import org.springframework.data.repository.CrudRepository;

import com.perpus.entity.Buku;

public interface BukuRepo extends CrudRepository<Buku, Long> {
    
}
