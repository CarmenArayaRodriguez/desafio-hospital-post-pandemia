package cl.praxis.ProyectoHospitalPostPandemia.controller;

import cl.praxis.ProyectoHospitalPostPandemia.model.Patient;
import cl.praxis.ProyectoHospitalPostPandemia.service.PatientService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.slf4j.Logger;

@Controller
public class PatientController {
    private static final Logger logger = LoggerFactory.getLogger(PatientController.class);

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
        logger.info("PatientController instanciado y PatientService inyectado");
    }

    @GetMapping("/patients")
    public String listPatients(Model model) {
        List<Patient> patients = patientService.findAll();
        logger.info("Listando pacientes");
        model.addAttribute("patients", patients);
        return "patients";
    }
}

