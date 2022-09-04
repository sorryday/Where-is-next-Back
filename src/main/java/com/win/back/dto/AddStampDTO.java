package com.win.back.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class AddStampDTO {
    String id;
    String stampLocation;

    @Override
    public String toString() {
        return "AddStampDTO{" +
                "id='" + id + '\'' +
                ", stampLocation='" + stampLocation + '\'' +
                '}';
    }
}



