package com.xlciie.jobapp.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(path = "/jobs")
public class JobController {
	private final JobService jobService;

	public JobController(JobService jobService) {
		this.jobService = jobService;
	}

	@GetMapping
	public ResponseEntity<List<Job>> findAllJobs() {
		List<Job> jobs = jobService.findAllJobs();
		return new ResponseEntity<>(jobs, HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Job> findJobById(@PathVariable Long id) {
		Optional<Job> job = jobService.findJobById(id);
		return job.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	public ResponseEntity<String> addJob(@RequestBody Job job) {
		jobService.addJob(job);
		return new ResponseEntity<>("Job with id " + job.getId() + " created", CREATED);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job job) {
		jobService.updateJob(id, job);
		return new ResponseEntity<>("Job with id " + id + " updated", HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> deleteJob(@PathVariable Long id) {
		jobService.deleteJob(id);
		return new ResponseEntity<>("Job with id " + id + " deleted", HttpStatus.OK);
	}
}
