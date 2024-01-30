package ru.test.psychology.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.test.psychology.dto.TestRequest;
import ru.test.psychology.dto.TestsResponse;
import ru.test.psychology.services.TestService;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class TestController {

    private final TestService service;

    @PostMapping("/test")
    public HttpStatus saveTest(
            @Valid @RequestBody TestRequest request
            ) {
        service.saveTest(request);
        return HttpStatus.OK;
    }

    @GetMapping("/tests")
    public ResponseEntity<TestsResponse> getTests() {
        TestRequest[] tests = service.getTests().toArray(TestRequest[]::new);
        return ResponseEntity.ok(
                TestsResponse.builder()
                        .tests(tests)
                        .build()
        );
    }
}
