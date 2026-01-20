## Summary
Updated `.github/workflows/ci.yml` to include `phase-*` in the branch triggers. This ensures that branches like `phase-2-planning` (hyphenated) trigger the CI pipeline, which previously only matched `phase/*` (slash-separated).

## Closes
Closes #31

## Testing
- [x] Unit tests passed (N/A)
- [x] Manual verification:
  > Opened this PR targeting `phase-2-planning`.
  > Verified that CI checks appear and run on this PR.

## Risk/Rollback
Low risk. Config change only.
