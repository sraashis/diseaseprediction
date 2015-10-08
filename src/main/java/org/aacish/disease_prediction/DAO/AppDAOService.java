package org.aacish.disease_prediction.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.aacish.disease_prediction.model.Disease;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class AppDAOService implements AppDAO {
	private JdbcTemplate jdbc;
	
	public AppDAOService(DataSource source) {
		jdbc = new JdbcTemplate(source);
	}

	public JdbcTemplate getJdbc() {
		return jdbc;
	}

	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	public void addDisease(Disease disease) {
		String sql;
		
		sql = "insert into diseases values(?, ?)";
		jdbc.update(sql, disease.getDiseaseName(), disease.getDocCount());
		
		sql = "create table " + disease.getDiseaseName() + " ("
				+ "SYMPTOM " + "varchar(20), "
				+ "IN_DOCS " + "int, "
				+ "CONSTRAINT pk_" + disease.getDiseaseName() + " PRIMARY KEY(SYMPTOM))"; 
		jdbc.execute(sql);
	}
	
	public List<Disease> getAllDisease(){
		return jdbc.query("select * from diseases", new DiseaseMapper());
	}

	public List<Integer> symptomsInNoOfDocs(String diseaseName) {
		
		String qry = "select IN_DOCS from " + diseaseName;
		List<Integer> symInNoOfDocs = jdbc.query(qry, new RowMapper<Integer>(){

			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return rs.getInt("IN_DOCS");
			}
			
		});
		
		return symInNoOfDocs;
		
	}

	

	public Double getPrior(Disease disease) {
		
		Double totalDocs = jdbc.queryForObject("select SUM(DOC_COUNT) from diseases", Double.class);
		return disease.getDocCount()/totalDocs;
		
	}

	public boolean isNewDisease(String diseaseName) {
		Integer cnt = jdbc.queryForObject("select COUNT(*) from diseases where disease_name = '" + diseaseName + "'", Integer.class);
		return !(cnt!=null && cnt > 0);
	}

	public void setSymptomsInNoOfDocs(String tableName, String symptom, Integer sympInNoOfDocs) {
		jdbc.update("insert into " + tableName + " values(?,?)", symptom, sympInNoOfDocs);
	}

	@Override
	public void deleteDisease(Disease disease) {
		// TODO Auto-generated method stub
		jdbc.update("delete from diseases where disease_name = '" + disease.diseaseName + "'");
		
	}

	@Override
	public void addAboutDisease(String diseaseName, String about) {
		about= about.replace("(", "[");
		about= about.replace(")", "]");
		jdbc.update("insert into about values(?,?)",diseaseName, about);
		
	}

	@Override
	public String getAboutDisease(Disease disease) {
		String sql="select about_disease from about where disease_name='" + disease.diseaseName + "'";
		String result="test";
		result = jdbc.queryForObject(sql, String.class);
		
		return result;
	}

	@Override
	public void deleteAboutDisease(Disease disease) {
		String sql= "delete from about where disease_name='"+disease.getDiseaseName()+"'";
		jdbc.update(sql);
		
	}
}
