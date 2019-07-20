package com.b127.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.b127.demo.entity.Feed;

/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 6/26/2019
 * Time: 8:15 PM}
 */


public interface FeedRepository extends JpaRepository<Feed, Integer> {
}
