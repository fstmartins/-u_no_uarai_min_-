package org.charlie.rapbattle.persistance;

import org.springframework.ui.Model;

import java.util.List;

public interface Dao<T> {

    List<T> findAll();

    T findById(Integer id);

    T saveOrUpdate(T modelObject);

  //  void delete(Integer id);
}
