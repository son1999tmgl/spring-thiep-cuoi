package wedding.invitation.model.reponsitory;

import lombok.Builder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wedding.invitation.model.entity.MUser;

@Repository
public interface UserReponsitory extends JpaRepository<MUser, Long> {
    boolean existsByEmail(String email);
}
