package com.tharun.Crud_Operation.Repository;

import com.tharun.Crud_Operation.Model.Crud_Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Crud_repo extends JpaRepository<Crud_Model,Long> {
    Optional<Crud_Model> findByTitle(String title);

    List<Crud_Model> findByPublished(boolean published);



}
