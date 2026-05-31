module dk.sdu.cbse.common {
    requires javafx.graphics;
    requires javafx.controls;

    exports dk.sdu.cbse.common;
    exports dk.sdu.cbse.common.components;

    opens dk.sdu.cbse.common to org.mockito, org.junit.platform.commons;
    opens dk.sdu.cbse.common.components to org.mockito, org.junit.platform.commons;
}