package tovanthieu.tovanthieu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import tovanthieu.tovanthieu.model.NhanVien;
import tovanthieu.tovanthieu.repository.NhanVienRepository;
import tovanthieu.tovanthieu.repository.PhongBanRepository;
@Controller
public class NhanSuController {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Autowired
    private PhongBanRepository phongBanRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("nhanViens", nhanVienRepository.findAll());
        model.addAttribute("phongBans", phongBanRepository.findAll());
        return "index";
    }

    @GetMapping("/nhanvien/add")
    public String addNhanVien(Model model) {
        model.addAttribute("nhanVien", new NhanVien());
        model.addAttribute("phongBans", phongBanRepository.findAll());
        return "add-nhanvien";
    }

    @PostMapping("/nhanvien/save")
    public String saveNhanVien(@ModelAttribute("nhanVien") NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
        return "redirect:/";
    }

    @GetMapping("/nhanvien/edit/{maNV}")
    public String editNhanVien(@PathVariable("maNV") String maNV, Model model) {
        NhanVien nhanVien = nhanVienRepository.findById(maNV)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Ma_NV: " + maNV));
        model.addAttribute("nhanVien", nhanVien);
        model.addAttribute("phongBans", phongBanRepository.findAll());
        return "edit-nhanvien";
    }

    @PostMapping("/nhanvien/update/{maNV}")
    public String updateNhanVien(@PathVariable("maNV") String maNV, @ModelAttribute("nhanVien") NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
        return "redirect:/";
    }

    @GetMapping("/nhanvien/delete/{maNV}")
    public String deleteNhanVien(@PathVariable("maNV") String maNV) {
        NhanVien nhanVien = nhanVienRepository.findById(maNV)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Ma_NV: " + maNV));
        nhanVienRepository.delete(nhanVien);
        return "redirect:/";
    }
}