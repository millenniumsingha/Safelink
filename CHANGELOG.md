# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [1.0.0] - 2026-01-11

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
