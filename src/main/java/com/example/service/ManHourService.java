package com.example.service;

import com.example.domain.ManHour;
import com.example.repository.ManHourRepository;
import com.example.util.DateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ManHourService {
    @Autowired
    ManHourRepository manHourRepository;

    public List<ManHour> findAll() {
    	Date startDate = DateUtil.getStartNendoDate(new Date());
    	Date endDate = DateUtil.getEndNendoDate(new Date());
        return manHourRepository.findAllManHourDateBetweenOrderByName(startDate, endDate);
//        return manHourRepository.findAllOrderByName();
    }
    
    public HashMap<String, HashMap<String, HashMap<String, Double>>> findAllManHourList() {
    	Date startDate = DateUtil.getStartNendoDate(new Date());
    	Date endDate = DateUtil.getEndNendoDate(new Date());
    	List<ManHour> manHourList = manHourRepository.findAllManHourDateBetweenOrderByName(startDate, endDate);
    	HashMap<String,HashMap<String,HashMap<String,Double>>> manHourMapList = new HashMap<String,HashMap<String,HashMap<String,Double>>>();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
    	for(ManHour manHour: manHourList){
    		if(!manHourMapList.containsKey(manHour.getProjectCd())){
    			HashMap<String, HashMap<String, Double>> manHourMemberMap = new HashMap<String, HashMap<String, Double>>();
    			HashMap<String, Double> manHourMap = new HashMap<String, Double>();
    			manHourMap.put(sdf.format(manHour.getManHourDate()), manHour.getManHour());
    			manHourMemberMap.put(manHour.getMember().getLastname() + " " + manHour.getMember().getFirstname(), manHourMap);
    			manHourMapList.put(manHour.getProjectCd(), manHourMemberMap);
    		}else{
    			if(manHourMapList.get(manHour.getProjectCd()).containsKey(manHour.getMember().getLastname() + " " + manHour.getMember().getFirstname())){
    				HashMap<String, HashMap<String, Double>> manHourMemberMap = new HashMap<String, HashMap<String, Double>>();
    				HashMap<String, Double> manHourMap = new HashMap<String, Double>();
    				manHourMap.put(sdf.format(manHour.getManHourDate()), manHour.getManHour());
    				manHourMemberMap.put(manHour.getMember().getLastname() + " " + manHour.getMember().getFirstname(), manHourMap);
    				manHourMapList.put(manHour.getProjectCd(), manHourMemberMap);
    			}else{
    				HashMap<String, Double> manHourMap = manHourMapList.get(manHour.getProjectCd()).get(manHour.getMember().getLastname() + " " + manHour.getMember().getFirstname());
    				manHourMap.put(sdf.format(manHour.getManHourDate()), manHour.getManHour());
    			}
    			
    		}
    	}
    	return manHourMapList;
//        return manHourRepository.findAllOrderByName();
    }

    public ManHour findOne(Integer id) {
        return manHourRepository.findOne(id);
    }

    public ManHour create(ManHour manHour) {
        return manHourRepository.save(manHour);
    }

    public ManHour update(ManHour manHour) {
        return manHourRepository.save(manHour);
    }

    public void delete(Integer id) {
        manHourRepository.delete(id);
    }
}
