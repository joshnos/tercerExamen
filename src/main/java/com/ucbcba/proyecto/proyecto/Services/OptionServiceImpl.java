package com.ucbcba.proyecto.proyecto.Services;

import com.ucbcba.proyecto.proyecto.Entities.Option;
import com.ucbcba.proyecto.proyecto.Repositories.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OptionServiceImpl implements OptionService{

    private OptionRepository optionRepository;

    @Autowired
    @Qualifier(value = "optionRepository")
    public void setOptionRepository(OptionRepository optionRepository){this.optionRepository = optionRepository;}

    @Override
    public Iterable<Option> listAllOptions() {
        return optionRepository.findAll();
    }

    @Override
    public Option getOptionById(Integer id) {
        return optionRepository.findOne(id);
    }

    @Override
    public Option saveOption(Option option) {
        return optionRepository.save(option);
    }

    @Override
    public void deleteOption(Integer id) {
        optionRepository.delete(id);
    }
}
