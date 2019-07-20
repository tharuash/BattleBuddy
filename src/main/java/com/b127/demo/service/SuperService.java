package com.b127.demo.service;



import java.util.List;

import com.b127.demo.dto.SuperDTO;


/**
 * Created by Avalanche Pvt.Ltd.
 * User: Dilshan.Fardil
 * Date: 6/26/2019
 * Time: 8:22 PM}
 */


public interface SuperService<T extends SuperDTO> {

    List<T> findAll();

    T getById(int id);

    void update(T t);

    void delete(int id);

    void insert(T t);
    
    

}
