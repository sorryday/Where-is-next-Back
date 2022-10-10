package com.win.back.service;

import com.win.back.dto.AddStampDTO;
import com.win.back.entity.Point;
import com.win.back.entity.Stamp;
import com.win.back.repository.LocationSearchRepository;
import com.win.back.repository.PointRepository;
import com.win.back.repository.StampRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StampService {

    private final StampRepository stampRepository;
    private final PointRepository pointRepository;
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

            // 맞는 유저가 있다면 포인트 50원 적립
            List<Point> all1 = pointRepository.findAll();
            for (Point point : all1) {
                if (point.getId().equals(addStampDTO.getId())) {
                    Point insertPoint = new Point();
                    insertPoint.setId(addStampDTO.getId());
                    insertPoint.setPoint(Integer.toString(Integer.parseInt(point.getPoint()) + 50));
                    pointRepository.save(insertPoint);
                }
            }
            return true;
        }
        else {
            addFlag = true;
            return false;
        }
    }

    // 유저가 획득한 스탬프 리스트를 반환하는 함수
    public List<Stamp> getStampList(String id) {
        List<Stamp> list = new ArrayList<>();

        List<Stamp> all = stampRepository.findAll();
        for (Stamp stamp : all) {
            if (stamp.getId().equals(id)) {
                list.add(stamp);
            }
        }
        return list;
    }
}