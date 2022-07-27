package com.perpus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.perpus.entity.Pinjam;
import com.perpus.entity.Kembali;
import com.perpus.service.PinjamService;
import com.perpus.service.BukuService;
import com.perpus.service.SiswaService;
import com.perpus.service.KembaliService;

@Controller
@RequestMapping("")
public class TransaksiController {
    
    @Autowired
    private PinjamService pinjamService;
    
    @Autowired
    private BukuService bukuService;
    
    @Autowired
    private SiswaService siswaService;
    
    @Autowired
    private KembaliService kembaliService;

    @GetMapping("/peminjaman")
    public String pinjam(Model model){
        String todo = "Data Di Bawah Ini Adalah Data Semua Peminjaman Buku !!!";
        model.addAttribute("todo", todo);
        model.addAttribute("peminjaman", pinjamService.findAll());
        return "pinjam";
    }

    @GetMapping("tambah/pinjam")
    public String tambahPinjam(Model model){
        String todo = "Silahkan Masukkan Data Peminjaman Pada Form Dibawah Ini";
        model.addAttribute("todo", todo);
        model.addAttribute("peminjaman", new Pinjam());
        model.addAttribute("siswa", siswaService.findAll());
        model.addAttribute("buku", bukuService.findAll());
        return "tambahPinjam";
    }

    @PostMapping("/save/pinjam")
    public String savePinjam(Pinjam pinjam, Model model){
        pinjamService.addPinjam(pinjam);
        return "redirect:/peminjaman";
    }

    @GetMapping("/pengembalian")
    public String kembali(Model model){
        String todo = "Data Di Bawah Ini Adalah Data Semua Peminjaman Buku !!!";
        model.addAttribute("todo", todo);
        model.addAttribute("peminjaman", pinjamService.findAll());
        return "kembali";
    }

    // @GetMapping("/kembali/buku/{id}")
    // public String editKembali(@PathVariable("id") Long id, Model model){
    //     model.addAttribute("pinjam", pinjamService.findById(id));
    //     return "pengembalian";
    // }

    // @PostMapping("/update/kembali")
    // public String updateKembali(Pinjam pinjam, Model model, Kembali kembali){
    //     kembaliService.addKembali(kembali);
    //     // pinjamService.deleteById(id);
    //     return "redirect:/pengembalian";
    // }

    @GetMapping("/kembali/buku/{id}")
    public String deletePinjam(@PathVariable("id") Long id){
        //service untuk hapus
        pinjamService.deleteById(id);
        return "redirect:/pengembalian";
    }
}
