package ua.lviv.lgs.dao.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ua.lviv.lgs.dao.MagazineDao;
import ua.lviv.lgs.domain.Magazine;
import ua.lviv.lgs.shared.FactoryManager;


	public class MagazineDaoImpl implements MagazineDao {
		private EntityManager em = (EntityManager) FactoryManager.getEntityManager();

		@Override
		public Magazine create(Magazine magazine) {
			try {
				em.getTransaction().begin();
				em.persist(magazine);
				em.getTransaction().commit();

			} catch (Exception e) {
				e.printStackTrace();
			}

			return magazine;
		}

		@Override
		public Magazine read(Integer id) {
			Magazine magazine = null;
			try {
				magazine = em.find(Magazine.class, id);
			} catch (Exception e) {
				e.printStackTrace();
			}

			return magazine;
		}

		@Override
		public Magazine update(Magazine magazine) {

			try {
				// TODO: to be implemented
			} catch (Exception e) {
			}

			return magazine;
		}

		@Override
		public void delete(Integer id) {
			try {
				// TODO: to be implemented
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public List<Magazine> readAll() {
			Query query = null;
			try {
				query = em.createQuery("SELECT e FROM Magazine e");

			} catch (Exception e) {
				e.printStackTrace();
			}
			return query.getResultList();
		}

	}
