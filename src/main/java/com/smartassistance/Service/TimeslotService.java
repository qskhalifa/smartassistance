package com.smartassistance.Service;

import com.smartassistance.Model.Timeslot;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TimeslotService {

   List<Timeslot> getAllSlots();
    Timeslot getTimeslotById(Long id);
   Timeslot createTimeslot(Timeslot timeslot);
    Timeslot updateTimeslot(Long id, Timeslot timeslot);
    boolean deleteTimeslot(Long id);

}
