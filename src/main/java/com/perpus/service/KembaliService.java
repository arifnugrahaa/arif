package com.perpus.service;

import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import com.perpus.repo.KembaliRepo;
import com.perpus.entity.Kembali;

@Service
@Transactional
public class KembaliService {
    
    @Autowired
    private KembaliRepo repo;

    public Iterable<Kembali> findAll(){
        return repo.findAll();
    }

    public void addKembali(Kembali kembali){
        repo.save(kembali);
    }

    public void deleteById(long id){
        repo.deleteById(id);
    }

    public Optional<Kembali> findById(long id){
        return repo.findById(id);
    }

    public void updateKembali(Kembali kembali){
        repo.save(kembali);
    }
}
