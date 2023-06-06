package hiber.dao;

import hiber.model.User;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().persist(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User join fetch Car ");
      return query.getResultList();
   }

   @Override
   public User getUserByCar(String model, int series) {
      Session session = sessionFactory.getCurrentSession();
      Query query = session.createQuery("from User u join fetch u.car c where u.car.model = ?1 and u.car.series = ?2 ");
      query.setParameter(1, model).setParameter(2, series);
      return (User) query.uniqueResult();
   }

}
