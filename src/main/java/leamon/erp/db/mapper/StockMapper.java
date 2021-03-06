package leamon.erp.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import leamon.erp.model.StockItem;

/**
 * @author Leamon India
 * @date 29 MAY, 2017
 */
public interface StockMapper {
	final String getAll = "SELECT * FROM STOCK_ITEM WHERE ISENABLE = TRUE ORDER BY ID"; 
	final String getById = "SELECT * FROM STOCK_ITEM WHERE ID = #{id}";
	
	final String insert = "INSERT INTO STOCK_ITEM (NAME, PRODUCTCODE, SIZE, UNIT, FINISH, SHAPE, SALE_UNIT, DESCRIPTION, IMAGEPATH, CREATEDDATE, LASTUPDATEDDATE, ISENABLE) "
						+ "VALUES (#{name}, #{productCode}, #{size}, #{unit}, #{finish}, #{shape}, #{saleunit}, #{description}, #{imagePath}, #{createdDate}, #{lastUpdatedDate}, #{isEnable} )";
	
	final String update = "UPDATE STOCK_ITEM SET NAME = #{name}, PRODUCTCODE = #{productCode}, SIZE = #{size}, UNIT = #{unit}, "
						+ "FINISH = #{finish}, SHAPE = #{shape}, SALE_UNIT = #{saleunit}, "
						+ "DESCRIPTION = #{description}, IMAGEPATH = #{imagePath}, LASTUPDATEDDATE = #{lastUpdatedDate}  WHERE ID = #{id}";
	
	final String deleteById = "DELETE from STOCK_ITEM WHERE ID = #{id}";
	
	final String disableByID = "UPDATE STOCK_ITEM SET ISENABLE = FALSE WHERE ID = #{id}";
	
	//@Options(flushCache= FlushCachePolicy.TRUE)
	@Select(getAll)
	   @Results(value = {
	      @Result(property = "id", column = "ID"),
	      @Result(property = "name", column = "NAME"),
	      @Result(property = "productCode", column = "PRODUCTCODE"),
	      @Result(property = "size", column = "SIZE"),
	      @Result(property = "unit", column = "UNIT"),
	      @Result(property = "finish", column = "FINISH"),
	      @Result(property = "shape", column = "SHAPE"),
	      @Result(property = "saleunit", column = "SALE_UNIT"),
	      @Result(property = "description", column = "DESCRIPTION"),
	      @Result(property = "imagePath", column = "IMAGEPATH"),
	      @Result(property = "isEnable", column = "ISENABLE"),
	      @Result(property = "createdDate", column = "CREATEDDATE"),
	      @Result(property = "lastUpdatedDate", column = "LASTUPDATEDDATE")
	      
	})
	public List<StockItem> getAll() throws Exception;
	
	

	@Update(update)
	void update(StockItem stock) throws Exception;

	@Update(disableByID)
	void disableStockByID(StockItem stock) throws Exception;
	
	@Delete(deleteById)
	void delete(int id) throws Exception;
	  
	@Insert(insert)
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void insert(StockItem stockItem) throws Exception;
	
}
