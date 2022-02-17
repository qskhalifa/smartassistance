package com.smartassistance.ServiceImpl;

import com.smartassistance.Model.Timeslot;
import com.smartassistance.Repo.TimeslotRepository;
import com.smartassistance.Service.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeslotServiceImpl implements TimeslotService {

    private final TimeslotRepository timeslotRepository;

    @Autowired
    public TimeslotServiceImpl(TimeslotRepository timeslotRepository) {
        this.timeslotRepository = timeslotRepository;
    }

    @Override
    public List<Timeslot> getAllSlots() {
        return timeslotRepository.findAll();
    }

    @Override
    public Timeslot getTimeslotById(Long id) {
        return timeslotRepository.findById(id).orElse(null);
    }

    @Override
    public Timeslot createTimeslot(Timeslot timeslot) {

        //Checking if the New timeslot already Exist in the DB
        Timeslot existTimeslot = timeslotRepository.findTimeslotByTimeslot(timeslot.getTimeslot());

        if (existTimeslot == null) {
            timeslotRepository.save(timeslot);
            return timeslot;
        }

        return null;
    }

    @Override
    public Timeslot updateTimeslot(Long id, Timeslot timeslot) {
        // Checking if the Timeslot Exist in the DB
        timeslotRepository.findById(id)
                .ifPresent(existTimeslot -> existTimeslot.setTimeslot(timeslot.getTimeslot()));

        return null;
    }

    @Override
    public boolean deleteTimeslot(Long id) {
        // Checking if the Timeslot Exist in the DB
        Timeslot existTimeslot = timeslotRepository.findById(id).orElse(null);

        if (existTimeslot != null) {
            timeslotRepository.delete(existTimeslot);
            return true;
        }
        return false;
    }
}
