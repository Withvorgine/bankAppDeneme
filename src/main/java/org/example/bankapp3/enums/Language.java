package org.example.bankapp3.enums;


import lombok.Getter;

@Getter
public enum Language {
    EN("en"),
    TR("tr");

    private final String value;


    Language(String value) {
        this.value = value;
    }
}
