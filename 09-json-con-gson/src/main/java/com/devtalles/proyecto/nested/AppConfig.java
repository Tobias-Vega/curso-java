package com.devtalles.proyecto.nested;

public class AppConfig {

    private String appName;
    private String version;
    private Settings settings;

    public AppConfig(String appName, String version, Settings settings) {
        this.appName = appName;
        this.version = version;
        this.settings = settings;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    static class Settings {
        private String theme;
        private boolean notifications;
        private String language;

        public Settings(String theme, boolean notifications, String language) {
            this.theme = theme;
            this.notifications = notifications;
            this.language = language;
        }

        public String getTheme() {
            return theme;
        }

        public void setTheme(String theme) {
            this.theme = theme;
        }

        public boolean isNotifications() {
            return notifications;
        }

        public void setNotifications(boolean notifications) {
            this.notifications = notifications;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }
    }
}
