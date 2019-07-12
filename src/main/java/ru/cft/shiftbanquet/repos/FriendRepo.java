package ru.cft.shiftbanquet.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cft.shiftbanquet.entity.FriendRelation;

public interface FriendRepo extends JpaRepository<FriendRelation, Long> {


}
