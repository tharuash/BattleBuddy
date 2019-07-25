package com.b127.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.b127.demo.entity.BattleBuddy;

public interface BattleBuddyRepository extends CrudRepository<BattleBuddy, Integer> {
	
	List<BattleBuddy> findByUserId(int userId);

}
