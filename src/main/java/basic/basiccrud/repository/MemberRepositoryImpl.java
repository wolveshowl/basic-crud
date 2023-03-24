package basic.basiccrud.repository;

import basic.basiccrud.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class MemberRepositoryImpl implements MemberRepository{

    private final EntityManager em;

    @Override
    public void save(Member member) {
        em.persist(member);
    }

    @Override
    public Optional<Member> findByMemId(String userId) {
        List<Member> result = em.createQuery("select m from Member m where m.memUserid = :userId", Member.class)
                .setParameter("userId", userId)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public Member findById(Long id) {
        return em.find(Member.class, id);
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m order by m.id DESC")
                .getResultList();
    }
}
