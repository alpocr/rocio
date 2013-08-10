package net.ulatina.rocio.dao;

import java.io.IOException;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

@SuppressWarnings("deprecation")
public class AppDAO implements Dao {
	
	
	private HibernateTemplate hibernateTemplate;

	@Override
	public void save(Object obj) {
		// TODO Auto-generated method stub
		hibernateTemplate.saveOrUpdate(obj);
	}

	@Override
	public void save(List<Object> list) {
		// TODO Auto-generated method stub
		for (Object obj: list){
			hibernateTemplate.saveOrUpdate(obj);
		}
	}

	@Override
	public Boolean delete(Object obj) {
		// Este método debe asegurarse que el guardado se dio efectivamente.
		hibernateTemplate.delete(obj);
		return true;
	}

	@Override
	public Boolean update(Object objx, Object objy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> getList(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> getList(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(List<Object> list) {
		// TODO Auto-generated method stub
		for (Object obj: list){
			hibernateTemplate.delete(obj);
		}
		return true;
	}

}
