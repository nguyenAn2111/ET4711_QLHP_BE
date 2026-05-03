package QLHP.app.common.enums;

import lombok.Getter;

@Getter
public enum CourseType {
    FORCE("Bắt buộc"),
    OPTIONAL("Tự chọn"),
    BASE("Cơ sở");

    private final String value;
    CourseType(String value) {this.value = value;}
}
