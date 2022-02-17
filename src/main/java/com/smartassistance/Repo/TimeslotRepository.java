package com.smartassistance.Repo;

import com.smartassistance.Model.Timeslot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeslotRepository extends JpaRepository<Timeslot, Long> {
    Timeslot findTimeslotByTimeslot(String timeslot);
}
