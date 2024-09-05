package com.xlciie.jobapp.job;

import java.util.List;
import java.util.Optional;

public interface JobService {
	List<Job> findAllJobs();

	Optional<Job> findJobById(Long id);

	void addJob(Job job);

	void updateJob(Long id, Job job);

	void deleteJob(Long id);
}
