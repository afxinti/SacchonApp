package gr.pfizer.team5.sacchonapp.controller;

import gr.pfizer.team5.sacchonapp.dto.BGL_Dto;
import gr.pfizer.team5.sacchonapp.dto.DCI_Dto;
import gr.pfizer.team5.sacchonapp.exception.RecordNotFoundException;
import gr.pfizer.team5.sacchonapp.service.MediDataVaultServices;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
@Slf4j
public class MediDataVaultController {

    private MediDataVaultServices mediDataVaultServices ;

    //BGL controller merthods


    @GetMapping("/bgl")
    public List<BGL_Dto> getBGLDto(){
        return mediDataVaultServices.readBGL();
    }

    @GetMapping("/bgl/{id}")
    public BGL_Dto getBGLDto(@PathVariable(name="id") int id) throws RecordNotFoundException {
        return mediDataVaultServices.readBGL(id);
    }

    @PostMapping("/BGL")
    public  BGL_Dto createBGLDto(@RequestBody BGL_Dto BGLDto){
        return mediDataVaultServices.createBGL(BGLDto);
    }

    @PutMapping("/BGL/{id}")
    public boolean updateBGLDto(@RequestBody BGL_Dto BGLDto,
                                         @PathVariable(name="id") int id)
    {

        return mediDataVaultServices.updateBGL(BGLDto, id);
    }

    //DCI controller methods

    @GetMapping("/DCI")
    public List<DCI_Dto> getDCIDto(){
        return mediDataVaultServices.readDCI();
    }

    @GetMapping("/DCI/{id}")
    public DCI_Dto getDCIDto(@PathVariable(name="id") int id) throws RecordNotFoundException {
        return mediDataVaultServices.readDCI(id);
    }

    @PostMapping("/DCI")
    public  DCI_Dto createDCIDto(@RequestBody DCI_Dto DCIDto){
        //log.info("The end point product has been used");
        return mediDataVaultServices.createDCI(DCIDto);
    }

    @PutMapping("/DCI/{id}")
    public boolean updateDCIDto(@RequestBody DCI_Dto DCIDto,
                                @PathVariable(name="id") int id)
    {

        return mediDataVaultServices.updateDCI(DCIDto, id);
    }
}