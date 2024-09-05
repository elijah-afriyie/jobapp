package com.xlciie.jobapp.job.impl;

import com.xlciie.jobapp.job.Job;
import com.xlciie.jobapp.job.JobRepository;
import com.xlciie.jobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
	private final JobRepository jobRepository;

	public JobServiceImpl(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}

	@Override
	public List<Job> findAllJobs() {
		try {
			return jobRepository.findAll();
		} catch (Exception e) {
			throw new RuntimeException("Error finding all jobs. Please try again.");
		}
	}

	@Override
	public Optional<Job> findJobById(Long id) {
		Optional<Job> job = jobRepository.findById(id);
		if (job.isPresent()) {
			return job;
		} else {
			throw new RuntimeException("Error finding job with id " + id + ". Please try again.");
		}
	}

	@Override
	public void addJob(Job job) {
		try {
			jobRepository.save(job);
		} catch (Exception e) {
			throw new RuntimeException("Error adding job. Please try again.");
		}
	}

	@Override
	public void updateJob(Long id, Job updatedJob) {
		Optional<Job> existingJob = jobRepository.findById(id);
		if (existingJob.isPresent()) {
			Job job = existingJob.get();

			job.setTitle(updatedJob.getTitle());
			job.setDescription(updatedJob.getDescription());
			job.setMinSalary(updatedJob.getMinSalary());
			job.setMaxSalary(updatedJob.getMaxSalary());
			job.setLocation(updatedJob.getLocation());

			jobRepository.save(job);
		} else {
			throw new RuntimeException("Error updating job. Job with id " + id + " does not exist. Please try again.");
		}
	}

	@Override
	public void deleteJob(Long id) {
		Optional<Job> job = jobRepository.findById(id);
		if (job.isPresent()) {
			jobRepository.delete(job.get());
		} else {
			throw new RuntimeException("Error deleting job. Job with id " + id + " does not exist. Please try again");
		}
	}
}
