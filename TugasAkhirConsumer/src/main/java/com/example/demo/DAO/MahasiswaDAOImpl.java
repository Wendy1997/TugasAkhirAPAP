package com.example.demo.DAO;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Model.Mahasiswa;
import com.example.demo.Service.FakultasService;
import com.example.demo.Service.MahasiswaService;

@Service
@Primary
public class MahasiswaDAOImpl implements MahasiswaService, FakultasService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	mahasiswaMapper mahasiswamapper;
	
	@Override
	public List<Mahasiswa> selectAllMahasiswa() {
		// TODO Auto-generated method stub
		ResponseEntity<Mahasiswa[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/mahasiswa/viewall", Mahasiswa[].class);
		return Arrays.asList(responseEntity.getBody());
	}

	@Override
	public void add(Mahasiswa mahasiswa) {
		// TODO Auto-generated method stub
		mahasiswamapper.add(mahasiswa);
		
	}
	
	@Override
	public void addUser(String username, int id_mahasiswa) {
		// TODO Auto-generated method stub
		mahasiswamapper.addUser(username, id_mahasiswa);
		
	}
	
	@Override
	public void addUserRole(int user_role_id, String username) {
		// TODO Auto-generated method stub
		mahasiswamapper.addUserRole(user_role_id, username);
		
	}

	@Override
	public Mahasiswa dataView(String npm) {
		// TODO Auto-generated method stub
		Mahasiswa mahasiswa = restTemplate.getForObject("http://localhost:8080/api/mahasiswa/view/" + npm, Mahasiswa.class);
		return mahasiswa;
	}
	
	@Override
	public int getId(String username) {
		// TODO Auto-generated method stub
		int id;
		if(mahasiswamapper.getId(username) == null) {
			id = 0;
		} else {
			id = Integer.parseInt(mahasiswamapper.getId(username));
		}
		return (id);
	}
	
	@Override
	public void update(Mahasiswa mahasiswa) {
		// TODO Auto-generated method stub
		mahasiswamapper.update(mahasiswa);
		
	}

	@Override
	public Mahasiswa lulus(String lulus) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Map<String, Object> namaUniv(Integer id_univ) {
		// TODO Auto-generated method stub
		Map<String, Object> universitas = restTemplate.getForObject("https://apap2017-univ-apps.herokuapp.com/getUniversitas/" + id_univ, Map.class);
		return universitas;
	}
	
	@Override
	public Map<String, Object> namaFakultas(Integer id_univ, Integer id_fakultas) {
		// TODO Auto-generated method stub
		Map<String, Object> fakultas = restTemplate.getForObject("https://apap2017-univ-apps.herokuapp.com/getFakultas/" + id_univ + "/" + id_fakultas, Map.class);
		return fakultas;
	}

	@Override
	public Map<String, Object> namaProdi(Integer id_univ, Integer id_fakultas, Integer id_prodi) {
		// TODO Auto-generated method stub
		Map<String, Object> prodi = restTemplate.getForObject("https://apap2017-univ-apps.herokuapp.com/getProdi/" + id_univ + "/" + id_fakultas + "/" + id_prodi, Map.class);
		return prodi;
	}
	
	@Override
	public Mahasiswa view(int id) {
		// TODO Auto-generated method stub
		Mahasiswa mahasiswa = restTemplate.getForObject("http://localhost:8080/api/mahasiswa/ringkasan/" + id, Mahasiswa.class);
		return mahasiswa;
	}
}
