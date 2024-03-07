package Service;

import Dto.TeamCreateRequest;
import Dto.TeamResponse;
import Repostiory.TeamRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;

    @Transactional
    public void createTeam(TeamCreateRequest request) {
        this.teamRepository.save(request.toEntity());
    }

    @Transactional(readOnly = true)
    public List<TeamResponse> findAllTeams() {
        return this.teamRepository
                .findAll()
                .stream()
                .map(TeamResponse::new)
                .toList();
    }
}
