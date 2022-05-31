package springboot.realstate_api.service;

import org.springframework.stereotype.Service;
import springboot.realstate_api.dto.requestDto.PhotoRequestDto;
import springboot.realstate_api.dto.requestDto.PropertyRequestDto;
import springboot.realstate_api.dto.responseDto.PropertyResponseDto;

import java.util.List;
import java.util.UUID;

@Service
public interface PropertyService {
    public List<PropertyResponseDto> getProperties();
    public PropertyResponseDto addProperty(PropertyRequestDto propertyRequestDto);
    public PropertyResponseDto deleteProperty(String propertyId);
    public PropertyResponseDto editProperty(PropertyRequestDto propertyRequestDto, String propertyId);

    // Relational

}
