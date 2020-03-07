package com.schdl.test.domain.repository;

import com.schdl.test.domain.MainNewsInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainNewsInfoRepository extends JpaRepository<MainNewsInfo, Integer> {
}
