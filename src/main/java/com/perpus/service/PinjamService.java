package com.perpus.service;

import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import com.perpus.repo.PinjamRepo;
import com.perpus.entity.Pinjam;

@Service
@Transactional
public class PinjamService {
    

    @Autowired
    private PinjamRepo repo;

    public Iterable<Pinjam> findAll(){
        return repo.findAll();
    }

    public void addPinjam(Pinjam pinjam){
        repo.save(pinjam);
    }

    public void deleteById(long id){
        repo.deleteById(id);
    }

    public Optional<Pinjam> findById(long id){
        return repo.findById(id);
    }

    public void updatePinjam(Pinjam pinjam){
        repo.save(pinjam);
    }
}
