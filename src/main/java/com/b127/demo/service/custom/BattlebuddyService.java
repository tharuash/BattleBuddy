package com.b127.demo.service.custom;

import java.util.List;


import com.b127.demo.entity.BattleBuddy;



public interface BattlebuddyService {
	
	List<BattleBuddy> getAllBattlebuddies();
	
	BattleBuddy findById(int battlebuddyId);
	
	void delete(int battlebuddyId);
	
	BattleBuddy insert(BattleBuddy battleBuddy);
	
	List<BattleBuddy> findByUserId(int userId);
	
	//List<BattleBuddyDTO> getAllBattlebuddyDTOs();
}
