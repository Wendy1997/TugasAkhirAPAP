package com.example.demo.Service;

import com.example.demo.Model.IRS;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IRSService {
    IRS getIRS(String id_mahasiswa);
    List<IRS> getAllIRS(String id_mahasiswa);
}
