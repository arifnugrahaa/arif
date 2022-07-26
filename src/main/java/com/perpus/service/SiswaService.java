package com.perpus.service;

import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import com.perpus.repo.SiswaRepo;
import com.perpus.entity.Siswa;

@Service
@Transactional
public class SiswaService {
    
    @Autowired
    private SiswaRepo repo;

    public Iterable<Siswa> findAll(){
        return repo.findAll();
    }

    public void addSiswa(Siswa siswa){
        repo.save(siswa);
    }

    public void deleteById(long id){
        repo.deleteById(id);
    }

    public Optional<Siswa> findById(long id){
        return repo.findById(id);
    }

    public void updateSiswa(Siswa siswa){
        repo.save(siswa);
    }

    // public List<Siswa> findByName(String keyword){
    //     return repo.findByNameContains(keyword);
    // }
}
