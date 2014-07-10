package com.idodevjobs.example.repository;

import com.idodevjobs.example.entity.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface TaskRepository extends CrudRepository<Task, Integer> {

	List<Task> findByTaskArchivedTrue();
	List<Task> findByTaskArchivedFalse();
	List<Task> findByTaskStatus(@Param("status") String taskStatus);

}
