package com.perpus.repo;

import org.springframework.data.repository.CrudRepository;
import com.perpus.entity.Siswa;
import java.util.List;

public interface SiswaRepo extends CrudRepository<Siswa, Long> {
    
    // List<Siswa> findByNameContains(String keyboard);
}
