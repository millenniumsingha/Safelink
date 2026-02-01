# Contributing

Thank you for your interest in contributing to SafeLink!

## Branch Model

| Branch | Purpose |
|--------|---------|
| `master` | Production-ready code only |
| `phase/<milestone>` | Integration branch for a release |
| `feat/<desc>-<issueID>` | Feature development |
| `fix/<desc>-<issueID>` | Bug fixes |
| `docs/<desc>-<issueID>` | Documentation changes |

## Workflow

1. **Create an Issue** describing the change
2. **Create a branch** from `phase/*` (or `master` if no active phase)
3. **Make changes** with focused, minimal commits
4. **Create a Pull Request** targeting the appropriate branch
5. **Wait for CI** to pass
6. **Merge** after approval

## Commit Messages

We use [Conventional Commits](https://www.conventionalcommits.org/):

```
type(scope): subject (closes #ID)
```

**Types:** `feat`, `fix`, `docs`, `chore`, `refactor`, `test`, `ci`

**Examples:**
- `feat(auth): add oauth callback handler (closes #42)`
- `fix(api): handle empty payload safely (closes #108)`
- `docs(readme): update installation guide (closes #55)`

## Pull Request Guidelines

Every PR must include:

- **Summary** — What changed and why
- **Closes** — Link to the issue (`Closes #ID`)
- **Testing** — How it was verified
- **Risk/Rollback** — Any risks or rollback notes

## Merge Strategy

| Direction | Method | Reason |
|-----------|--------|--------|
| Feature → Phase | **Squash merge** | Keeps history clean |
| Phase → Master | **Merge commit** | Preserves release history |

## Code Style

- Follow Kotlin coding conventions
- Use meaningful variable/function names
- Keep functions small and focused
- Add KDoc for public APIs

## Questions?

Open an [issue](https://github.com/millenniumsingha/Safelink/issues) or start a discussion!
