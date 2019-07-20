package com.b127.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.b127.demo.entity.BattleBuddy;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 6/26/2019
 * Time: 8:16 PM}
 */


public interface BattleBuddyRepository extends JpaRepository<BattleBuddy, Integer> {
}
