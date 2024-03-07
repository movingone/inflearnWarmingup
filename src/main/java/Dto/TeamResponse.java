package Dto;

import User.Team;

public record TeamResponse(
        String name,
        String manager,
        int memberCount
) {
    public TeamResponse(Team team) {
        this(team.getName(), team.getManagerName(), team.getMemberCount());
    }
}