package edu.hanoi.service.dao.impl;

import edu.hanoi.service.dao.UserDAO;
import edu.hanoi.service.model.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("userDAO")
public class UserDAOImpl implements UserDAO {
    Session session = null;
    private final static Logger LOGGER = Logger.getLogger(UserDAOImpl.class);

    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    @Qualifier("sessionFactory")
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> list() {
        try{
            String sql ="select * from V_USER order by age desc";
            Query query = session.createQuery(sql);
            return (List<User>) query.list();
        }finally {
            session.close();
        }
    }
}
