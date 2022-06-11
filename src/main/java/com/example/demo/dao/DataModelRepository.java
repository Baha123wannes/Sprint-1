package com.example.demo.dao;
import com.example.demo.Model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Element;

@Repository
public interface DataModelRepository extends JpaRepository<DataModel,Integer> {
		public List<DataModel> findAll();
		public Optional<DataModel> findById(int id);
		public List<DataModel> findByVersion(@Param("version")int version);
		public DataModel findByDateCreation(@Param("dateCreation")LocalDate dateCreation);
		/*public DataModel save(DataModel d);
	*/
		public DataModel findByName(@Param("name")String name);
		public DataModel findByUserName(String d);
		public Optional<DataModel> deleteByName(String dataModel);
		
}
