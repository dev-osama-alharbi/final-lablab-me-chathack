package com.team.chathack.repo;

import com.team.chathack.entity.Msg;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MsgRepo extends CrudRepository<Msg,Long> {
}
