package Controller;

import Dto.TeamCreateRequest;
import Dto.TeamResponse;
import Service.TeamService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
public class CompanyController {

    private final TeamService teamService;

    @PostMapping()
    public void createTeam(@RequestBody @Valid TeamCreateRequest request) {
        this.teamService.createTeam(request);
    }

    @GetMapping()
    public List<TeamResponse> findAllTeams() {
        return this.teamService.findAllTeams();
    }


}
