package com.team.chathack.config;

import com.team.chathack.entity.TableIds;
import com.team.chathack.repo.TableIdsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OnStartUp implements CommandLineRunner {

//    private final TableIdsRepo tableIdsRepo;

    @Override
    public void run(String... args) throws Exception {
//        if(tableIdsRepo.count() == 0){
//            System.out.println(" <<-<< Save TableIds >>->>");
//            tableIdsRepo.save(TableIds.builder().id(1).msg(0).build());
//        }
    }
}
