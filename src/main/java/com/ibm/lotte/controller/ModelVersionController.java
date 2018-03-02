package com.ibm.lotte.controller;

import com.ibm.lotte.excption.ModelVersionConflictException;
import com.ibm.lotte.excption.NotMatchedVersionException;
import com.ibm.lotte.model.PredictVersion;
import com.ibm.lotte.model.PredictVersionQuery;
import com.ibm.lotte.repository.VersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ibm.lotte.service.HelloService;

import java.util.List;

@RestController
@RequestMapping("/model")
public class ModelVersionController {

    @Autowired
    HelloService hService;

    @Autowired
    VersionRepository versionRepository;


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public PredictVersion register(@RequestBody PredictVersionQuery versionNumber) {
        if (versionRepository.findByVersion( versionNumber.getVersion() ) != null) {
            throw new ModelVersionConflictException( "version conflict." );
        } else {
            PredictVersion pv = new PredictVersion( versionNumber.getVersion(), versionNumber.getDescription(), versionNumber.getUrl() );
            versionRepository.save( pv );
            return versionRepository.findByVersion( versionNumber.getVersion() );
        }
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<PredictVersion> getAll() {
        return versionRepository.findAll();
    }

    @RequestMapping(value = "/get/{version}", method = RequestMethod.GET)
    public PredictVersion get(@PathVariable String version) {
        return versionRepository.findByVersion( version );
    }

    @RequestMapping(value = "/remove/{version}", method = RequestMethod.DELETE)
    public void remove(@PathVariable String version) {
        if (versionRepository.findByVersion( version ) == null) {
            throw new NotMatchedVersionException( String.format( "requested version is nothing. version %s .", version ) );
        }
        versionRepository.delete( versionRepository.findByVersion( version ) );
    }


}
