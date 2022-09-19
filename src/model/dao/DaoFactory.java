package model.dao;

import db.DB;
import model.dao.implem.DepartmentDaoJDBC;
import model.dao.implem.SellerDaoJDBC;

public class DaoFactory {

	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}

	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJDBC(DB.getConnection());
	}
}
