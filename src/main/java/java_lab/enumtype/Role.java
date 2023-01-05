package java_lab.enumtype;

public enum Role {
    WEB_DESIGN("웹디자인"),
    APP_DESIGN("앱디자인"),
    PUBLISING_EDIT_DESIGN("출판/편집 디자인"),
    GAME_DESIGN("게임 디자인"),
    FREEBIE_DESIGN("판촉물 디자인"),
    THREE_DIMENSIONS_DESIGN("3D 디자인"),
    GRAPHIC_DESIGN("그래픽 디자인"),
    PACKAGE_DESIGN("패키지 디자인"),
    ART_DIRECTION("아트 디렉션"),
    ANIMATION("애니메이션"),
    LOGO_BRANDING("로고 브랜딩");

    private String desc;

    Role(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
