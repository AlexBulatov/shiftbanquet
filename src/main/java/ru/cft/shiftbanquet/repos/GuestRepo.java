package ru.cft.shiftbanquet.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cft.shiftbanquet.entity.Guest;

@Repository
public interface GuestRepo extends JpaRepository<Guest, Long> {

}
