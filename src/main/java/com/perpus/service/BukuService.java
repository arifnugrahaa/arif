package com.perpus.service;

import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import com.perpus.repo.BukuRepo;
import com.perpus.entity.Buku;

@Service
@Transactional
public class BukuService {
    

    @Autowired
    private BukuRepo repo;

    public Iterable<Buku> findAll(){
        return repo.findAll();
    }

    public void addBuku(Buku buku){
        repo.save(buku);
    }

    public void deleteById(long id){
        repo.deleteById(id);
    }

    public Optional<Buku> findById(long id){
        return repo.findById(id);
    }

    public void updateBuku(Buku buku){
        repo.save(buku);
    }
}
