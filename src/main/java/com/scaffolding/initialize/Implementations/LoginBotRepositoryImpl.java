package com.scaffolding.initialize.Implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.scaffolding.initialize.Entities.LoginBot;
import com.scaffolding.initialize.Repository.LoginBotRepositoryCustom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class LoginBotRepositoryImpl implements LoginBotRepositoryCustom {

    private EntityManager entityManager;

    public LoginBotRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<LoginBot> BuscarPorCriteria(Integer userId, String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<LoginBot> query = cb.createQuery(LoginBot.class);
        Root<LoginBot> loginBot = query.from(LoginBot.class);

        List<Predicate> predicates = new ArrayList<>();

        if (userId != null) {
            predicates.add(cb.equal(loginBot.get("userId"), userId));
        }

        if (name != null && !name.isEmpty()) {
            predicates.add(cb.like(loginBot.get("name"), "%" + name + "%"));
        }

        query.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
    }
}
