package com.example.hospital;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospital.entity.DoctorEntity;




@RestController
@RequestMapping("/api/v1")
public class DoctorController {
    @Autowired
    private DoctorRepository eRepo;

    @GetMapping("/doctors")
    public List<DoctorEntity> getallDoctors() {
        return eRepo.findAll();
    }

    @GetMapping("/doctors/{id}")
    public ResponseEntity<DoctorEntity> getDoctorById(@PathVariable(value = "id") Long DoctorId)
        throws ResourceNotFoundException {
        DoctorEntity Doctor = eRepo.findById(DoctorId)
          .orElseThrow(() -> new ResourceNotFoundException("Doctors not found for this id :: " + DoctorId));
        return ResponseEntity.ok().body(Doctor);
    }
    
    @PostMapping("/doctors")
    public DoctorEntity createDoctor(@Valid @RequestBody DoctorEntity Doctor) {
        return eRepo.save(Doctor);
    }

    @PutMapping("/doctors/{id}")
    public ResponseEntity<DoctorEntity> updateDoctor(@PathVariable(value = "id") Long DoctorId,
         @Valid @RequestBody DoctorEntity DoctorDetails) throws ResourceNotFoundException {
        DoctorEntity Doctor = eRepo.findById(DoctorId)
        .orElseThrow(() -> new ResourceNotFoundException("Doctors not found for this id :: " + DoctorId));

        Doctor.setName(DoctorDetails.getName());
        Doctor.setSalary(DoctorDetails.getSalary());
        Doctor.setSpecialist(DoctorDetails.getSpecialist());
        final DoctorEntity updatedDoctor = eRepo.save(Doctor);
        return ResponseEntity.ok(updatedDoctor);
    }
    
    @PutMapping("/doctors/id={id}/salary={salary}")
    public ResponseEntity<DoctorEntity> updatesalary(@PathVariable(value = "id") Long DoctorId, @PathVariable(value = "salary") Double DSalary,
         @Valid @RequestBody DoctorEntity DoctorDetails) throws ResourceNotFoundException {
        DoctorEntity Doctor = eRepo.findById(DoctorId)
        .orElseThrow(() -> new ResourceNotFoundException("Doctors not found for this id :: " + DoctorId));

        Doctor.setSalary(DSalary);
        final DoctorEntity updatedDoctor = eRepo.save(Doctor);
        return ResponseEntity.ok(updatedDoctor);
    }

    @DeleteMapping("/doctors/{id}")
    public Map<String, Boolean> deleteDoctor(@PathVariable(value = "id") Long DoctorId)
         throws ResourceNotFoundException {
        DoctorEntity Doctor = eRepo.findById(DoctorId)
       .orElseThrow(() -> new ResourceNotFoundException("Doctor not found for this id :: " + DoctorId));

        eRepo.delete(Doctor);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}