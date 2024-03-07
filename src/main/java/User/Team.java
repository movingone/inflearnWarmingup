package User;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team extends DateTimeBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Member> members = new ArrayList<>();

    @Builder
    public Team(String name) {
        this.name = name;
    }

    public boolean hasManager() {
        return this.members.stream().anyMatch(member -> member.getRole().equals(MemberRole.MANAGER));
    }

    public String getManagerName() {
        return this.members.stream()
                .filter(member -> member.getRole().equals(MemberRole.MANAGER))
                .map(Member::getName)
                .findFirst()
                .orElse(null);
    }

    public int getMemberCount() {
        return this.members != null ? this.members.size() : 0;
    }
}