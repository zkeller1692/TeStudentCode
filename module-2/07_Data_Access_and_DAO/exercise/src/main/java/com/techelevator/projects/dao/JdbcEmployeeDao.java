package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcEmployeeDao implements EmployeeDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcEmployeeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT employee_id, first_name, last_name, birth_date, hire_date, department_id " +
				     "FROM employee;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()){
			employees.add(mapRowToEmployee(results));
		}
		return employees;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
			List<Employee> employees = new ArrayList<>();
			String sql ="SELECT employee_id, first_name, last_name, birth_date, hire_date, department_id " +
						"FROM employee " +
						"WHERE first_name ILIKE ? AND last_name ILIKE ?;";
			SqlRowSet result = jdbcTemplate.queryForRowSet(sql, '%' + firstNameSearch + '%',
					'%' + lastNameSearch + '%');
		if (firstNameSearch == null && lastNameSearch == null){
			return getAllEmployees();
		}
		while (result.next()) {
			employees.add(mapRowToEmployee(result));
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
			List<Employee> employees = new ArrayList<>();
			String sql = "SELECT employee.employee_id, first_name, last_name, birth_date, hire_date, department_id " +
						"FROM employee " +
						"JOIN project_employee ON project_employee.employee_id = employee.employee_id " +
						"WHERE project_employee.project_id = ?;";
			SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
			while (results.next()){
				employees.add(mapRowToEmployee(results));
			}
		return employees;
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		String sql = "INSERT INTO project_employee (project_id, employee_id) " +
					 "VALUES((SELECT project_id FROM project WHERE project_id = ?), (SELECT employee_id FROM employee WHERE employee_id = ?));";
		jdbcTemplate.update(sql, projectId, employeeId);
	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		String sql = "DElETE FROM project_employee WHERE project_id = ? AND employee_id = ?;";
		jdbcTemplate.update(sql,projectId, employeeId);
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT employee.employee_id, first_name, last_name, birth_date, hire_date, department_id " +
				     "FROM employee " +
					 "LEFT JOIN project_employee ON project_employee.employee_id = employee.employee_id " +
					 "WHERE project_employee.project_id IS NULL";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()){
			employees.add(mapRowToEmployee(results));
		}
		return employees;
	}

	private Employee mapRowToEmployee(SqlRowSet rowSet){
		Employee employee = new Employee();
		employee.setId(rowSet.getLong("employee_id"));
		employee.setFirstName(rowSet.getString("first_name"));
		employee.setLastName(rowSet.getString("last_name"));
		employee.setBirthDate(rowSet.getDate("birth_date").toLocalDate());
		employee.setHireDate(rowSet.getDate("hire_date").toLocalDate());
		employee.setDepartmentId(rowSet.getLong("department_id"));
		return employee;
	}
}
