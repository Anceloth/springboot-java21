package com.example.api.application;

import org.springframework.stereotype.Service;

/**
 *  Encuentra el máximo k tal que 0 ≤ k ≤ n y k % x == y.     
 */
@Service
public class CalculateUseCase implements IUseCase{
	
	@Override
	public int ejecutar(int x, int y, int n) {
		
		// El mayor múltiplo de x menor o igual a n-y, luego sumamos y
        int k = ((n - y) / x) * x + y;
        return k;
	}

}
