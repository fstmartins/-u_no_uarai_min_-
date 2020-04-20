package org.charlie.rapbattle.test;

import org.charlie.rapbattle.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Controller
public class GetUser {

    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @RequestMapping(method = RequestMethod.GET, value="/gets")
    public String showLoginPage(Model model){

        CriteriaQuery<User> criteriaQuery = em.getCriteriaBuilder().createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);

        model.addAttribute("users",em.createQuery(criteriaQuery).getResultList());
        return "get_users";
    }

}
