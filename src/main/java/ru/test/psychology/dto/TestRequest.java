package ru.test.psychology.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestRequest {

    private long date;

    private int a;

    private int b;

    private int c;

    private int d;

    private int e;

    private int f;

    private int g;

    private int h;

    private int i;

    private int j;

    private String[] maniacs;
}
