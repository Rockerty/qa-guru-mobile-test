package config;

public enum DeviceHost {
    BROWSERSTACK,
    EMULATION,
    REAL;

    public static DeviceHost fromString(String value) {
        if (value == null || value.isBlank()) {
            return BROWSERSTACK;
        }

        return DeviceHost.valueOf(value.trim().toUpperCase());
    }
}