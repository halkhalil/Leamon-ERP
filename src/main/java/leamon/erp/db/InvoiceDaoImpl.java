package leamon.erp.db;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import leamon.erp.db.mapper.InvoiceMapper;
import leamon.erp.db.util.MyBatsUtil;
import leamon.erp.model.InvoiceInfo;
import lombok.Getter;

@Getter
public class InvoiceDaoImpl  implements LeamonERPDao<InvoiceInfo>{

	static final Logger LOGGER = Logger.getLogger(InvoiceDaoImpl.class);
	private static InvoiceDaoImpl INSTANCE;

	public static InvoiceDaoImpl getInstance(){
		if(INSTANCE==null){
			synchronized (InvoiceDaoImpl.class) {
				if(INSTANCE == null){
					INSTANCE = new InvoiceDaoImpl();

				}
			}
		}//end if
		return INSTANCE;
	}

	@Override
	public List<InvoiceInfo> getItemList() throws Exception{
		LOGGER.info("InvoiceDaoImpl[getItemList] inside.");
		SqlSession session= MyBatsUtil.getSqlSessionFactory().openSession();
		InvoiceMapper invoiceInfoMapper= session.getMapper(InvoiceMapper.class);
		List<InvoiceInfo> InvoiceInfos = invoiceInfoMapper.getAll();
		session.close();
		LOGGER.info("InvoiceDaoImpl[getItemList] end.");
		return InvoiceInfos;
	}
	
	public List<InvoiceInfo> getItemListIncludeDisabled() {
		LOGGER.info("InvoiceDaoImpl[getItemList] inside.");
		SqlSession session= MyBatsUtil.getSqlSessionFactory().openSession();
		InvoiceMapper invoiceInfoMapper= session.getMapper(InvoiceMapper.class);
		List<InvoiceInfo> InvoiceInfos = invoiceInfoMapper.getAllWithDisabled();
		session.close();
		LOGGER.info("InvoiceDaoImpl[getItemList] end.");
		return InvoiceInfos;
	}

	@Override
	public void save(InvoiceInfo item) throws Exception {

		LOGGER.info("InvoiceDaoImpl[save] inside.");
		SqlSession session= MyBatsUtil.getSqlSessionFactory().openSession();
		InvoiceMapper InvoiceMapper= session.getMapper(InvoiceMapper.class);
		try{
			InvoiceMapper.insert(item);
			session.commit();
			LOGGER.info("InvoiceDaoImpl[save] id ["+item.getId()+"] after insert.");
		}catch(Throwable t){
			throw t;
		}finally{
			session.close();
		}
		LOGGER.info("InvoiceDaoImpl[save] end.");

	}

	@Override
	public void disable(InvoiceInfo item) throws Exception{
		LOGGER.info("InvoiceDaoImpl[disable] inside.");
		SqlSession session= MyBatsUtil.getSqlSessionFactory().openSession();
		InvoiceMapper invoiceMapper= session.getMapper(InvoiceMapper.class);
		try{
		invoiceMapper.disableInvoiceById(item);
		session.commit();
		}catch(Exception exp){
			session.rollback();
			throw exp;
		}finally{
			session.close();
		}
		LOGGER.info("InvoiceDaoImpl[disable] end.");
	}

	@Override
	public void update(InvoiceInfo item) throws Exception{
		LOGGER.info("InvoiceDaoImpl[update] inside.");
		SqlSession session= MyBatsUtil.getSqlSessionFactory().openSession();
		InvoiceMapper InvoiceMapper= session.getMapper(InvoiceMapper.class);
		try{
		InvoiceMapper.update(item);
		session.commit();
		}catch(Exception exp){
			session.rollback();
			throw exp;
		}finally{
			session.close();
		}
		LOGGER.info("InvoiceDaoImpl[update] end.");
	}

	
	public List<InvoiceInfo> getItemListWithInvoiceItemList() {
		LOGGER.info("InvoiceDaoImpl[getItemList] inside.");
		SqlSession session= MyBatsUtil.getSqlSessionFactory().openSession();
		InvoiceMapper invoiceInfoMapper= session.getMapper(InvoiceMapper.class);
		List<InvoiceInfo> InvoiceInfos = invoiceInfoMapper.getAllWithChild();
		session.close();
		LOGGER.info("InvoiceDaoImpl[getItemList] end.");
		return InvoiceInfos;
	}
}
