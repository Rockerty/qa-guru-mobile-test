# QA Guru Mobile Tests

Мобильные автотесты Wikipedia Alpha на Android.

## Стек

Java, JUnit 5, Selenide, Selenide Appium, Appium, UiAutomator2, Owner, Allure, Gradle.

## Подготовка

Должны быть установлены:

- Android Studio / Android SDK
- Node.js / npm
- Appium
- UiAutomator2 driver

```bash
npm install -g appium@next
appium driver install uiautomator2
```

Перед локальным запуском должен быть запущен Appium Server:

```bash
appium server --base-path /wd/hub
```

Проверка устройств:

```bash
adb devices
```

## APK

APK не хранится в git.

Файл нужно скачать и положить сюда:

```text
src/test/resources/apps/app-alpha-universal-release.apk
```

APK должен быть добавлен в `.gitignore`:

```gitignore
src/test/resources/apps/*.apk
```

## Конфигурации

Для каждого окружения есть свой properties-файл, Owner config и driver:

```text
browserstack.properties → BrowserstackConfig → BrowserstackDriver
emulation.properties    → EmulationConfig    → EmulationDriver
real.properties         → RealConfig         → RealDriver
```

Окружение выбирается через:

```bash
-DdeviceHost=browserstack
-DdeviceHost=emulation
-DdeviceHost=real
```

## Запуск

На эмуляторе:

```powershell
.\gradlew clean test -DdeviceHost=emulation
```

Конкретный тест на эмуляторе:

```powershell
.\gradlew clean test --tests "tests.browserstack.SearchTests" -DdeviceHost=emulation
```

Onboarding-тест:

```powershell
.\gradlew clean test --tests "tests.browserstack.OnboardingTests" -DdeviceHost=emulation
```

На реальном телефоне:

```powershell
.\gradlew clean test --tests "tests.browserstack.SearchTests" -DdeviceHost=real
```

На BrowserStack:

```powershell
.\gradlew clean test -DdeviceHost=browserstack
```
