package io.jonas.quizapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import io.jonas.quizapp.entity.Userh;
import io.jonas.quizapp.exception.NotFoundException;

public class UserhDao {

	public void createUser(Userh user) {

		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			// perform non select operations create /update / delete
			Transaction transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
		}
	}

	public List<Userh> getUsers() {
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			return session.createQuery("FROM Userh", Userh.class).list();
		}

	}

	public Userh getUserById(Integer id) {
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			return session.get(Userh.class, id);
		}

	}

	public List<Userh> getUserByName(String username) {
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			List<Userh> user = session.createNamedQuery("GET_USER_BY_NAME")
					.setParameter("username", username).getResultList();
			return user;
		}
	}

	public void updateUser(Userh userh) throws NotFoundException {
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			// first get the question with the given id or
			// if name is given use named query to get the result

			Userh user = (Userh) session.createNamedQuery("GET_USER_BY_NAME")
					.setParameter("username", userh.getUsername()).getResultList();
			if (user != null) {
				Transaction transaction = session.beginTransaction();
				user.setUsername(userh.getUsername());
				user.setEmail(userh.getEmail());
				user.setPassword(userh.getPassword());
				user.setRole(userh.getRole());

				session.update(user);
				transaction.commit();
			} else {
				throw new NotFoundException("user with username: " + userh.getUsername() + " is not found!");
			}
		}
	}

	public void deleteUser(Integer id) throws NotFoundException {
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			// first get the question with the given id
			Userh user = session.get(Userh.class, id);
			if (user != null) {
				Transaction transaction = session.beginTransaction();
				session.delete(user);
				transaction.commit();
			} else {
				throw new NotFoundException("user with username: " + id + " is not found!");
			}
		}

	}

}
