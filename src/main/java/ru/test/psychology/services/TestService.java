package ru.test.psychology.services;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.test.psychology.dto.TestRequest;
import ru.test.psychology.models.Maniac;
import ru.test.psychology.models.Test;
import ru.test.psychology.models.User;
import ru.test.psychology.repositories.ManiacRepository;
import ru.test.psychology.repositories.TestRepository;
import ru.test.psychology.security.SecurityUser;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class TestService {

    private final TestRepository testRepository;
    private final ManiacRepository maniacRepository;

    public void saveTest(TestRequest test) {
        SecurityUser securityUser = (SecurityUser) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        User user = securityUser.getUser();
        List<String> maniacNames = Arrays.asList(test.getManiacs());
        List<Maniac> existingManiacs = maniacRepository.findAll();
        List<Maniac> maniacs = existingManiacs.stream()
                .filter((m) -> maniacNames.contains(m.getName().name()))
                .toList();
        Test entity = Test.builder()
                .date(test.getDate())
                .a(test.getA())
                .b(test.getB())
                .c(test.getC())
                .d(test.getD())
                .e(test.getE())
                .f(test.getF())
                .g(test.getG())
                .h(test.getH())
                .i(test.getI())
                .j(test.getJ())
                .maniacs(maniacs)
                .user(user)
                .build();
        testRepository.save(entity);
    }

    public List<TestRequest> getTests() {
        SecurityUser securityUser = (SecurityUser) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        User user = securityUser.getUser();
        List<Test> tests = user.getTests();
        return tests.stream()
                .map((t) -> TestRequest.builder()
                        .date(t.getDate())
                        .a(t.getA())
                        .b(t.getB())
                        .c(t.getC())
                        .d(t.getD())
                        .e(t.getE())
                        .f(t.getF())
                        .g(t.getG())
                        .h(t.getH())
                        .i(t.getI())
                        .j(t.getJ())
                        .maniacs(t.getManiacs().stream()
                                .map((m) -> m.getName().name())
                                .toArray(String[]::new)
                        )
                        .build()
                )
                .toList();
    }
}
