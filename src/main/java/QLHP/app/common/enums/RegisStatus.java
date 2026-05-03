package QLHP.app.common.enums;

import lombok.Getter;

@Getter
public enum RegisStatus {
    WAITING("Chờ duyệt"),
    DECLINED("Từ chối"),
    APPROVED("Đã duyệt");

    private final String value;
    RegisStatus(String value) {this.value = value;}
}
