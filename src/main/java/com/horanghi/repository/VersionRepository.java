package com.horanghi.repository;

import com.horanghi.model.PredictVersion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VersionRepository extends CrudRepository<PredictVersion, String> {

    PredictVersion findByVersion(String version);

    List<PredictVersion> findAll();

}
