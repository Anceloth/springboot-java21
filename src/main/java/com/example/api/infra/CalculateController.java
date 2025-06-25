package com.example.api.infra;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.application.IUseCase;

@RestController
public class CalculateController {
	
	private final IUseCase useCase;

    public CalculateController(IUseCase useCase) {
        this.useCase = useCase;
    }
	
	@GetMapping("/calculate")
    public int calculate(
            @RequestParam int x,
            @RequestParam int y,
            @RequestParam int n) {
		
		return useCase.ejecutar(x, y, n);
		
    }

}
