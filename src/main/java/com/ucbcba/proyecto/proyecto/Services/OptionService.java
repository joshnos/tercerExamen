package com.ucbcba.proyecto.proyecto.Services;

import com.ucbcba.proyecto.proyecto.Entities.Option;

public interface OptionService {
    Iterable<Option> listAllOptions();
    Option getOptionById(Integer id);
    Option saveOption(Option option);
    void deleteOption(Integer id);

}
