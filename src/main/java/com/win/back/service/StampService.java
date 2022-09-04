package com.win.back.service;

import com.win.back.dto.AddStampDTO;
import com.win.back.entity.Stamp;
import com.win.back.repository.StampRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StampService {

    private final StampRepository stampRepository;
    boolean addFlag = true;

    public boolean addStamp(AddStampDTO addStampDTO) {
        Stamp stamp = new Stamp();
        stamp.setId(addStampDTO.getId());
        stamp.setStampLocation(addStampDTO.getStampLocation());

        List<Stamp> all = stampRepository.findAll();
        for (Stamp stamp1 : all) {
            if (stamp1.getStampLocation().equals(stamp.getStampLocation()) &&
                    stamp1.getId().equals(stamp.getId())) {
                addFlag = false;
            }
        }
        if (addFlag) {
            stampRepository.save(stamp);
            return true;
        }
        else {
            addFlag = true;
            return false;
        }
    }
}
