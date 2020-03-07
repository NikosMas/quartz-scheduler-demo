package com.schdl.test.domain.repository;

import com.schdl.test.domain.NewsNestedData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsNestedDataRepository extends JpaRepository<NewsNestedData, Integer> {
}
