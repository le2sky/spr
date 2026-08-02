# Repository Guidelines

## Stacked Pull Requests

- Build pull requests with GitHub Stacks. The bottom pull request targets `main`; every later pull request targets its immediate predecessor branch.
- Submit stacks with `gh stack submit --open` so every pull request is ready for review and can trigger the repository's automatic Codex review.
- After reordering, rebasing, or updating a stack, run `gh stack submit --open` again so remote base branches and pull-request diffs stay synchronized.
- Keep each pull request small and independently reviewable against its declared base branch.

## Code Review Rules

### Stacked pull-request scope

- Review only the changes introduced between the current pull request's declared base and head. Treat ancestor pull requests as context and do not duplicate findings that are confined to an ancestor diff.
- Verify that the current pull request remains correct when applied directly on its declared base. Flag hidden dependencies on later pull requests in the stack.

### Review priorities

- Focus on consequential correctness regressions, unsafe behavior, compatibility breaks, missing error handling, and missing tests for changed behavior.
- When reporting a problem, identify the concrete failure mode and a safe correction or exception.
- Leave formatting, style, and deterministic lint checks to CI.
