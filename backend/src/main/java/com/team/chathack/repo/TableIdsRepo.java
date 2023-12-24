package com.team.chathack.repo;

import com.team.chathack.entity.Msg;
import com.team.chathack.entity.TableIds;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface TableIdsRepo extends CrudRepository<TableIds,Long> {
}
