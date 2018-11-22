package com.haotian9850.sfpetclinic.services.map;

import com.haotian9850.sfpetclinic.model.Visit;
import com.haotian9850.sfpetclinic.services.VisitService;

import java.awt.image.VolatileImage;
import java.util.Set;

public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(Visit visit) {
        if(visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null || visit.getPet().getOwner() == null){
            throw new RuntimeException("Invalid visit!");
        }
        return null;
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
