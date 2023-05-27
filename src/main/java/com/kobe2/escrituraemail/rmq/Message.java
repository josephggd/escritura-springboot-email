package com.kobe2.escrituraemail.rmq;

import com.kobe2.escrituraemail.enums.CodePurpose;

public record Message(String email, CodePurpose purpose, String code) {
}
