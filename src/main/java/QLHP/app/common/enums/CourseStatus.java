package QLHP.app.common.enums;

import lombok.Getter;

@Getter
public enum CourseStatus {
    OPEN("OPEN"),
    CLOSED("CLOSED");

    private final String value;
    CourseStatus(String value) {this.value = value;}
}
