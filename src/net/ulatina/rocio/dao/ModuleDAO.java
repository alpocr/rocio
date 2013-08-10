/**
 * 
 */
package net.ulatina.rocio.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * @author alpocr
 *
 */
public class ModuleDAO implements Dao {

	private HibernateTemplate hibernateTemplate;
	
	/* (non-Javadoc)
	 * @see net.ulatina.rocio.dao.Dao#save(java.lang.Object)
	 */
	@Override
	public void save(Object obj) {
		// TODO Auto-generated method stub
		hibernateTemplate.saveOrUpdate(obj);
	}

	/* (non-Javadoc)
	 * @see net.ulatina.rocio.dao.Dao#save(java.util.List)
	 */
	@Override
	public void save(List<Object> list) {
		// TODO Auto-generated method stub
		for (Object obj: list){
			hibernateTemplate.saveOrUpdate(obj);
		}

	}

	/* (non-Javadoc)
	 * @see net.ulatina.rocio.dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public Boolean delete(Object obj) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(obj);
		return true;
	}

	/* (non-Javadoc)
	 * @see net.ulatina.rocio.dao.Dao#update(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Boolean update(Object objx, Object objy) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.ulatina.rocio.dao.Dao#getList(java.lang.String)
	 */
	@Override
	public <T> List<T> getList(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see net.ulatina.rocio.dao.Dao#getList(java.lang.Class)
	 */
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
