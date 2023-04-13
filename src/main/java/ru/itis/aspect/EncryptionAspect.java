package ru.itis.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class EncryptionAspect {

    private final BCryptPasswordEncoder encoder;
    @Pointcut("@annotation(Encrypt)")
    public void encryption() {
    }

    @Around("encryption()")
    public Object encrypt(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof String) {
                String encryptedData = encoder.encode((String) args[i]);
                args[i] = encryptedData;
            }
        }
        return args;
    }
}