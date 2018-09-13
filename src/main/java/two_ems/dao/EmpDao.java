package two_ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import two_ems.emp.Emp;
import two_ems.util.DBUtil;

public class EmpDao {
	/**
	 * 获取列表
	 * @return
	 * @throws Exception
	 */
	public List<Emp> findAll() throws Exception{
		List<Emp> list = new ArrayList<Emp>();
		Emp emp = null;
		StringBuffer sql = new StringBuffer();
		try {
			Connection conn = DBUtil.getConnection();
			ResultSet rs = null;
			Statement state = conn.createStatement();
			
			sql.setLength(0);
			sql.append("SELECT M_GUID,M_ENAME,M_SALARY,M_AGE FROM A_MENG_EMS");
			rs = state.executeQuery(sql.toString());
			while(rs.next()) {
				emp = new Emp();
				emp.setId(rs.getString("M_GUID"));
				emp.setName(rs.getString("M_ENAME"));
				emp.setSalary(rs.getDouble("M_SALARY"));
				emp.setAge(rs.getInt("M_AGE"));
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			
		}
		return list;
	}
	/**
	 * 添加员工信息
	 * @throws Exception 
	 */
	public void addEmp(Emp emp) throws Exception {
		Connection conn = null;
		StringBuffer sql = new StringBuffer();
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			
			sql.setLength(0);
			sql.append("INSERT INTO A_MENG_EMS ( ")
			.append(" M_GUID,M_ENAME,M_SALARY,M_AGE ")
			.append(" ) VALUES ( ")
			.append(" ?,?,?,? ")
			.append(" ) ");
			ps = conn.prepareStatement(sql.toString());
			ps.setString(1, emp.getId());
			ps.setString(2, emp.getName());
			ps.setDouble(3, emp.getSalary());
			ps.setInt(4, emp.getAge());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(ps != null) {
				ps.close();
			}
		}
	}
	/**
	 * 删除员工信息
	 * @throws Exception 
	 */
	public void delEmp(String id) throws Exception {
		StringBuffer sql = new StringBuffer();
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			sql.append(" DELETE FROM A_MENG_EMS WHERE M_GUID = ? ");
			ps = conn.prepareStatement(sql.toString());
			ps.setString(1, id);
			ps.executeUpdate();
			System.out.println("删除成功!");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(ps != null) {
				ps.close();
			}
		}
		
	}
}
