package com.b127.demo.service.custom.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.b127.demo.entity.BattleBuddy;
import com.b127.demo.repository.BattleBuddyRepository;
import com.b127.demo.service.custom.BattlebuddyService;

@Service
public class BattleBuddyServiceImpl implements BattlebuddyService {
	
	@Autowired
	BattleBuddyRepository battleBuddyRepository;
	
	
	@Override
	public List<BattleBuddy> getAllBattlebuddies() {
		List<BattleBuddy> list = new ArrayList<>();
		battleBuddyRepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public BattleBuddy findById(int battlebuddyId) {
		return battleBuddyRepository.findById(battlebuddyId).orElse(null);
	}

	@Override
	public void delete(int battlebuddyId) {
		battleBuddyRepository.deleteById(battlebuddyId);
		
	}

	@Override
	public BattleBuddy insert(BattleBuddy battleBuddy) {
		BattleBuddy localBuddy = battleBuddyRepository.findById(battleBuddy.getBattleBuddyId()).orElse(null);
		
		if(localBuddy == null) {
			localBuddy = new BattleBuddy();
		}
		
		localBuddy.setBattleBuddyId(battleBuddy.getBattleBuddyId());
		localBuddy.setConsole(battleBuddy.getConsole());
		localBuddy.setGameName(battleBuddy.getGameName());
		localBuddy.setLanguage(battleBuddy.getLanguage());
		localBuddy.setRegion(battleBuddy.getRegion());
		localBuddy.setText(battleBuddy.getText());
		localBuddy.setUser(battleBuddy.getUser());
		localBuddy.setVoiceChat(battleBuddy.getVoiceChat());
		
		
		return battleBuddyRepository.save(localBuddy);
		
		
	}

	@Override
	public List<BattleBuddy> findByUserId(int userId) {
		List<BattleBuddy> list = new ArrayList<>();
		battleBuddyRepository.findByUserId(userId).forEach(e -> list.add(e));
		return list;
	}

	
	
	

}
