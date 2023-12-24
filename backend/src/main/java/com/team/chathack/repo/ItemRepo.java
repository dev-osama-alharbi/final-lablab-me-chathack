package com.team.chathack.repo;

import com.team.chathack.entity.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends CrudRepository<Item,Long> {
    Iterable<Item> findAllByProjectId(long asList);

//    Iterable<Item> findAllProjectIdAndMsgId(long projectId, Long msgId);

    Iterable<Item> findAllByProjectIdAndMsgId(long projectId, long msgId);
}
