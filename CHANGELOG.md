# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

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
