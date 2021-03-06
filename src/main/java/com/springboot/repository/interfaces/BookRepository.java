package com.springboot.repository.interfaces;

import com.springboot.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rashmi.CM
 * @since 20-02-2021
 */
@Repository
public interface BookRepository extends JpaRepository<Book,Long>{

}
