package com.b127.demo.service.custom.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b127.demo.dto.BattleBuddyDTO;
import com.b127.demo.entity.BattleBuddy;
import com.b127.demo.repository.BattleBuddyRepository;
import com.b127.demo.repository.UserRepository;
import com.b127.demo.service.custom.BattleBuddyService;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 6/26/2019
 * Time: 10:08 PM}
 */

@Service
public class BattleBuddyServiceImpl implements BattleBuddyService {
    @Autowired
    BattleBuddyRepository battleBuddyRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public List<BattleBuddyDTO> findAll() {
        return battleBuddyRepository.findAll().stream().map(x ->
                new BattleBuddyDTO(x.getBattleBuddyId(),x.getUser().getUserId(),x.getConsole(),x.getRegion(),x.getGameName(),x.getVoiceChat(),x.getLanguage(),x.getText())).collect(Collectors.toList());
    }

    @Override
    public BattleBuddyDTO getById(int id) {
        BattleBuddy x = battleBuddyRepository.getOne(id);
        return new BattleBuddyDTO(x.getBattleBuddyId(),x.getUser().getUserId(),x.getConsole(),x.getRegion(),x.getGameName(),x.getVoiceChat(),x.getLanguage(),x.getText());
    }

    @Override
    public void update(BattleBuddyDTO battleBuddyDTO) {
        BattleBuddy battleBuddy = new BattleBuddy(battleBuddyDTO.getBattleBuddyId(),userRepository.getOne(battleBuddyDTO.getUserId()), battleBuddyDTO.getConsole(), battleBuddyDTO.getRegion(), battleBuddyDTO.getGameName(), battleBuddyDTO.getVoiceChat(), battleBuddyDTO.getLanguage(), battleBuddyDTO.getText());
        battleBuddyRepository.save(battleBuddy);
    }

    @Override
    public void delete(int id) {
        battleBuddyRepository.deleteById(id);
    }

    @Override
    public void insert(BattleBuddyDTO battleBuddyDTO) {
        BattleBuddy battleBuddy = new BattleBuddy(userRepository.getOne(battleBuddyDTO.getUserId()), battleBuddyDTO.getConsole(), battleBuddyDTO.getRegion(), battleBuddyDTO.getGameName(), battleBuddyDTO.getVoiceChat(), battleBuddyDTO.getLanguage(), battleBuddyDTO.getText());
        battleBuddyRepository.save(battleBuddy);
    }
}
