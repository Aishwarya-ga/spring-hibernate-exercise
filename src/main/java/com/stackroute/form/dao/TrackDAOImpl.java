package com.stackroute.form.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;


import org.hibernate.SessionFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.form.model.Track;

@Repository
@Transactional
public class TrackDAOImpl implements TrackDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public TrackDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean saveTrack(Track track) {
		try {

			sessionFactory.getCurrentSession().save(track);
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}
	@Override
	public String getTrackById(int id) {
		Query query = sessionFactory.getCurrentSession().createQuery("select username from Track where id ='"+id+"'");
		List<String> name = ((org.hibernate.query.Query) query).list();
		return name.get(0);
	}

}
