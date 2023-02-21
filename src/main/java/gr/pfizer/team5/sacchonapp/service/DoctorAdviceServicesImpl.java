package gr.pfizer.team5.sacchonapp.service;

import gr.pfizer.team5.sacchonapp.dto.ConsultationDto;
import gr.pfizer.team5.sacchonapp.model.Consultation;
import gr.pfizer.team5.sacchonapp.repository.ConsultationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DoctorAdviceServicesImpl implements DoctorAdviceServices{

    private final ConsultationRepository consultationRepository;








    //------------------------------------SERVICES FOR CONSULTATION-------------------------------------------
    @Override
    public ConsultationDto createConsultation(ConsultationDto consultationDto) {
        //validation
        Consultation consultation = consultationDto.asConsultation();
        return new ConsultationDto(consultationRepository.save(consultation)) ;

    }

    @Override
    public List<ConsultationDto> readConsultation() {
        return consultationRepository
                .findAll()
                .stream()
                .map(CustomerDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public ConsultationDto readConsultation(int id) throws MyException {
        return new ConsultationDto( readConsultationDb(id));
    }

    private Consultation readConsultationDb(int id) throws MyException {
        Optional<Consultation> consultationOptional = consultationRepository.findById(id);
        if (consultationOptional.isPresent())
            return consultationOptional.get() ;
        throw new MyException("Consultation not found id= " + id);
    }


    @Override
    public boolean updateConsultation(ConsultationDto consultation, int id) {

        boolean action;
        try {
            Consultation dbConsultation = readConsultationDb(id);
            dbConsultation.setDate(consultation.getDate());
            dbConsultation.setNameOfMedication(consultation.getNameOfMedication());
            dbConsultation.setDosage(consultation.getDosage());
            dbConsultation.setNotes(consultation.getNotes());
            dbConsultation.setDoctorName(consultation.getDoctorName());
            consultationRepository.save(dbConsultation);
            action = true;
        } catch (MyException e) {
            action = false;
        }
        return action;
    }





    @Override
    public String ping() {
        return "hello Sacchon Doctor";
    }
}
