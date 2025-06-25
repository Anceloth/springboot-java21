package com.example.api.infra;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.AssertTrue;

public class CalculateRequestDTO {

    @NotNull
    @Min(2)
    @Max(1_000_000_000)
    private Integer x;

    @NotNull
    @Min(0)
    private Integer y;

    @NotNull
    @Min(0)
    @Max(1_000_000_000)
    private Integer n;

    // Constraint: 0 ≤ y < x
    @AssertTrue(message = "y debe ser menor que x")
    public boolean isYMenorQueX() {
        return y != null && x != null && y < x;
    }

    // Constraint: y ≤ n
    @AssertTrue(message = "y debe ser menor o igual que n")
    public boolean isYMenorIgualN() {
        return y != null && n != null && y <= n;
    }

    // Getters y setters

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }
}
