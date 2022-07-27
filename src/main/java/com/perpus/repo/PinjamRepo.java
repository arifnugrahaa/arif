package com.perpus.repo;

import org.springframework.data.repository.CrudRepository;

import com.perpus.entity.Pinjam;

public interface PinjamRepo extends CrudRepository<Pinjam, Long> {
    
}
