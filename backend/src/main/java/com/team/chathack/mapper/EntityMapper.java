package com.team.chathack.mapper;

import com.team.chathack.dto.*;
import com.team.chathack.dto.member.RegisterMemberDTO;
import com.team.chathack.dto.messages.MsgDTO;
import com.team.chathack.dto.messages.NewMsgDTO;
import com.team.chathack.entity.*;
import org.mapstruct.Mapper;

@Mapper
public interface EntityMapper {

    AuthorityDTO mapAuthorityToDTO(Authority authority);

    RegisterMemberDTO mapMemberToDTO(Member member);

    MemberAuthorityDTO mapMemberAuthorityToDTO(MemberAuthority memberAuthority);

    ProjectDTO mapProjectToDTO(Project project);

    ItemTypeDTO mapItemTypeToDTO(ItemType itemType);

    MemberProjectDTO mapMemberProjectToDTO(MemberProject memberProject);

    ComponentDTO mapComponentToDTO(Component component);

    ItemDTO mapItemToDTO(Item item);
    MsgDTO mapNewMsgDTOToMsgDTO(NewMsgDTO newMsgDTO);

    MsgDTO mapMsgToMsgDTO(Msg msg);
}