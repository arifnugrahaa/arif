package com.perpus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.perpus.entity.Siswa;
import com.perpus.service.SiswaService;
import com.perpus.entity.Buku;
import com.perpus.service.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("")
public class HomeController {
    

    @Autowired
    private SiswaService siswaService;

    @Autowired
    private BukuService bukuService;

    @GetMapping
    public String welcome(Model model){
        String pesan = "Selamat Datang Di Aplikasi Sistem Informasi Perpustakaan";
        model.addAttribute("pesan", pesan);
        return "index";
    }

    @GetMapping("/siswa")
    public String siswa(Model model){
        String todo = "Data Di Bawah Ini Adalah Data Semua Siswa !!!";
        model.addAttribute("todo", todo);
        model.addAttribute("siswa", siswaService.findAll());
        return "siswa";
    }

    @GetMapping("tambah/siswa")
    public String tambahSiswa(Model model){
        String todo = "Silahkan Masukkan Data Siswa Pada Form Dibawah Ini";
        model.addAttribute("todo", todo);
        model.addAttribute("siswa", new Siswa());
        return "tambahSiswa";
    }

    @PostMapping("/save/siswa")
    public String saveSiswa(Siswa siswa, Model model){
        siswaService.addSiswa(siswa);
        return "redirect:/siswa";
    }

    @GetMapping("/delete/siswa/{id}")
    public String deleteSiswa(@PathVariable("id") Long id){
        //service untuk hapus
        siswaService.deleteById(id);
        return "redirect:/siswa";
    }

    @GetMapping("/edit/siswa/{id}")
    public String editSiswa(@PathVariable("id") Long id, Model model){
        model.addAttribute("siswa", siswaService.findById(id));
        return "editSiswa";
    }

    @PostMapping("/update/siswa")
    public String updateSiswa(Siswa siswa, Model model){
        siswaService.updateSiswa(siswa);
        return "redirect:/siswa";
    }

    @GetMapping("/buku")
    public String buku(Model model){
        String todo = "Data Dibawah Ini Adalah Data Semua Buku !!!";
        model.addAttribute("todo", todo);
        model.addAttribute("buku", bukuService.findAll());
        return "buku";
    }

    @GetMapping("/tambah/buku")
    public String tambahBuku(Model model){
        String todo = "Silahkan Masukkan Data Buku Pada Form Dibawah Ini !!";
        model.addAttribute("todo", todo);
        model.addAttribute("buku", new Buku());
        return "tambahBuku";
    }

    @PostMapping("/save/buku")
    public String saveBuku(Buku buku, Model model){
        bukuService.addBuku(buku);
        return "redirect:/buku";
    }

    @GetMapping("/delete/buku/{id}")
    public String deleteBuku(@PathVariable("id") Long id){
        //service untuk hapus
        bukuService.deleteById(id);
        return "redirect:/buku";
    }

    @GetMapping("/edit/buku/{id}")
    public String editBuku(@PathVariable("id") Long id, Model model){
        model.addAttribute("buku", bukuService.findById(id));
        return "editBuku";
    }

    @PostMapping("/update/buku")
    public String updateBuku(Buku buku, Model model){
        bukuService.updateBuku(buku);
        return "redirect:/buku";
    }

}
