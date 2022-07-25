package com.perpus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("")
public class HomeController {
    
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
        return "siswa";
    }

    @GetMapping("tambah/siswa")
    public String tambahSiswa(Model model){
        String todo = "Silahkan Masukkan Data Siswa Pada Form Dibawah Ini";
        model.addAttribute("todo", todo);
        return "tambahSiswa";
    }

}
