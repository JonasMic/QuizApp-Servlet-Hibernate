package io.jonas.quizapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import io.jonas.quizapp.entity.Questzion;
import io.jonas.quizapp.exception.NotFoundException;

public class QuestzionDao {

	public void createQuestion(Questzion question) {

		try(Session session = HibernateConfig.getSessionFactory().openSession()){
			// perform non select operations create /update / delete
			Transaction transaction = session.beginTransaction();
			session.save(question);
			transaction.commit();
		}
	}

	public List<Questzion> getQuestions() {
		try(Session session = HibernateConfig.getSessionFactory().openSession()){
			return session.createQuery("FROM QUESTZION", Questzion.class).list();
		}

	}

	public Questzion getQuestionById(Integer id) {
		try(Session session = HibernateConfig.getSessionFactory().openSession()){
			return session.get(Questzion.class, id);
		}

	}

	public void updateQuestion(Questzion questzion) throws NotFoundException{
		try(Session session = HibernateConfig.getSessionFactory().openSession()){
			// first get the question with the given id
			Questzion question= session.get(Questzion.class, questzion.getId());
			if(question !=null) {
				Transaction transaction = session.beginTransaction();
				question.setQuestion(questzion.getQuestion());
				question.setOption1(questzion.getOption1());
				question.setOption2(questzion.getOption2());
				question.setOption3(questzion.getOption3());
				question.setOption4(questzion.getOption4());
				question.setAnswer(questzion.getAnswer());
				
				session.update(question);
				transaction.commit();
			}
			else {
				throw new NotFoundException("a question with id: "+ questzion.getId() + " is not found!");
			}
		}
	}

	public void deleteQuestion(Integer id) throws NotFoundException {
		try(Session session = HibernateConfig.getSessionFactory().openSession()){
			// first get the question with the given id
			Questzion question= session.get(Questzion.class, id);
			if(question !=null) {
				Transaction transaction = session.beginTransaction();
				session.delete(id);
				transaction.commit();
			}
			else {
				throw new NotFoundException("a question with id: "+ id + " is not found!");
			}
		}

	}

}
