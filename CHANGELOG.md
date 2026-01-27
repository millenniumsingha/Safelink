# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [v2.0.1] - 2026-01-27
### Security
- **Dependabot**: Resolved 22 transitive dependency alerts involving Netty, BouncyCastle, and others via Gradle `resolutionStrategy` constraints (Issue #76).
- **Hardening**: Configured `dependabot.yml` to prevent incompatible KMP version updates while keeping security alerts enabled (Issue #83).
- **CodeQL**: Added advanced CodeQL analysis workflow (`codeql.yml`) for deeper security scanning (Issue #74).
- **Actions**: Added explicit workflow permissions and dependency submission for better security graph visibility (Issue #66).

### Documentation
- **README**: Added detailed permission usage for Android/iOS (Issue #60).
- **README**: Added project roadmap and clarified iOS platform status (Issue #62, #64).



## [v2.0.0] - 2026-01-24
### Added
- **Architecture**: Complete migration to Kotlin Multiplatform (KMP).
- **Platforms**: Support for Android, Desktop (JVM), and iOS (structure ready).
- **UI**: Jetpack Compose Multiplatform UI with shared components.
- **Data**: SQLDelight database for persisting contacts and settings.
- **DI**: Koin dependency injection across all platforms.
- **Features**: Runtime permission handling for SOS functionality.

### Changed
- **Project Structure**: Reorganized into `composeApp/`, `shared/`, and `iosApp/` modules.
- **CI**: Updated artifact upload path for new structure.

### Removed
- **Legacy**: Archived old Android-only code to `legacy/` (now deleted).

## [v1.0.2] - 2026-01-15
### Changed
- **Governance**: Migrated all operational logic from `standard_workflow.md` to `.cursorrules` for active enforcement.
- **Rules**: Hardened `.cursorrules` with:
    - Strict Checkbox ("Definition of Done") Policy.
    - Post-Merge CI Validation ("Green Master") Policy.
    - Mandatory `--body-file` usage for GH CLI to prevent formatting errors.
    - Automatic branch cleanup (`--delete-branch`).

### Removed
- **Docs**: Deleted redundant `.agent/workflows/standard_workflow.md`.

## [v1.0.1] - 2026-01-11
### Fixed
- **Build System**: Upgraded Gradle to 8.5 and AGP to 8.2.2 for modern JDK support (Issue #14).
- **Compliance**: Fixed API 34 strict Manifest requirements (`android:exported`) and Lint/ChromeOS permission errors.
- **Hygiene**: Removed local `.vscode` settings from git tracking (Issue #16).

## [v1.0.0] - 2026-01-11

### Added
- **CI/CD**: GitHub Actions pipeline for automated builds and APK generation (`.github/workflows/ci.yml`).
- **Docs**: New `standard_workflow.md` defining strict operational protocols.

### Fixed
- **Build**: Resolved Gradle build errors by restoring `gradlew` (shell) and `gradlew.bat` (batch) scripts.
- **Build**: Added `local.properties` configuration for Android SDK location.
- **Docs**: Fixed broken absolute image links in `README.md`.
- **Git**: Updated `.gitignore` to exclude agent artifacts.

### Changed
- **Workflow**: Enforced strict one-issue-per-PR policy and mandatory assignments.
