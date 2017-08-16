package com.czy.qcloud.face.repository;

import com.czy.qcloud.face.entity.Face;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaceRepository extends CrudRepository<Face, Long> {
    Face findFirstByFaceId(String faceId);

    Integer deleteByFaceId(String faceId);
}
