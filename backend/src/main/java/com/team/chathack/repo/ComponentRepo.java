package com.team.chathack.repo;

import com.team.chathack.entity.Component;
import com.team.chathack.entity.Msg;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComponentRepo extends CrudRepository<Component,Long> {

    Optional<Component> findByProjectId(long projectId);

    Iterable<Component> findAllByProjectId(Long projectId);

    long countByProjectIdAndMsgId(long projectId, Long msgId);

    long countByProjectIdAndMsgIdAndComponentType(long projectId, Long msgId, String toString);

    Optional<Component> findByProjectIdAndComponentType(long projectId, String toString);

    Iterable<Component> findAllByProjectIdAndMsgId(long projectId, long msgId);
}
