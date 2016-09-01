package com.example;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mhellber on 9/1/16.
 */
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
