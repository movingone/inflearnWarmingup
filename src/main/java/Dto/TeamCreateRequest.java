package Dto;

import User.Team;
import jakarta.validation.constraints.NotEmpty;

public record TeamCreateRequest(
        @NotEmpty
        String name
) {
    public Team toEntity() {
        return Team.builder()
                .name(name)
                .build();
    }
}