package es.damarur.myquiniela.mapper;

import es.damarur.myquiniela.domain.Game;
import es.damarur.myquiniela.domain.Team;
import es.damarur.myquiniela.model.v1.admin.AdminGameDTO;
import es.damarur.myquiniela.model.v1.admin.AdminQuinielaDTO;
import es.damarur.myquiniela.domain.Quiniela;
import es.damarur.myquiniela.model.v1.admin.AdminTeamDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminMapper {

    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    Quiniela fromAdminQuiniela(AdminQuinielaDTO adminQuinielaDTO);

    AdminQuinielaDTO fromQuiniela(Quiniela quiniela);

    @Mapping(target = "gameId", source = "order")
    @Mapping(target = "local", source = "localTeam")
    @Mapping(target = "visitor", source = "visitorTeam")
    @Mapping(target = "computedResult", source = "result")
    Game fromAdminGame(AdminGameDTO adminGameDTO);

    @Mapping(target = "order", source = "gameId")
    @Mapping(target = "localTeam", source = "local")
    @Mapping(target = "visitorTeam", source = "visitor")
    @Mapping(target = "result", source = "computedResult")
    AdminGameDTO fromGame(Game game);

    Team fromAdminTeam(AdminTeamDTO adminTeamDTO);

    AdminTeamDTO fromTeam(Team team);

}
