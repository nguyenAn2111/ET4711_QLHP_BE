package QLHP.app.controller.PDT;

import QLHP.app.domain.payload.request.PdtCreateRegisRequest;
import QLHP.app.domain.payload.request.SvCreateRegisRequest;
import QLHP.app.service.PDT.RegistrationService;
import QLHP.fw.web.rest.vm.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1.0/pdt/registration")
public class RegistrationController {
    private final RegistrationService registrationService;

    @GetMapping("/list-all")
    public BaseResponse<?> ListRegis(){
        log.info("Request GET /list-all");
        var response = this.registrationService.getAllRegis();
        log.info("Response from list-all is {}", response);
        return BaseResponse.ok(response);
    }

    @PostMapping("/SV/create")
    public BaseResponse<?> SvCreateRegis(@RequestBody SvCreateRegisRequest request){
        log.info("Request POST /create: {}", request);
        var response = this.registrationService.SVcreateRegis(request);
        return BaseResponse.ok(response);
    }

    @PostMapping("/PDT/create")
    public BaseResponse<?> PdtCreateRegis(@RequestBody PdtCreateRegisRequest request){
        log.info("Request POST /create: {}", request);
        var response = this.registrationService.PDTcreateRegis(request);
        return BaseResponse.ok(response);
    }

    @DeleteMapping("/{id}")
    public BaseResponse<?> DeleteRegis(@PathVariable Integer id){
        log.info("Request DELETE /{}", id);
        var response = this.registrationService.deleteRegis(id);
        return BaseResponse.ok(response);
    }

    @PutMapping("/approveAll")
    public BaseResponse<?> ApproveAllRegis(){
        log.info("Request PUT");
        var response = this.registrationService.approveAllRegis();
        return BaseResponse.ok(response);
    }

    @PutMapping("/approve")
    public BaseResponse<?> ApproveRegis(@RequestParam Integer id){
        log.info("Request PUT /{}", id);
        var response = this.registrationService.approveRegis(id);
        return BaseResponse.ok(response);
    }

    @PutMapping("/reject")
    public BaseResponse<?> RejectRegis(@RequestParam Integer id){
        log.info("Request PUT /{}", id);
        var response = this.registrationService.rejectRegisId(id);
        return BaseResponse.ok(response);
    }

    @PutMapping("/rejectAll")
    public BaseResponse<?> RejectAllRegis(){
        log.info("Request PUT");
        var response = this.registrationService.rejectAllRegis();
        return BaseResponse.ok(response);
    }
}
