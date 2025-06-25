package com.example.api.infra;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.application.IUseCase;

import jakarta.validation.Valid;

@RestController
public class CalculateController {
	
	private final IUseCase useCase;

    public CalculateController(IUseCase useCase) {
        this.useCase = useCase;
    }
	
	@GetMapping("/calculate")
    public int calculate(@Valid @ModelAttribute CalculateRequestDTO request) {
		
		return useCase.ejecutar(request.getX(), request.getY(), request.getN());
		
    }

}
