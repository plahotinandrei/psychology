package ru.test.psychology.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.test.psychology.dto.TestRequest;
import ru.test.psychology.dto.TestsResponse;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class TestController {

    @PostMapping("/test")
    public String saveTest(
            @Valid @RequestBody TestRequest request
            ) {
        System.out.println(request);
        return "Ok";
    }

    @GetMapping("/tests")
    public ResponseEntity<TestsResponse> getTests() {
        TestRequest t1 = TestRequest.builder()
                .date(111)
                .a(1).b(1).c(1).d(1).e(1).f(1).g(1).h(1).i(1).j(1)
                .maniacs(new String[]{"A", "B"})
                .build();
        TestRequest t2 = TestRequest.builder()
                .date(222)
                .a(2).b(2).c(2).d(2).e(2).f(2).g(2).h(2).i(2).j(2)
                .maniacs(new String[]{"C", "D"})
                .build();
        return ResponseEntity.ok(
                TestsResponse.builder()
                        .tests(new TestRequest[]{t1, t2})
                        .build()
        );
    }
}
