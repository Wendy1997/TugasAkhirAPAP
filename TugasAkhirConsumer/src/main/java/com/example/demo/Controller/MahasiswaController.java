package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.DAO.MahasiswaDAOImpl;
import com.example.demo.Model.IRS;
import com.example.demo.Model.Kelas;
import com.example.demo.Model.Mahasiswa;
import com.example.demo.RestService.IRSServiceRest;
import com.example.demo.RestService.KelasServiceRest;
import com.example.demo.Service.FakultasService;
import com.example.demo.Service.IRSService;
import com.example.demo.Service.MahasiswaService;

import com.example.demo.Service.KelasService;

@Controller
public class MahasiswaController {
	
	@Autowired
    IRSService irsService;

    @GetMapping("/mahasiswa/riwayat/{id}")
    public String mahasiswaRiwayat(@PathVariable(value="id") String id, Model model){
    	List<IRS> irs  = irsService.getAllIRS(id);
    	
    	for(int i = 0; i < irs.size(); i++) {
    		List<Kelas> kelas = irs.get(i).getKelas_list();
    		for(int j = 0; j < kelas.size(); j++) {
    			
    			kelas.get(j).setNilaiAngka(10);
    			
    			
    			if(kelas.get(j).getNilaiAngka() < 40) {
    				kelas.get(j).setNilaiHuruf("E");
    			}
    			else if((kelas.get(j).getNilaiAngka() < 55)) {
    				kelas.get(j).setNilaiHuruf("D");
    			}
    			else if((kelas.get(j).getNilaiAngka() < 60)) {
    				kelas.get(j).setNilaiHuruf("C");
    			}
    			else if((kelas.get(j).getNilaiAngka() < 65)) {
    				kelas.get(j).setNilaiHuruf("C+");
    			}
    			else if((kelas.get(j).getNilaiAngka() < 70)) {
    				kelas.get(j).setNilaiHuruf("B-");
    			}
    			else if((kelas.get(j).getNilaiAngka() < 75)) {
    				kelas.get(j).setNilaiHuruf("B");
    			}
    			else if((kelas.get(j).getNilaiAngka() < 80)) {
    				kelas.get(j).setNilaiHuruf("B+");
    			}
    			else if((kelas.get(j).getNilaiAngka() < 85)) {
    				kelas.get(j).setNilaiHuruf("A-");
    			}
    			else {
    				kelas.get(j).setNilaiHuruf("A");
    			}
    		}
    	}
    	
    	model.addAttribute("irs", irs);
    	model.addAttribute("idMahasiswa", id);
        return "riwayat";
    }
    
    @GetMapping("/mahasiswa/ringkasan")
    public String mahasiswaRingkasan(){
        return "lihat-mahasiswa";
    }
}
