package com.example.multipleDB.MultipleDB;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.multipleDB.MultipleDB.admissions.Admission;
import com.example.multipleDB.MultipleDB.admissions.AdmissionRepository;
import com.example.multipleDB.MultipleDB.appointments.AppointmentRepository;
import com.example.multipleDB.MultipleDB.appointments.Appointments;

@SpringBootApplication
@RestController
public class MultipleDbApplication {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private AdmissionRepository admissionRepository;

	// for Appointment Entity
	@PostConstruct
	public void addAppointmentsData() {
		appointmentRepository.saveAll(Stream.of(new Appointments(101, "Teh first appointment ever"),
				new Appointments(102, "Appointment with a Dentist")).collect(Collectors.toList()));
	}

	@GetMapping("/getAppointments")
	public List<Appointments> getAppointmens() {

		return appointmentRepository.findAll();
	}

	// for Admission Entity
	@PostConstruct
	public void addAdmissionData() {
		admissionRepository.saveAll(
				Stream.of(new Admission(101, "Teh first admission ever"), new Admission(102, "Admission for  student"))
						.collect(Collectors.toList()));
	}

	@GetMapping("/getAdmissions")
	public List<Admission> getAsmissions() {

		return admissionRepository.findAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(MultipleDbApplication.class, args);
	}

}
